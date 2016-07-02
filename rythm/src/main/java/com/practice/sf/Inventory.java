package com.practice.sf;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
	Map<String, ItemDTO> items = null;
	double profit = 0;

	public Inventory() {
		items = new HashMap<String, ItemDTO>();
	}

	public void manageInventory(String inputFilePath) {
		try {
			List<String> commands = Files.readAllLines(Paths.get(inputFilePath), StandardCharsets.UTF_8);
			for (String command : commands) {
				if (command != null && command.startsWith("new")) {
					newItem(command);
				} else if (command != null && command.startsWith("buy")) {
					buyItem(command);
				} else if (command != null && command.startsWith("sell")) {
					sellItem(command);
				} else if (command != null && command.startsWith("delete")) {
					deleteItem(command);
				} else if (command != null && command.startsWith("report")) {
					generateReport();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void newItem(String command) {
		String[] tokens = command.split(" ");
		ItemDTO item = new ItemDTO();
		item.setName(tokens[1]);
		item.setCost(Double.parseDouble(tokens[2]));
		item.setSellingPrice(Double.parseDouble(tokens[3]));
		items.put(tokens[1], item);
	}

	private void buyItem(String command) {
		String[] tokens = command.split(" ");
		ItemDTO item = items.get(tokens[1]);
		item.setQuantity(item.getQuantity() + Integer.parseInt(tokens[2]));
	}

	private void sellItem(String command) {
		String[] tokens = command.split(" ");
		ItemDTO item = items.get(tokens[1]);
		profit += (item.getSellingPrice() - item.getCost()) * Integer.parseInt(tokens[2]);
		item.setQuantity(item.getQuantity() - Integer.parseInt(tokens[2]));
	}

	private void deleteItem(String command) {
		String[] tokens = command.split(" ");
		items.remove(tokens[1]);
	}

	private void generateReport() {
		System.out.println("\t\t\t\t\t\tINVENTORY REPORT");
		System.out.println("Item Name\t\tBuy At\t\tSell At\t\tOn Hand\t\tValue");
		System.out.println("---------\t\t------\t\t-------\t\t-------\t\t-----");
		List<String> itemNames = new ArrayList<String>();
		itemNames.addAll(items.keySet());
		Collections.sort(itemNames);
		double totalInventory = 0;
		for (String itemName : itemNames) {
			ItemDTO item = items.get(itemName);
			totalInventory += item.getItemInventory();
			System.out.println(item);
		}
		System.out.println("------------------------");
		System.out.println("Total value of inventory\t\t\t\t\t\t" + totalInventory);
		System.out.println("Profit since last report\t\t\t\t\t\t" + profit);
		System.out.println();
		System.out.println();
		profit = 0;
	}

}
