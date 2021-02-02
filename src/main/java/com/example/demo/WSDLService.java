package com.example.demo;

import java.util.ArrayList;

public class WSDLService {
	
	public String name;
	public ArrayList<EndPointPort> port;


	public WSDLService(String name, ArrayList<EndPointPort> port) {
		super();
		this.name = name;
		this.port = port;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<EndPointPort> getPort() {
		return port;
	}


	public void setPort(ArrayList<EndPointPort> port) {
		this.port = port;
	}


	public WSDLService() {
	}

}
