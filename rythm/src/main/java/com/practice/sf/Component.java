package com.practice.sf;

import java.util.ArrayList;
import java.util.List;

public class Component {

	String name;
	List<Component> dependsOn = new ArrayList<Component>();
	List<Component> neededBy = new ArrayList<Component>();

	public Component(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Component> getDependsOn() {
		return dependsOn;
	}

	public List<Component> getNeededBy() {
		return neededBy;
	}

	@Override
	public boolean equals(Object component) {
		if (this.getName().equalsIgnoreCase(((Component) component).getName())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return name.toLowerCase().hashCode();
	}

	@Override
	public String toString() {
		return name;
	}
}
