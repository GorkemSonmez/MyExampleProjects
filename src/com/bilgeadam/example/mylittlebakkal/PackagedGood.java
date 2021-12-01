package com.bilgeadam.example.mylittlebakkal;

public class PackagedGood extends Product implements Spoilable {
	private int expirationDate;
	
	public PackagedGood(String EAN, String name, float price, int VATRate, int minStock, int expirationDate) {
		super(EAN, name, price, VATRate, minStock);
		this.expirationDate = expirationDate;
	}
	
	@Override
	public boolean isSpoiled() {
		return (expirationDate - Spoilable.MAX_DAYS) < 0;
	}
	
	@Override
	public String toString() {
		return "PackagedGood [expirationDate=" + this.expirationDate + ", getPrice()=" + this.getPrice() + ", getVATRate()=" + this.getVATRate() + ", getCurrentStock()=" + this.getCurrentStock() + ", getMinStock()=" + this.getMinStock()
				+ ", getEAN()=" + this.getEAN() + ", getName()=" + this.getName() + ", toString()=" + super.toString() + ", getClass()=" + this.getClass() + ", hashCode()=" + this.hashCode() + "]";
	}
	
}
