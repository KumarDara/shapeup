package com.practice.cce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ComponentHandler {
	private static Map<String, Component> components = new HashMap<String, Component>();

	private static Component getComponent(String component) {
		Component componentObj = components.get(component);
		if (componentObj == null) {
			componentObj = new Component(component);
			components.put(component, componentObj);
		}
		return componentObj;
	}

	public static void addDependents(String comp, List<String> dependents) {
		Component compObj = getComponent(comp);
		for (String dependent : dependents) {
			Component dependentComp = getComponent(dependent);
			compObj.registerDependent(dependentComp);
		}
	}

	public static void installComponent(String compName) {
		Component compObj = getComponent(compName);
		compObj.install(true);
	}

	public static void removeComponent(String compName) {
		Component compObj = getComponent(compName);
		if (compObj.isInstalled()) {
			if (compObj.remove()) {
				components.remove(compObj.getName());
			}
		} else {
			System.out.println(compName + " is not installed.");
		}
	}

	public static void listComponents() {
		if (!components.isEmpty()) {
			for (Component compObj : components.values()) {
				if (compObj.isInstalled()) {
					System.out.println(compObj.getName());
				}
			}
		}
	}

	public static void main(String[] args) {
		try (Scanner scanObj = new Scanner(System.in)) {
			boolean endFlag = false;
			while (!endFlag) {
				try {
					String line = scanObj.nextLine().trim();
					String[] words = line.split(" ");
					Operation operation = Operation.valueOf(words[0]);
					switch (operation) {
					case DEPEND:
						List<String> dependents = new ArrayList<String>(5);
						for (int i = 2; i < words.length; i++) {
							dependents.add(words[i]);
						}
						addDependents(words[1], dependents);
						break;
					case INSTALL:
						installComponent(words[1]);
						break;
					case REMOVE:
						removeComponent(words[1]);
						break;
					case LIST:
						listComponents();
						break;
					case END:
						endFlag = true;
						break;
					default:
						System.out.println("Invalid Option.Provide one of " + Operation.values());
						break;
					}
				} catch (IllegalArgumentException e) {
					System.out.println("Invalid Option.Provide one of " + Operation.values());
				}
			}
		} finally {
			components.clear();
		}
	}
}
