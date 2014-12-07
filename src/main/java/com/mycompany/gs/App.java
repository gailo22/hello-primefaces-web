package com.mycompany.gs;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(eager=true)
@ApplicationScoped
public class App {

	private String index;
	private Page menu;
	private Map<String, Page> pages;

	@PostConstruct
	public void init() {
		index = loadIndex();
		menu = new Page();
		fillMenu(menu);
		pages = new HashMap<>();
		fillPages(pages, menu);
	}
	
	private String loadIndex() {
		// TODO Auto-generated method stub
		return null;
	}

	private void fillMenu(Page menu2) {
		// TODO Auto-generated method stub
		
	}

	private void fillPages(Map<String, Page> pages2, Page menu2) {
		// TODO Auto-generated method stub
		
	}

	public Map<String, Page> getPages() {
		return pages;
	}

	public void setPages(Map<String, Page> pages) {
		this.pages = pages;
	}
	
}
