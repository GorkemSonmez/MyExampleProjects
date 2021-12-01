package com.bilgeadam.example.mylittlebakkal;

public class Customer extends Person {
	private double debit;
	
	public Customer(long personalID, String firstName, String lastName) {
		super(personalID, firstName, lastName);
		this.debit = 0.0d;
	}
	
	public void finishShopping(double totalAmaount) {
		this.debit += totalAmaount;
	}
	
	public void payOffDebt(double amount) {
		this.debit -= amount;
	}
	
	@Override
	public double getCurrentAccount() {
		return debit;
	}
	
}
