package com.mycompany.gs;

public class BaseLevelBean implements Searchable<Object>, Addable<Object> {

	@Override
	public void search(Object t) {
		System.out.println("search...");
	}

	@Override
	public void add(Object t) {
		System.out.println("add...");
		
	}

}
