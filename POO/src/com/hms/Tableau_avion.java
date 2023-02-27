package com.hms;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
//import java.time.LocalDate;

public class Tableau_avion {
	int taille_x;
	int taille_y;
	String[][] tableau;
	int ligne_dispo = 0;
	
	Tableau_avion(int taille_x, int taille_y) {
		
		this.taille_x = taille_x;
		this.taille_y = taille_y;
		tableau = new String[taille_x][taille_y];
		
		for(int i = 0 ; i < taille_x ; i++) {
			for(int j = 0 ; j < taille_y ; j++) {
					tableau[i][j] = " ";
				}
			
			}
		}

	
	void ajout_date(String nom, String a_m_e_l, String verifA, String verifB, String verifC, String verifD) {
		
		ligne_dispo=ligne_dispo+1;
		tableau[ligne_dispo][0] = nom;
		tableau[ligne_dispo][1]=a_m_e_l;
		tableau[ligne_dispo][2]=verifA;
		tableau[ligne_dispo][3]=verifB;
		tableau[ligne_dispo][4]=verifC;
		tableau[ligne_dispo][5]=verifD;

	}
	
	void affiche_tableau() {
		
		tableau[0][0]="Avion";
		tableau[0][1]="Année mise en ligne";
		tableau[0][2]="Vérif A";
		tableau[0][3]="Vérif B";
		tableau[0][4]="Vérif C";
		tableau[0][5]="Vérif D";
		
		for(int i = 0;i<taille_x;i++) {
			
			if((tableau[i][0]!=" ")) {
				
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
	
	public String modification(String nom, String visite, String nouvelle_date) { // il change la date de la visite de l'avion dans le tableau et renvoie la nouvelle liste de visite à faire
		Avion_m a;
		String retour="";
		for(int i=1;i<taille_x;i++) {
		
			if(tableau[i][0].equals(nom)) {

				switch(visite) {
					case("A"):

						a = new Avion_m(Integer.parseInt(tableau[i][1]),   LocalDate.parse(nouvelle_date, DateTimeFormatter.ISO_DATE),  LocalDate.parse(tableau[i][3], DateTimeFormatter.ISO_DATE), LocalDate.parse(tableau[i][4], DateTimeFormatter.ISO_DATE),  LocalDate.parse(tableau[i][5], DateTimeFormatter.ISO_DATE));
						tableau[i][2]=nouvelle_date;
						retour = a.verif_all(a, tableau[i][2],  tableau[i][3],  tableau[i][4], tableau[i][5]);						
						break;
						
					case("B"):
						
						a = new Avion_m(Integer.parseInt(tableau[i][1]),   LocalDate.parse(tableau[i][2], DateTimeFormatter.ISO_DATE),  LocalDate.parse(nouvelle_date, DateTimeFormatter.ISO_DATE), LocalDate.parse(tableau[i][4], DateTimeFormatter.ISO_DATE),  LocalDate.parse(tableau[i][5], DateTimeFormatter.ISO_DATE));
						tableau[i][3]=nouvelle_date;
						retour = a.verif_all(a, tableau[i][2],  tableau[i][3],  tableau[i][4], tableau[i][5]);					
						break;
						
					case("C"):
						
						a = new Avion_m(Integer.parseInt(tableau[i][1]),   LocalDate.parse(tableau[i][2], DateTimeFormatter.ISO_DATE),  LocalDate.parse(tableau[i][3], DateTimeFormatter.ISO_DATE), LocalDate.parse(nouvelle_date, DateTimeFormatter.ISO_DATE),  LocalDate.parse(tableau[i][5], DateTimeFormatter.ISO_DATE));
						tableau[i][4]=nouvelle_date;
						retour = a.verif_all(a, tableau[i][2],  tableau[i][3],  tableau[i][4], tableau[i][5]);
						break;
						
					case("D"):
						
						a = new Avion_m(Integer.parseInt(tableau[i][1]),   LocalDate.parse(tableau[i][2], DateTimeFormatter.ISO_DATE),  LocalDate.parse(tableau[i][3], DateTimeFormatter.ISO_DATE), LocalDate.parse(tableau[i][4], DateTimeFormatter.ISO_DATE),  LocalDate.parse(nouvelle_date, DateTimeFormatter.ISO_DATE));
						tableau[i][5]=nouvelle_date;
						retour = a.verif_all(a, tableau[i][2],  tableau[i][3],  tableau[i][4], tableau[i][5]);							
						break;
				}
			}
		}
		return retour;
	}
}

