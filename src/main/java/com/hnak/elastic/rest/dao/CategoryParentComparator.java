package com.hnak.elastic.rest.dao;

import java.util.Comparator;

import com.hnak.emis.modal.CategoryParent;

public class CategoryParentComparator implements Comparator<CategoryParent> {

	@Override
	public int compare(CategoryParent o1, CategoryParent o2) {
		if (o1 != null && o2 != null) {
			return o1.getSeq() - o2.getSeq();
		}
		return 0;
	}

}
