package com.bank;

public class Account {

	private int jangum;
	private String name;
	
	public Account(String name){
		super();
		this.name = name;
	}
	
	public int getJangum() {
		return jangum;
	}
	public void setJangum(int jangum) {
		this.jangum = jangum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
