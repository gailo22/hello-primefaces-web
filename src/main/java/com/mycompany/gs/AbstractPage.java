package com.mycompany.gs;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPage<T> {
	
	private Map<String, T> levels = new HashMap<>();
	
//	abstract void loadLevels();

	public T getLevel(String id) {
		return levels.get("level" + id);
	}

	public Map<String, T> getLevels() {
		return levels;
	}

	public void setLevel1(T t) {
		setLevel(t, 1);
	}
	
	public void setLevel2(T t) {
		setLevel(t, 2);
	}
	
	public void setLevel3(T t) {
		setLevel(t, 3);
	}
	
	private void setLevel(T t, int i) {
		levels.put("level" + i, t);
	}

}
