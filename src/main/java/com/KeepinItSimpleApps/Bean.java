package com.KeepinItSimpleApps;
 
 

public class Bean {

    private String firstProperty;
    private String lastProperty;
    public String publicField;

    public Bean() {
    }

    public Bean(String name, String address) {
        this.firstProperty = name;
        this.lastProperty = address;
    }

	public String getFirstProperty() {
		return firstProperty;
	}

	public void setFirstProperty(String firstName) {
		this.firstProperty = firstName;
	}

	public String getLastName() {
		return getLastProperty();
	}

	public String getLastProperty() {
		return lastProperty;
	}

	public void setLastName(String lastName) {
		setLastProperty(lastName);
	}

	public void setLastProperty(String lastName) {
		this.lastProperty = lastName;
	}

	@Override
	public String toString() {
		return "Bean [firstProperty=" + firstProperty + ", lastProperty="
				+ lastProperty + "]";
	}
  
}