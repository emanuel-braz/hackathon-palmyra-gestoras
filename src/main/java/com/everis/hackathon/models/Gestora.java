package com.everis.hackathon.models;

public class Gestora {

	private String name;
	private double salary;

	public Gestora() {
		super();
	}

	public Gestora(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}



}
