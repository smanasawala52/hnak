package com.hnak.elastic.rest.dao;

import java.util.Comparator;

import com.hnak.emis.modal.CategoryModal;
import com.hnak.emis.modal.Locale;

public class CategoryComparator implements Comparator<CategoryModal> {
	private Locale locale = Locale.ar_SA;

	public CategoryComparator(Locale pLocale) {
		locale = pLocale;
	}

	@Override
	public int compare(CategoryModal o1, CategoryModal o2) {
		if (o1 != null && o2 != null && o1.getName() != null && o2.getName() != null) {
			String name1 = o1.getName().get(locale);
			String name2 = o2.getName().get(locale);
			if (name1 != null && name2 != null) {
				return name1.compareTo(name2);
			}
		}
		return 0;
	}

}
