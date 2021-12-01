package com.bilgeadam.example.mylittlebakkal;

public class Staff extends Person {
	private double salary;
	private String title;
	
	public Staff(long personalID, String firstName, String lastName, double salary) {
		super(personalID, firstName, lastName);
		this.salary = salary;
		this.title = "";
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public double getCurrentAccount() {
		return salary;
	}
	
}
