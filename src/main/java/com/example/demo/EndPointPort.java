package com.example.demo;

import java.util.ArrayList;

public class EndPointPort {
	
	public String name;
	public ArrayList locationUri;
	public ArrayList<Operation> bindingOperation;

	public EndPointPort(String name, ArrayList locationUri, ArrayList<Operation> bindingOperation) {
		super();
		this.name = name;
		this.locationUri = locationUri;
		this.bindingOperation = bindingOperation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList getLocationUri() {
		return locationUri;
	}

	public void setLocationUri(ArrayList locationUri) {
		this.locationUri = locationUri;
	}

	public ArrayList<Operation> getBindingOperation() {
		return bindingOperation;
	}

	public void setBindingOperation(ArrayList<Operation> bindingOperation) {
		this.bindingOperation = bindingOperation;
	}

	public EndPointPort() {
		// TODO Auto-generated constructor stub
	}

}
