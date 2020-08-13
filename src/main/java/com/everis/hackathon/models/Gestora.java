package com.everis.hackathon.models;

public class Gestora {

	private String name;
	private int users;
	private int investments;
	
	
	public Gestora(String name, int users, int investments) {
		super();
		this.name = name;
		this.users = users;
		this.investments = investments;
	}
	public Gestora() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUsers() {
		return users;
	}
	public void setUsers(int users) {
		this.users = users;
	}
	public int getInvestments() {
		return investments;
	}
	public void setInvestments(int investments) {
		this.investments = investments;
	}

}
