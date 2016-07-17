package com.practice.cce;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class InventoryManager {
	private Map<String, Item> items = new TreeMap<String, Item>();
	private float loss;
	private float prevProfit;

	public void addItems(String name, float buyingPrice, float sellingPrice) {
		Item item = items.get(name);
		if (item == null) {
			item = new Item(name);
			items.put(name, item);
		}
		item.setSellingPrice(sellingPrice);
		item.setBuyingPrice(buyingPrice);
	}

	public void buyItems(String name, int quantity) {
		Item item = items.get(name);
		if (item != null) {
			item.setQuantity(quantity);
		}
	}

	public void sellItems(String name, int quantity) {
		Item item = items.get(name);
		if (item != null) {
			int currentQuantity = item.getQuantity();
			if (currentQuantity >= quantity) {
				item.setSoldUnits(item.getSoldUnits() + quantity);
			} else {
				throw new IllegalArgumentException(
						"Item " + name + " not available upto the mentioned quantity:" + quantity);
			}
		} else {
			throw new IllegalArgumentException("Item " + name + " not defined.");
		}
	}

	public void deleteItems(String name) {
		Item item = items.get(name);
		if (item != null) {
			int currentQuantity = item.getQuantity();
			if (currentQuantity > 0) {
				int notSoldCnt = currentQuantity - item.getSoldUnits();
				loss += notSoldCnt * item.getBuyingPrice();
			}
			items.remove(name);
		} else {
			throw new IllegalArgumentException("Item " + name + " not defined.");
		}
	}

	public void generateReport() {
		System.out.println("\t\t\t INVENTORY REPORT");
		System.out.println("Item Name\t\t Buy At\t\t Sell At\t\t On Hand\t\t Value");
		System.out.println("---------\t\t ------\t\t -------\t\t -------\t\t -----");
		float totalValue = 0.0F;
		float totalProfit = 0.0F;
		for (String itemName : items.keySet()) {
			Item item = items.get(itemName);
			float itemValue = ((item.getQuantity() - item.getSoldUnits()) * item.getBuyingPrice());
			float profit = item.getSoldUnits() * (item.getSellingPrice() - item.getBuyingPrice());
			totalProfit += profit;
			totalValue += itemValue;
			System.out.printf("%-15s",item.getName());
			System.out.print("\t\t");
			System.out.printf("%.2f", item.getBuyingPrice());
			System.out.print("\t\t");
			System.out.printf("%.2f", item.getSellingPrice());
			System.out.print("\t\t\t");
			System.out.print((item.getQuantity() - item.getSoldUnits()));
			System.out.print("\t\t\t");
			System.out.printf("%.2f", itemValue);

			System.out.println();
		}
		totalProfit = totalProfit - loss;
		float profitAfterLastReport = totalProfit - prevProfit;

		System.out.println("----------------------------------");
		System.out.printf("Total Value of Inventory\t\t\t\t\t\t\t\t");
		System.out.printf("%.2f", totalValue);
		System.out.println();
		System.out.print("Profit Since Last Report\t\t\t\t\t\t\t\t");
		System.out.printf("%.2f", profitAfterLastReport);
		System.out.println();
		prevProfit = profitAfterLastReport;

	}

	public static void main(String[] args) {
		try (Scanner scanObj = new Scanner(System.in)) {
			boolean endFlag = false;
			InventoryManager mngrObj = new InventoryManager();
			while (!endFlag) {
				try {
					String line = scanObj.nextLine().trim();
					String[] words = line.split(" ");
					if (words[0].trim().equals("*")) {
						endFlag = true;
						break;
					}
					TransactionOperation operation = TransactionOperation.valueOf(words[0].toUpperCase());
					switch (operation) {
					case NEW:
						mngrObj.addItems(words[1].trim(), Float.parseFloat(words[2].trim()),
								Float.parseFloat(words[3].trim()));
						break;
					case BUY:
						mngrObj.buyItems(words[1].trim(), Integer.parseInt(words[2].trim()));
						break;
					case SELL:
						mngrObj.sellItems(words[1].trim(), Integer.parseInt(words[2].trim()));
						break;
					case DELETE:
						mngrObj.deleteItems(words[1].trim());
						break;
					case REPORT:
						mngrObj.generateReport();
						break;
					default:
						System.out.println("Invalid Option.Provide one of " + TransactionOperation.values());
						break;
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
		} finally {
		}
	}

}
/*
new Sunglasses01 0.50 3.79
new Towel01 1.47 6.98
new Sunglasses02 0.63 4.29
new Sunblock 1.00 4.98
buy Sunblock 100
sell Sunblock 2
buy Towel01 500
buy Sunglasses01 100
buy Sunglasses02 100
sell Towel01 1
sell Towel01 1
sell Sunblock 2
report
delete Sunglasses01
sell Sunblock 5
new Sunglasses03 0.51 1.98
buy Sunglasses03 250
sell Towel01 5
sell Sunglasses03 4
sell Sunglasses02 10
report
* 
*/
