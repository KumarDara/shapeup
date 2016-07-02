package com.practice.sf;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class SystemDependencies {

	private static final String LIST = "LIST";
	private static final String REMOVE = "REMOVE";
	private static final String INSTALL = "INSTALL";
	private static final String DEPEND = "DEPEND";
	private static final String END = "END";

	public static void main(String[] args) {
		handleSystemComponents();
	}

	/**
	 * Handles the system components to create dependencies among components,
	 * install components, remove components or list all the components
	 * installed on system
	 */
	private static void handleSystemComponents() {
		Scanner scanner = new Scanner(System.in);
		String command = scanner.nextLine();
		List<Component> allComponents = new ArrayList<Component>();
		List<Component> installedComponents = new ArrayList<Component>();
		// Keep accepting the commands from command line until the user enter
		// END. All the commands started with DEPEND should update the system
		// dependencies. Commands starting with INSTALL should install a
		// component. REMOVE command should remove a component. LIST should list
		// all the installed components
		while (command != null && !END.equals(command)) {
			if (command.startsWith(DEPEND)) {
				updateSystemDependencies(command, allComponents);
			} else if (command.startsWith(INSTALL)) {
				installComponent(command, allComponents, installedComponents);
			} else if (command.startsWith(REMOVE)) {
				removeComponent(command, allComponents, installedComponents);
			} else if (command.equalsIgnoreCase(LIST)) {
				System.out.println(installedComponents);
			}
			command = scanner.nextLine();
		}
		scanner.close();
	}

	/**
	 * removes a component from the system based on the dependencies
	 * 
	 * @param command
	 * @param allComponents
	 * @param installedComponents
	 */
	private static void removeComponent(String command,
			List<Component> allComponents, List<Component> installedComponents) {
		String item = command.substring(REMOVE.length(), command.length())
				.trim();
		Component component = new Component(item);
		int index = installedComponents.indexOf(component);
		// a component can be removed only if it's already installed on the
		// system. If not simply return by saying the component is not
		// installed. If installed get the component from the installed
		// components and if it is not needed by any other component, check all
		// it's dependencies. Remove those dependencies those are only needed by
		// the component which we are attempting to delete. If they are needed
		// by other components as well simply update their neededBy
		if (index != -1) {
			component = installedComponents.get(index);
			// only remove it neededBy is empty
			if (component.getNeededBy().isEmpty()) {
				if (!component.getDependsOn().isEmpty()) {
					ListIterator<Component> iterator = component.getDependsOn()
							.listIterator();
					// reach the end of cursor as we need to remove the
					// dependencies from least dependent to most
					while (iterator.hasNext()) {
						iterator.next();
					}
					while (iterator.hasPrevious()) {
						Component dependent = iterator.previous();
						// this condition tells whether this dependent is only
						// needed by the current component that we are going to
						// delete
						if (dependent.getNeededBy().size() <= 1) {
							iterator.remove();
							installedComponents.remove(dependent);
							System.out.println("	Removing " + dependent);
						}
						// if the dependent is needed by other components as
						// well, just update it's neededBy to remove the current
						// component as we are anyway going to delete the
						// current component as the component is not needed by
						// any other component
						dependent.getNeededBy().remove(component);
					}
				}
				// remove the component as it's not needed by any other
				// component. update both installedComponents and all
				// systemComponents
				installedComponents.remove(component);
				allComponents.remove(component);
				System.out.println("	Removing " + item);
			} else {
				System.out.println("	" + item + " is still needed.");
			}
		} else {
			System.out.println("	" + item + " is not installed.");
		}
	}

	/**
	 * installs a specific component based on the dependency list
	 * 
	 * @param command
	 * @param allComponents
	 * @param installedComponents
	 */
	private static void installComponent(String command,
			List<Component> allComponents, List<Component> installedComponents) {
		String item = command.substring(INSTALL.length(), command.length())
				.trim();
		Component component = new Component(item);
		int index = installedComponents.indexOf(component);
		// if the component is already installed simply return and print the
		// same. Else get the component from the list of components and install
		// all it's dependencies before installing the component itself
		if (index != -1) {
			System.out.println("	" + item + " is already installed.");
		} else {
			index = allComponents.indexOf(component);
			if (index != -1) {
				component = allComponents.get(index);
				if (!component.getDependsOn().isEmpty()) {
					for (Component dependent : component.getDependsOn()) {
						// add all the dependent components and ignore already
						// installed components
						if (!installedComponents.contains(dependent)) {
							installedComponents.add(dependent);
							System.out.println("	Installing " + dependent);
						}
					}
				}
			}
			// finally add the component itself
			installedComponents.add(component);
			System.out.println("	Installing " + item);
		}
	}

	/**
	 * Updates the components list with the component and it's dependencies
	 * 
	 * @param command
	 * @param allComponents
	 */
	private static void updateSystemDependencies(String command,
			List<Component> allComponents) {
		String list = command.substring(DEPEND.length(), command.length())
				.trim();
		String[] items = list.split("\\s+");
		validateAndUpdateDependencies(allComponents, items);
	}

	/**
	 * Validates and updates the system dependencies
	 * 
	 * @param components
	 * @param items
	 */
	private static void validateAndUpdateDependencies(
			List<Component> components, String[] items) {
		Component component = new Component(items[0]);
		// if a component already exists in the system components simply get
		// that component from the list and update it's dependencies
		if (!components.contains(component)) {
			components.add(component);
		} else {
			component = components.get(components.indexOf(component));
		}
		// if the items length is !> 1 there are no dependencies to a particular
		// component. so don't have to update them
		if (items.length > 1) {
			Component dependent = null;
			for (int i = 1; i < items.length; i++) {
				dependent = new Component(items[i]);
				int index = components.indexOf(dependent);
				// if a dependent already exists in the components list, get
				// that component from the list and update the dependencies
				if (index != -1) {
					// if there is a mutual exclusion, simply return and don't
					// update the dependencies
					if (components.get(index).getDependsOn()
							.contains(component)) {
						System.out.println(dependent + " depends on "
								+ component + ". Ignoring command.");
						return;
					} else {
						components.get(index).getNeededBy().add(component);
					}
				} else {
					dependent.getNeededBy().add(component);
					components.add(dependent);
				}
				// always update the dependencies of the components taken from
				// the list of components to make sure that we don't lose any
				// previous dependencies
				component.getDependsOn().add(
						components.get(components.indexOf(dependent)));
			}
		}
	}
}
