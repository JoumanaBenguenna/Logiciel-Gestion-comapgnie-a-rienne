
package com.hms.persons;


public class InfoAvions {

	int x;
	int y;
	String[][] info;
	
	InfoAvions(int x, int y){
		this.x = x;
		this.y = y;
		info = new String[x][y];
		for (int i = 0; i<x; i++) {
			for (int j = 0; j< y; j++) {
				info[i][j] = " ";
			}
		}
	}
	
	public void afficheInfosAvions() {

		for(int i = 0; i<x ; i++) {
			if((info[i][0]!=" ")) {
				for(int j = 0; j<y ; j++) {
					System.out.print(info[i][j]+ "	");
				}
				System.out.println("");
			}
		}		
	}

	public static InfoAvions remplirInfosA(int i, Avion avioni, InfoAvions infosA) {
		  infosA.info[i][0] = avioni.getModel();
		  infosA.info[i][1] = avioni.getCapacite();
		  infosA.info[i][2] = avioni.getN0_de_serie();
		  infosA.info[i][3] = avioni.getType_du_vol();
		return infosA;
	  }
	  
	 public static InfoAvions Liste_des_avions() {
		  Avion info = new Avion("Model	","Capacité:  ","N0 de série:", "Type du vol");
		  Avion avion1 = new Avion("A320	", "150	", "ze80741	","Moyen courrier");
		  Avion avion2 = new Avion("A220	", "120	", "sk78942	","Moyen courrier");
		  Avion avion3 = new Avion("Boeing717", "100	", "mp65983	","Long courrier");
		  Avion avion4 = new Avion("Boeing767", "210	", "am78965	","Moyen courrier");
		  Avion avion5 = new Avion("A220	", "120	", "io78549	","Moyen courrier");

		  InfoAvions infosA = new InfoAvions(100,4);
			
			remplirInfosA(0,info,infosA);
			remplirInfosA(1,avion1,infosA);
			remplirInfosA(2,avion2,infosA);
			remplirInfosA(3,avion3,infosA);
			remplirInfosA(4,avion4,infosA);
			remplirInfosA(5,avion5,infosA);
			return infosA;
		  }


}
