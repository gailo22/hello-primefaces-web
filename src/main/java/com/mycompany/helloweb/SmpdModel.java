package com.mycompany.helloweb;

public class SmpdModel {
	
	private String name;
	
	private String regNo;
	
	private String episod;
	
	public SmpdModel(String name, String regNo, String episod) {
		this.name = name;
		this.regNo = regNo;
		this.episod = episod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getEpisod() {
		return episod;
	}

	public void setEpisod(String episod) {
		this.episod = episod;
	}

}

