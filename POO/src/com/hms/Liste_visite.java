package com.hms;

public class Liste_visite {
	int taille_x;
	int taille_y;
	String[][] tableau ;
	int ligne_dispo = 0;
	
	Liste_visite(int taille_x, int taille_y) {
		this.taille_x = taille_x;
		this.taille_y = taille_y;
		tableau = new String[taille_x][taille_y];
		for(int i = 0 ; i < taille_x ; i++) {
			for(int j = 0 ; j < taille_y ; j++) {
					tableau[i][j] = " ";
				}
			
			}
		}
	
	public void add_name(String name) {
		ligne_dispo=ligne_dispo+1;
		tableau[ligne_dispo][0]= name;
		tableau[ligne_dispo][1]="";
	}
	
	public void add_maintenance(String name, String visite) { // recoie le nom de l'appareil auquel il faut ajouter dans la liste les maintenances à faire
		for(int i=1;i<taille_x;i++) {
			if(tableau[i][0].equals(name)) {
				tableau[i][1]=visite;
			}
		}
	}
	
	void modif_maintenance(String name, String visite) {
		for(int i=0;i<taille_x;i++) {
			if(tableau[i][0]==name) {
				tableau[i][1]=tableau[i][1].replace(visite, "");
			}
		}
	}
	
	
	void affiche_tableau() {
		tableau[0][0]="Avion";
		tableau[0][1]="Visite(s) à faire";
		
		for(int i = 0;i<taille_x;i++) {
			if((tableau[i][0]!=" ") && (tableau[i][1]!=" ")) {
				for(int j = 0;j<taille_y;j++) {
					int taille = tableau[i][j].length();
					String espace= "                      ";
					System.out.print(tableau[i][j]+espace.substring(0,espace.length()-taille));
				}
	
			System.out.println("\n");
			}
		}
		System.out.println("\n");
	}
	
	boolean is_inlist(String name) {
		boolean rep = false;
		for(int i=1;i<taille_x;i++) {
			if(tableau[i][0].equals(name)) {
				rep = true;
			}
		}
		return rep;
	}
	
	
}