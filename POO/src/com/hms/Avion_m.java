package com.hms;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
//import java.util.*;


public class Avion_m {
	int annee_mel;
	LocalDate date_VA;
	LocalDate date_VB;
	LocalDate date_VC;
	LocalDate date_VD;
	
	
	public Avion_m(int annee_mel, LocalDate date_VA, LocalDate date_VB, LocalDate date_VC, LocalDate date_VD) {
		this.annee_mel = annee_mel;
		this.date_VA = date_VA;
		this.date_VB = date_VB;
		this.date_VC = date_VC;
		this.date_VD = date_VD;
		
		}
		
	public String verif_VA(LocalDate date_VA){   // TOUS LES MOIS
		LocalDate today = LocalDate.now();
		Period period = Period.between(date_VA, today);
		int ecart_jours = period.getYears()*365 +period.getMonths()*30 +period.getDays();
		if(ecart_jours>=30) {
			System.out.println("La visite A est à faire !");
			return "A";
		}	
		else return "";
	}
	
	public String verif_VB(LocalDate date_VB){   // TOUS LES 3 MOIS 
		LocalDate today = LocalDate.now();
		Period period = Period.between(date_VB, today);
		int ecart_jours = period.getYears()*365 +period.getMonths()*30 +period.getDays();
		if(ecart_jours>=90) {
			System.out.println("La visite B est à faire !");
			return "B";
		}	
		else return "";
	}

	public String verif_VC(LocalDate date_VC){   // TOUS LES 12-18 MOIS
		LocalDate today = LocalDate.now();
		Period period = Period.between(date_VC, today);
		int ecart_jours = period.getYears()*365 +period.getMonths()*30 +period.getDays();
		if(ecart_jours>=(15*30)) {
			System.out.println("La visite C est à faire !");
			return "C";
		}	
		else return "";	
	}

	public String verif_VD(LocalDate date_VD){  // TOUS LES 4-5ANS
		LocalDate today = LocalDate.now();
		Period period = Period.between(date_VD, today);
		int ecart_jours = period.getYears()*365 +period.getMonths()*30 +period.getDays();
		if(ecart_jours>=(365*4)) {
			System.out.println("La visite D est à faire !");
			return "D";
		}	
		else return "";	
	}
	
	public String verif_all(Avion_m a,String date_VA, String date_VB, String date_VC, String date_VD) {
		
		String retour="";
		String A= a.verif_VA(LocalDate.parse(date_VA, DateTimeFormatter.ISO_DATE));
		String B=a.verif_VB(LocalDate.parse(date_VB, DateTimeFormatter.ISO_DATE));
		String C=a.verif_VC(LocalDate.parse(date_VC, DateTimeFormatter.ISO_DATE));
		String D=a.verif_VD(LocalDate.parse(date_VD, DateTimeFormatter.ISO_DATE));
		retour=A+B+C+D;
		return retour;
		
		
	}
}
