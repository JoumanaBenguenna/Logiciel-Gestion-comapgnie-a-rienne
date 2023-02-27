package com.hms.persons;

public class Avion {
	private String model, capacite, n0_de_serie, type_du_vol;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCapacite() {
		return capacite;
	}

	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}

	public String getN0_de_serie() {
		return n0_de_serie;
	}

	public void setN0_de_serie(String n0_de_serie) {
		this.n0_de_serie = n0_de_serie;
	}
	
	public String getType_du_vol() {
		return type_du_vol;
	}

	public void setType_du_vol(String type_du_vol) {
		this.type_du_vol = type_du_vol;
	}

	public Avion(String model,String capacite, String n0_de_serie, String type_du_vol) {
		this.model = model;
		this.capacite = capacite;
		this.n0_de_serie = n0_de_serie;
		this.type_du_vol = type_du_vol;
	}
	
}
