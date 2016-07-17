package com.practice.cce;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Component {
	private String name;
	private boolean installed = false;
	private boolean explicitInstall = false;
	private List<Component> dependents = new ArrayList<Component>(5);
	private List<Component> requiredBy = new ArrayList<Component>(5);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isInstalled() {
		return installed;
	}

	public void setInstalled(boolean installed) {
		this.installed = installed;
	}

	public boolean isExplicitInstall() {
		return explicitInstall;
	}

	public void setExplicitInstall(boolean directInstall) {
		this.explicitInstall = directInstall;
	}

	public List<Component> getDependents() {
		return dependents;
	}

	public void setDependents(List<Component> dependents) {
		this.dependents = dependents;
	}

	public List<Component> getRequiredBy() {
		return requiredBy;
	}

	public void setRequiredBy(List<Component> requiredBy) {
		this.requiredBy = requiredBy;
	}

	public Component(String name) {
		this.name = name;
	}

	public boolean registerDependent(Component dependent) {
		if (dependent.getDependents().indexOf(this) == -1) {
			if (dependents.indexOf(dependent) == -1) {
				dependents.add(dependent);
				dependent.registerRequiredBy(this);
			}
			return true;
		} else {
			System.out.println(dependent + " depends on " + this.getName() + ". Ignoring command.");
		}
		return false;
	}

	public void registerRequiredBy(Component requiredComp) {
		if (this.requiredBy.indexOf(requiredComp) == -1) {
			requiredBy.add(requiredComp);
		}
	}

	public void unregisterDependent(Component dependent) {
		dependents.remove(dependent);
	}

	public void unregisterRequiredBy(Component requiredComp) {
		requiredBy.remove(requiredComp);
	}

	public void install(boolean explicit) {
		if (!installed) {
			if (!dependents.isEmpty()) {
				for (Component compObj : dependents) {
					if(!compObj.isInstalled()) {
						compObj.install(false);
					}
				}
			}
			System.out.println("Installing " + this.getName());
			installed = true;
			explicitInstall = explicit;
		} else {
				System.out.println(this.getName() + " is already installed.");
		}
	}

	public boolean remove() {
		if (requiredBy.isEmpty()) {
			System.out.println("Removing "+this.getName());
			if (!dependents.isEmpty()) {
				ListIterator<Component> dependentItr = dependents.listIterator();
				while(dependentItr.hasNext()) {
					dependentItr.next();
				}
				while(dependentItr.hasPrevious()) {
					Component compObj = dependentItr.previous();
					compObj.unregisterRequiredBy(this);
					if(compObj.getRequiredBy().isEmpty() && !compObj.isExplicitInstall()) {
						compObj.remove();
					}
					dependentItr.remove();
				}
			}
			installed = false;
			explicitInstall = false;
			return true;
		} else {
			System.out.println(this.getName() + " is still needed.");
			return false;
		}
	}

	public int hashCode() {
		return getName().hashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Component) {
			Component otherComp = (Component) obj;
			return this.getName().equals(otherComp.getName());
		}
		return false;
	}

	public String toString() {
		return name;
	}
}
