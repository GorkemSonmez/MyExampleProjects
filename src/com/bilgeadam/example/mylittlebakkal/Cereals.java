package com.bilgeadam.example.mylittlebakkal;

public class Cereals extends PackedUnpackedProduct implements Wholesalable {
	private int shelfLife;
	
	public Cereals(String EAN, String name, float price, int VATRate, int minStock, boolean packed) {
		super(EAN, name, price, VATRate, minStock, packed);
		
	}
	
	@Override
	public double calculateDiscountPrice() {
		return this.getPrice() - this.getPrice() * 15 / 100;
	}
	
}
