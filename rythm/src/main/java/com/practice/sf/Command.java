package com.practice.sf;

public enum Command {
	LIST("LIST"),REMOVE ("REMOVE"),INSTALL ("INSTALL"), DEPEND ("DEPEND"), END ("END");
	private String name;
	private Command(String name) {
		this.name = name;
	}
}
