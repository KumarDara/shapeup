package com.practice.cce;

public enum TransactionOperation {
	NEW("new"), BUY("buy"),SELL("sell"),DELETE("delete"),REPORT("report");
	private String name;
	private TransactionOperation(String name) {
		this.name = name;
	}
	
	
}
