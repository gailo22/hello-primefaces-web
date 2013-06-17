/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.helloweb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

/**
 *
 * @author MontreeBungnasang
 */
@ManagedBean
@ViewScoped
public class MyBean implements Serializable {

	private static final long serialVersionUID = 4370199033249412014L;

	private String name;

	public void doSomething() {
		final RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.addCallbackParam("callBackParam", "done.");

		System.out.println("doSomething..");
		System.out.println("name : " + this.name);
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
