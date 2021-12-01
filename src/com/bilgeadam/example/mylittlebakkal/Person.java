package com.bilgeadam.example.mylittlebakkal;

import java.util.Date;

public abstract class Person {
	protected long personalID;
	protected String firstName;
	private String lastName;
	private Date birthDate;
	private String adress;
	private long[] telephone;
	private int telIndex;
	
	public Person(long personalID, String firstName, String lastName) {
		super();
		this.personalID = personalID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = null;
		this.adress = "";
		this.telephone = new long[3];
		this.telIndex = 0;
	}
	
	public abstract double getCurrentAccount();
	
	public boolean addTelephoneNumber(long number) {
		if (telIndex < 3) {
			this.telephone[telIndex] = number;
			telIndex++;
			return true;
		}
		return false;
	}
	
}
