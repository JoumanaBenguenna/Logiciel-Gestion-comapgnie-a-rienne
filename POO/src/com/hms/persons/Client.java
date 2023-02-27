package com.hms.persons;


public class Client {
	private String name , Lname, Passport, id;
	
	public Client (String fname,String lname, String id, String npassport) {
		this.name=fname;
		this.Lname=lname;
		this.id= id;
		this.Passport=npassport;
	}
	
	public String getClientName() {
		return name;
	}
	public String getClientLname() {
		return Lname;
	}
	public String getClientid() {
		return id;
	}
	public String getClientPassport() {
		return Passport;
	}
}
