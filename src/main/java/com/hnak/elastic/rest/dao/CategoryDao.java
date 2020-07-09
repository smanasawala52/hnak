package com.hnak.elastic.rest.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.validator.GenericValidator;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnak.emis.modal.AttributesModal;
import com.hnak.emis.modal.CategoryModal;
import com.hnak.emis.modal.CategoryParent;
import com.hnak.emis.modal.CategoryUIModel;
import com.hnak.emis.modal.Locale;

@Service
public class CategoryDao {

	@Autowired
	private RestHighLevelClient restHighLevelClient;

	@Autowired
	private ObjectMapper objectMapper;

	private String catIndexName = "hnak_category";

	public CategoryModal insertCategory(CategoryModal category) {
		if (restHighLevelClient == null || category == null) {
			System.out.println("oops");
			return null;
		}

		category = addImmediateParent(category, null, false);
		Map dataMap = objectMapper.convertValue(category, Map.class);
		try {
			IndexRequest indexRequest = new IndexRequest(catIndexName).id(String.valueOf(category.getId()))
					.source(dataMap);
			IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return category;
	}

	public CategoryModal updateCategory(CategoryModal inputCategory) {
		if (restHighLevelClient == null || inputCategory == null
				|| (inputCategory != null && inputCategory.getId() == 0)) {
			System.out.println("oops");
			return null;
		}
		CategoryModal category = getCategoryRaw(inputCategory.getId());
		if (category == null) {
			return insertCategory(inputCategory);
		}

		boolean isParentRemoved = false;
		boolean isParentAdded = false;
		boolean isParentChanged = false;
		// added category have immediate parent but its removed from the input
		// category
		if (category.getParentId() > 0 && inputCategory.getParentId() == 0) {
			isParentRemoved = true;
		} else if (category.getParentId() == 0 && inputCategory.getParentId() > 0) {
			isParentAdded = true;
		} else if (category.getParentId() > 0 && inputCategory.getParentId() > 0
				&& category.getParentId() != inputCategory.getParentId()) {
			isParentChanged = true;
		}

		if (isParentAdded) {
			category = addImmediateParent(category, null, false);
		} else if (isParentRemoved) {
			category = removeImmediateParent(category);
		} else if (isParentChanged) {
			category = removeImmediateParent(category);
			category.setParentId(inputCategory.getParentId());
			// System.out.println("inputCategory.getParentId(): " +
			// inputCategory.getParentId());
			// System.out.println("category.getChildern(): " +
			// category.getChildern());

			// Map inputCategoryTest = objectMapper.convertValue(inputCategory,
			// Map.class);
			// System.out.println("inputCategoryTest: " + inputCategoryTest);
			//
			category = addImmediateParent(category, null, false);
		}
		inputCategory.setChildern(category.getChildern());
		inputCategory.setParents(category.getParents());

		Map dataMap = objectMapper.convertValue(inputCategory, Map.class);
		try {
			IndexRequest indexRequest = new IndexRequest(catIndexName).id(String.valueOf(inputCategory.getId()))
					.source(dataMap);
			IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return inputCategory;
	}

	private CategoryModal removeImmediateParent(CategoryModal inputCategory) {
		if (inputCategory != null && inputCategory.getId() > 0 && inputCategory.getParentId() > 0) {
			int catToRemove = inputCategory.getParentId();
			CategoryModal immediateParent = getCategoryRaw(catToRemove);

			// remove current category from the immediate parent children list
			if (immediateParent != null && immediateParent.getId() > 0
					&& !CollectionUtils.isEmpty(immediateParent.getChildern())) {
				// remove current category from children of parent
				SortedSet<Integer> childSet = new TreeSet<>();
				// StringTokenizer st = new
				// StringTokenizer(immediateParent.getChildern(), ",");
				// while (st.hasMoreTokens()) {
				// String tempChildCat = st.nextToken();
				for (int tempChildCat : immediateParent.getChildern()) {
					if (inputCategory.getId() != tempChildCat) {
						childSet.add(tempChildCat);
					}
				}
				// String pre = "";
				// StringBuilder sb = new StringBuilder();
				// if (!CollectionUtils.isEmpty(childSet)) {
				// for (String tempChildCat : childSet) {
				// sb.append(pre).append(tempChildCat);
				// pre = ",";
				// }
				// }
				immediateParent.setChildern(new ArrayList<>(childSet));
				Map dataMapImmediateParent = objectMapper.convertValue(immediateParent, Map.class);
				try {
					IndexRequest indexRequest = new IndexRequest(catIndexName)
							.id(String.valueOf(immediateParent.getId())).source(dataMapImmediateParent);
					IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			//

			// loop through all the children and remove parent, need to
			// think about grand children as well
			if (!CollectionUtils.isEmpty(inputCategory.getChildern())) {
				SortedSet<Integer> currentCatChildSet = new TreeSet<>(inputCategory.getChildern());
				// StringTokenizer st = new
				// StringTokenizer(inputCategory.getChildern(), ",");
				// while (st.hasMoreTokens()) {
				// String tempChildCat = st.nextToken();
				// currentCatChildSet.add(tempChildCat);
				// }
				// iterate all children and remove parent
				if (!CollectionUtils.isEmpty(currentCatChildSet)) {
					for (int currentCatChildId : currentCatChildSet) {
						CategoryModal currentCatChild = getCategoryRaw(currentCatChildId);
						if (currentCatChild != null && currentCatChild.getId() > 0
								&& inputCategory.getId() == currentCatChild.getParentId()
								&& !CollectionUtils.isEmpty(currentCatChild.getParents())) {
							Iterator<CategoryParent> itr = currentCatChild.getParents().iterator();
							while (itr.hasNext()) {
								CategoryParent tempParent = itr.next();
								if (tempParent.getId() == inputCategory.getId()) {
									itr.remove();
								}
							}
							// remove input category from the parent and
							// save currentCatChild
							currentCatChild.setParentId(0);
							currentCatChild.setParents(null);
							Map dataMapCurrentCatChild = objectMapper.convertValue(currentCatChild, Map.class);
							try {
								IndexRequest indexRequest = new IndexRequest(catIndexName)
										.id(String.valueOf(currentCatChild.getId())).source(dataMapCurrentCatChild);
								IndexResponse response = restHighLevelClient.index(indexRequest,
										RequestOptions.DEFAULT);
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
				}
			}
			inputCategory.setParentId(0);
		}
		return inputCategory;
	}

	private CategoryModal addImmediateParent(CategoryModal inputCategory,
			List<CategoryParent> parentsForUpdateOperation, boolean bRecurion) {
		if (inputCategory != null && inputCategory.getParentId() > 0) {
			// get the parent object and set the child also update it
			CategoryModal immediateParent = getCategoryRaw(inputCategory.getParentId());
			// Map inputCategoryTest = objectMapper.convertValue(inputCategory,
			// Map.class);
			// System.out.println("immediateParent:inputCategoryTest: " +
			// inputCategoryTest);

			if (immediateParent != null && immediateParent.getId() > 0) {
				List<Integer> children = new ArrayList<>();
				if (!CollectionUtils.isEmpty(immediateParent.getChildern())) {
					// set children to parent
					SortedSet<Integer> childSet = new TreeSet<>(immediateParent.getChildern());
					// StringTokenizer st = new
					// StringTokenizer(immediateParent.getChildern(), ",");
					// for (Integer tempChildCat :
					// immediateParent.getChildern()) {
					// // String tempChildCat = st.nextToken();
					// childSet.add(tempChildCat);
					// }
					childSet.add(inputCategory.getId());
					children = new ArrayList<>(childSet);
					// String pre = "";
					// StringBuilder sb = new StringBuilder();
					// for (Integer tempChildCat : childSet) {
					// sb.append(pre).append(tempChildCat);
					// pre = ",";
					// }
					// children = sb.toString();
				} else {
					children = new ArrayList<>();
					children.add(inputCategory.getId());
				}
				immediateParent.setChildern(children);

				// set parent to childern
				// update temps
				if (bRecurion) {
					immediateParent.setParents(parentsForUpdateOperation);
				}
				//
				List<CategoryParent> parents = new ArrayList<>();
				CategoryParent parentSeq = new CategoryParent();
				// parentSeq.setCatCode(immediateParent.getCatCode());
				parentSeq.setId(immediateParent.getId());
				if (!CollectionUtils.isEmpty(immediateParent.getParents())) {
					parents.addAll(immediateParent.getParents());
					Collections.sort(parents, new CategoryParentComparator());
					Collections.reverse(parents);
					parentSeq.setSeq(parents.get(0).getSeq() + 1);

				} else {
					parentSeq.setSeq(1);
				}
				boolean bAlreadyExistsCatParentSeq = false;
				for (CategoryParent tempParent : parents) {
					if (tempParent.getId() == immediateParent.getId()) {
						bAlreadyExistsCatParentSeq = true;
						break;
					}
				}
				if (!bAlreadyExistsCatParentSeq) {
					parents.add(parentSeq);
				}
				inputCategory.setParents(parents);
				Map dataMapImmediateParent = objectMapper.convertValue(immediateParent, Map.class);
				try {
					IndexRequest indexRequest = new IndexRequest(catIndexName)
							.id(String.valueOf(immediateParent.getId())).source(dataMapImmediateParent);
					IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		// loop through all the children and add immediate parent
		if (!CollectionUtils.isEmpty(inputCategory.getChildern())) {
			SortedSet<Integer> currentCatChildSet = new TreeSet<>(inputCategory.getChildern());
			// StringTokenizer st = new
			// StringTokenizer(inputCategory.getChildern(), ",");
			// while (st.hasMoreTokens()) {
			// String tempChildCat = st.nextToken();
			// currentCatChildSet.add(tempChildCat);
			// }
			// iterate all children and remove parent
			if (!CollectionUtils.isEmpty(currentCatChildSet)) {
				for (int currentCatChildId : currentCatChildSet) {
					CategoryModal currentCatChild = getCategoryRaw(currentCatChildId);
					if (currentCatChild != null && currentCatChild.getId() > 0
							&& inputCategory.getId() != currentCatChild.getParentId()) {
						// add input category from the parent and
						// save currentCatChild
						currentCatChild.setParentId(inputCategory.getId());
						// System.out.println("currentCatChild: " +
						// currentCatChild.getId() + " immediateParent: "
						// + currentCatChild.getParentId());
						currentCatChild = addImmediateParent(currentCatChild, inputCategory.getParents(), true);
						Map dataMapCurrentCatChild = objectMapper.convertValue(currentCatChild, Map.class);
						try {
							IndexRequest indexRequest = new IndexRequest(catIndexName)
									.id(String.valueOf(currentCatChild.getId())).source(dataMapCurrentCatChild);
							IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
						} catch (Exception ex) {
							ex.printStackTrace();
						}

					}
				}
			}
		}
		return inputCategory;
	}

	public CategoryModal getCategoryRaw(int id) {
		if (restHighLevelClient == null || id == 0) {
			System.out.println("oops");
			return null;
		}
		try {
			GetRequest getRequest = new GetRequest(catIndexName, String.valueOf(id));
			GetResponse response = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
			// System.out.println(response.getSource());
			CategoryModal tempCat = objectMapper.convertValue(response.getSource(), CategoryModal.class);
			// System.out.println(tempCat);
			return tempCat;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<CategoryModal> getCategoryTreeRaw() {
		if (restHighLevelClient == null) {
			System.out.println("oops");
			return null;
		}
		try {
			SearchRequest searchRequest = new SearchRequest(catIndexName);
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.query(QueryBuilders.matchAllQuery());
			searchSourceBuilder.sort(new FieldSortBuilder("_id").unmappedType("String").order(SortOrder.ASC));
			searchRequest.source(searchSourceBuilder);

			SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
			// System.out.println(response);
			// System.out.println("response.status(): " +
			// response.status().name());
			// System.out.println("response.status(): " +
			// response.status().name());
			List<CategoryModal> results = new ArrayList<>();
			if (response != null && response.getHits() != null && response.getHits().getHits() != null) {
				SearchHits searchHits = response.getHits();
				SearchHit[] hits = searchHits.getHits();
				for (SearchHit hit : hits) {
					try {
						if (!GenericValidator.isBlankOrNull(hit.getSourceAsString()) && hit.getSourceAsMap() != null) {
							CategoryModal cat = objectMapper.convertValue(hit.getSourceAsMap(), CategoryModal.class);
							if (cat != null) {
								results.add(cat);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public CategoryUIModel getCategory(Integer id) {
		System.out.println(id);
		CategoryUIModel categoryUIModel = new CategoryUIModel();
		CategoryModal category = getCategoryRaw(id);
		if (category != null) {
			categoryUIModel.setCategory(category);
			// StringBuilder attributeKeys = new StringBuilder();
			List<AttributesModal> attributeKeys = new ArrayList<AttributesModal>();
			// String pre = "";
			List<CategoryModal> parents = new ArrayList<>();
			if (!CollectionUtils.isEmpty(category.getAttributesObj())) {
				attributeKeys.addAll(category.getAttributesObj());
				// pre = ",";
			}
			if (!CollectionUtils.isEmpty(category.getParents())) {
				Collections.sort(category.getParents(), new CategoryParentComparator());
				for (CategoryParent categoryParent : category.getParents()) {
					CategoryModal categoryParentRaw = getCategoryRaw(categoryParent.getId());
					if (categoryParentRaw != null) {
						parents.add(categoryParentRaw);
						if (!CollectionUtils.isEmpty(categoryParentRaw.getAttributesObj())) {
							attributeKeys.addAll(categoryParentRaw.getAttributesObj());
						}
						// pre = ",";
					}
				}
			}
			categoryUIModel.setParents(parents);

			List<CategoryModal> children = new ArrayList<>();
			if (!CollectionUtils.isEmpty(category.getChildern())) {
				// StringTokenizer st = new
				// StringTokenizer(category.getChildern(), ",");
				// while (st.hasMoreTokens()) {
				// String childrenId = st.nextToken();
				for (int childrenId : category.getChildern()) {
					CategoryModal categoryChildrenRaw = getCategoryRaw(childrenId);
					if (categoryChildrenRaw != null) {
						children.add(categoryChildrenRaw);
					}
				}
				Collections.sort(children, new CategoryComparator(Locale.ar_SA));
			}
			categoryUIModel.setChildrens(children);

			categoryUIModel.setAttributeKeys(attributeKeys.toString());
		}
		return categoryUIModel;
	}

	public CategoryModal deleteCategory(int id) {
		if (restHighLevelClient == null || id == 0) {
			System.out.println("oops");
			return null;
		}
		CategoryModal category = getCategoryRaw(id);
		if (category != null) {

			if (category.getParentId() > 0) {
				// remove child reference from immediate parent
				category = removeImmediateParent(category);
			}
			if (!CollectionUtils.isEmpty(category.getChildern())) {
				// should we remove child cat tree is invalid?
			}
			try {
				DeleteRequest deleteRequest = new DeleteRequest(catIndexName).id(String.valueOf(id));
				DeleteResponse response = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return category;
	}
}
