package com.example.demo;

public class datacarona {
	
	private String state;
	
	private String country;
	
	private int Conformed;
	
	
	private String lastupdated;
	
	

	public String getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(String lastupdated) {
		this.lastupdated = lastupdated;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getConformed() {
		return Conformed;
	}

	public void setConformed(int conformed) {
		Conformed = conformed;
	}

	@Override
	public String toString() {
		return "datacarona [state=" + state + ", country=" + country + ", Conformed=" + Conformed + ", lastupdated="
				+ lastupdated + "]";
	}

	

	

}
