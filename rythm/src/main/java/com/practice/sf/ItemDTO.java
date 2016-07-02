package com.practice.sf;

public class ItemDTO {

	private String name;
	private double cost;
	private double sellingPrice;
	private double itemInventory;
	private int quantity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public double getItemInventory() {
		return itemInventory;
	}
	public void setItemInventory(double itemInventory) {
		this.itemInventory = itemInventory;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
