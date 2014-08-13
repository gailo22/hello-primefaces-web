package com.mycompany.helloweb;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class SmpdBean implements Serializable {
	
	private static final long serialVersionUID = -1945269655481108762L;
	
	
	private static Set<SmpdModel> smpdApplications = new HashSet<SmpdModel>();
	
	static {
		smpdApplications.add(new SmpdModel("a", "1", "1"));
		smpdApplications.add(new SmpdModel("b", "2", "2"));
		smpdApplications.add(new SmpdModel("c", "3", "3"));
	}
	
	private SmpdModel smpdModel;
	
	
	public void populateSMPD(SmpdModel smpdModel) {
		System.out.println("populateSMPD...");
		
		setSmpdModel(smpdModel);
	}

	public SmpdModel getSmpdModel() {
		return smpdModel;
	}

	public void setSmpdModel(SmpdModel smpdModel) {
		this.smpdModel = smpdModel;
	}

	public Set<SmpdModel> getSmpdApplications() {
		return smpdApplications;
	}

	public void setSmpdApplications(Set<SmpdModel> smpdApplications) {
		this.smpdApplications = smpdApplications;
	}

}
