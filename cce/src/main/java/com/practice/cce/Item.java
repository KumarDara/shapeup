package com.practice.cce;

public class Item {

	private String name;
	private int quantity;
	private float buyingPrice;
	private float sellingPrice;
	private int soldUnits;
	
	public Item(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(float buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public float getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int hashCode() {
		return name.hashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Item) {
			Item anotherItem = (Item)obj;
			return this.getName().equals(anotherItem.getName());
		}
		return false;
	}
	
	public String toString() {
		return name;
	}

	public int getSoldUnits() {
		return soldUnits;
	}

	public void setSoldUnits(int soldUnits) {
		this.soldUnits = soldUnits;
	}
}
