package com.bilgeadam.example.mylittlebakkal;

public class PackedUnpackedProduct extends Product {
	private boolean packed;
	private String origin;
	private float volume;
	private Unit unit;
	
	public PackedUnpackedProduct(String EAN, String name, float price, int VATRate, int minStock, boolean packed) {
		super(EAN, name, price, VATRate, minStock);
		this.packed = packed;
	}
	
	public boolean isPacked() {
		return this.packed;
	}
	
	public void setPacked(boolean packed) {
		this.packed = packed;
	}
	
	public String getOrigin() {
		return this.origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public float getVolume() {
		return this.volume;
	}
	
	public void setVolume(float volume) {
		this.volume = volume;
	}
	
	public Unit getUnit() {
		return this.unit;
	}
	
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	@Override
	public String toString() {
		return "PackedUnpackedProduct [packed=" + this.packed + ", origin=" + this.origin + ", volume=" + this.volume + ", unit=" + this.unit + ", getPrice()=" + this.getPrice() + ", getVATRate()=" + this.getVATRate() + ", getCurrentStock()="
				+ this.getCurrentStock() + ", getMinStock()=" + this.getMinStock() + ", getEAN()=" + this.getEAN() + ", getName()=" + this.getName() + ", toString()=" + super.toString() + ", getClass()=" + this.getClass() + ", hashCode()="
				+ this.hashCode() + "]";
	}
	
}
