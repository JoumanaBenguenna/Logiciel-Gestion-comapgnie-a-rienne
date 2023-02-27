package com.hms.persons;

public class InfoClients{
	int x;
	int y;
	String[][] info;
	
	InfoClients(int x, int y){
		this.x = x;
		this.y = y;
		info = new String[x][y];
		for (int i = 0; i<x; i++) {
			for (int j = 0; j< y; j++) {
				info[i][j] = " ";
			}
		}
	}
	
	public void afficheInfosClients() {

		for(int i = 0; i<x ; i++) {
			if((info[i][0]!=" ")) {
				for(int j = 0; j<y ; j++) {
					System.out.print(info[i][j]+ "	");
				}
				System.out.println("");
			}
		}

				
	}
	
	 public static InfoClients remplirInfosC(int i, Client clienti, InfoClients infosC) {
		  infosC.info[i][0] = clienti.getClientName();
		  infosC.info[i][1] = clienti.getClientLname();
		  infosC.info[i][2] = clienti.getClientid();
		  infosC.info[i][3] = clienti.getClientPassport();
		return infosC;
	  }
	  
	 public static InfoClients Liste_des_clients() {
		  Client info = new Client("Prénom","Nom:   	","ID:", "N de passeport:");
			Client client1 = new Client("Nahla", "AIT ABBOU", "78941","IZ1423242");
			Client client2 = new Client("Yassine", "ARIOUICH", "78942","AR3427821");
			Client client3 = new Client("Joumana", "BENGUENNA", "78943","AL1596837");
			Client client4 = new Client("Lamia", "HASSINI  ", "78944","AH1986837");
			InfoClients infosC = new InfoClients(100,5);
			
			remplirInfosC(0,info,infosC);
			remplirInfosC(1,client1,infosC);
			remplirInfosC(2,client2,infosC);
			remplirInfosC(3,client3,infosC);
			remplirInfosC(4,client4,infosC);
			return infosC;
		  }
	
}


