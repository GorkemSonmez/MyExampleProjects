package com.bilgeadam.example.mylittlebakkal;

public class Order implements Transportable {
	
	@Override
	public boolean canCarry() {
		return false;
	}
	
}
