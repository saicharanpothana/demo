package com.example.demo;

import java.util.ArrayList;

import javax.xml.namespace.QName;

public class Operation {

	public String name;
	public ArrayList<QName> input;
	public ArrayList<QName> output;
	
	public Operation(String name, ArrayList<QName> input, ArrayList<QName> output) {
		super();
		this.name = name;
		this.input = input;
		this.output = output;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<QName> getInput() {
		return input;
	}
	public void setInput(ArrayList<QName> input) {
		this.input = input;
	}
	public ArrayList<QName> getOutput() {
		return output;
	}
	public void setOutput(ArrayList<QName> output) {
		this.output = output;
	}

}
