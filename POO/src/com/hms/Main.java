package com.hms;

import java.util.*;
import com.hms.TraitementFichier.TraitementFichier;
import com.hms.Entreprise;
import com.hms.persons.Address;
import com.hms.persons.Employe;
import com.hms.persons.InfoClients;
import com.hms.persons.InfoAvions;
import com.hms.persons.Avion;
import com.hms.persons.Airline;
import com.hms.persons.Flight;
import com.hms.persons.Airport;
import java.time.*;
import java.time.format.DateTimeFormatter;

import java.io.*;

class ReaderThread implements Runnable {
    @Override
    public void run() {
        try {
            TraitementFichier.readFromCSV();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
    
    	 Airline airline = new Airline("My Airline");

	Flight flight1 = new Flight("F001", "Paris", "New York", "09:00", "12:00", 6);
	Flight flight2 = new Flight("F002", "London", "New York", "11:00", "14:00", 0);
	Flight flight3 = new Flight("F003", "Tokyo", "Paris", "13:00", "16:00", 250);

	airline.addFlight(flight1);
	airline.addFlight(flight2);
	airline.addFlight(flight3);
        

        // creating a thread to read from CSV files;
        ReaderThread readerThread = new ReaderThread();
        Thread thread = new Thread(readerThread);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Scanner cin = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            String inp = "";
            Integer choice;
            System.out.print("\n\n---------------------------");
            System.out.print("\n\n- AIR FRANCE -");
            System.out.print("\n\n---------------------------\n");
            System.out.print("\n[01] Se connecter (Personnel airfrance seulement)");
            System.out.print("\n[02] Liste des clients");
            System.out.print("\n[03] Liste des Avions");
            System.out.print("\n[04] Liste des vols");
            System.out.print("\n[05] Liste des vols entrants");
            System.out.print("\n[06] Liste des vols sortants");
            System.out.print("\n\n[00] Quitter");
            System.out.print("\n\n---------------------------");
            System.out.print("\n\nVeuillez entrer votre choix:\n");
            inp = cin.next();
            inp += cin.nextLine();
            try {
                choice = Integer.parseInt(inp);
            } catch (Exception e) {
                System.out.print("\n\nEntree invalide\n");
                continue;
            }
            System.out.print("\n---------------------------");

            switch (choice) {
            case 1:
                System.out.print("\n\n---------- CONNEXION ----------");
                System.out.print("\n\n---------------------------\n");
                // ask for username and password
                System.out.print("\nEntrez votre pseudo: ");
                inp = cin.next();
                inp += cin.nextLine();
                String username = inp;
                System.out.print("Entrez votre mot de passe: ");
                inp = cin.next();
                inp += cin.nextLine();
                String password = inp;
                System.out.print("\n---------------------------\n");
                Employe Employe = new Employe();
                if (Employe.connexion(username, password)) {
                    System.out.print("\n---- Connecte tant que " + Employe.getType() + " ----\n");
                    System.out.print("\n\n---------------------------\n");
                    Employe.AfficherInfo();
                    System.out.print("\n---------------------------\n");
                    if (Employe.getType().equals("ADMIN")) {
                        System.out.println("[01] Afficher les informations du personnel de AIR FRANCE");
                        System.out.println("[02] Rajouter un/une nouvel/lle employe/e");
                        System.out.println("[03] Changer les informations d'un/une employe/E");
                        System.out.println("[04] Suprimmer un membre du personnel de AIR FRANCE");
                        System.out.println("[05] Accéder à la maintenance aéronautique");
                        System.out.print("\n---------------------------\n");
                        System.out.print("Votre choix ");
                        int ch;
                        ch = Integer.parseInt(cin.next());
                        System.out.print("\n---------------------------\n");
                        switch (ch) {
                        case 1: {
                            System.out.println("Informations du personnel AIR FRANCE: ");
                            Entreprise.printEmployeDetails();
                            break;
                        }
                        case 2: {
                            Employe temp_Employe = new Employe();
                            temp_Employe.AjouterPersonnel(0, 200);
                            break;
                        }
                        case 3: {
                            Employe temp_Employe = new Employe();
                            temp_Employe.getInfos();
                            if (temp_Employe.getIdentifiant().equals(-1))
                                break;
                            System.out.print("\n---------------------------\n");
                            System.out.print("\nEntrez le champ de la modification: ");
                            System.out.println("[01] Type ");
                            System.out.println("[02] Salaire");
                            System.out.println("[03] Mot de passe");
                            System.out.print("\n---------------------------\n");
                            System.out.print("Votre choix: ");

                            int ch1 = Integer.parseInt(cin.next());
                            System.out.print("\n---------------------------\n");
                            switch (ch1) {
                            case 2: {
                                System.out.print("Entrez le nouveau salaire: ");
                                String salary = cin.next();
                                temp_Employe.setSalaire(salary);
                                Entreprise.EmployeList.get(temp_Employe.getIdentifiant()).AttribuerValeurs(temp_Employe);
                                break;
                            }
                            case 3: {
                                System.out.print("Entrez le nouveau mot de passe: ");
                                String password1 = cin.next();
                                temp_Employe.setMotDePasse(password1);
                                Entreprise.EmployeList.get(temp_Employe.getIdentifiant()).AttribuerValeurs(temp_Employe);
                                break;
                            }
                            case 1: {
                                System.out.print("Entrez le nouveau type: ");
                                String name = cin.next();
                                temp_Employe.setType(name);
                                Entreprise.EmployeList.get(temp_Employe.getIdentifiant()).AttribuerValeurs(temp_Employe);
                                break;
                            }
                            default: {
                                System.out.println("Saisie invalide!");
                                break;
                            }
                            }
                            break;
                        }
                        case 4: {
                            Employe temp_Employe = new Employe();
                            temp_Employe.getInfos();
                            if (temp_Employe.getIdentifiant().equals(-1))
                                break;
                            Entreprise.EmployeList.remove(temp_Employe.getIdentifiant());
                        }
                        case 5: {
                        	Tableau_avion t = new Tableau_avion(10,6);
                    		Liste_visite l= new Liste_visite(10,2);


                    		while(true) {
                    			System.out.println("Tapez [01] pour enregistrer un nouvel avion");
                    			System.out.println("Tapez [02] pour afficher tous les avions de la base de données");
                    			System.out.println("Tapez [03] pour afficher la liste des visites de maintenance à faire");
                    			System.out.println("Tapez [04] pour modifier une date de maintenance");

                    	
                    			Scanner commande = new Scanner(System.in);
                    			String com = commande.nextLine();
                    			
                    			switch(com) {
                    				case("01"):
                    				case("1"):
                    					
                    					System.out.println("Entrez le nom de l'avion");
                    					String nom = commande.nextLine();
                    					
                    					System.out.println("L'avion "+ nom +" est ajouté à la base de données");
                    					
                    					System.out.println("Entrez l'année de mise en ligne au format AAAA");
                    					String a_m_e_l = commande.nextLine();
                    					
                    					try {
                    						int amel = Integer.parseInt(a_m_e_l);
                    					}
                    					catch(Exception e) {
                    						System.out.println("Le format date de l'année de mise en ligne n'est pas respecté, veuillez réessayer");
                    					}
                    					
                    					int amel = Integer.parseInt(a_m_e_l);
                    					if((amel>2023)||(amel<1970)) {
                    						
                    						System.out.println("Le format date de l'année de mise en ligne n'est pas respecté, veuillez réessayer");
                    						break;
                    					}
                    					
                    					
                    					System.out.println("Entrez la date de la dernière maintenance de type A au format AAAA-MM-JJ");
                    					String dateA = commande.nextLine();
                    					System.out.println("Entrez la date de la dernière maintenance de type B au format AAAA-MM-JJ");
                    					String dateB = commande.nextLine();
                    					System.out.println("Entrez la date de la dernière maintenance de type C au format AAAA-MM-JJ");
                    					String dateC = commande.nextLine();
                    					System.out.println("Entrez la date de la dernière maintenance de type D au format AAAA-MM-JJ");
                    					String dateD = commande.nextLine();
                    					
                    					try {
                    						Avion_m a = new Avion_m(amel,   LocalDate.parse(dateA, DateTimeFormatter.ISO_DATE),  LocalDate.parse(dateB, DateTimeFormatter.ISO_DATE), LocalDate.parse(dateC, DateTimeFormatter.ISO_DATE),  LocalDate.parse(dateD, DateTimeFormatter.ISO_DATE));
                    					}
                    					catch(Exception e)
                    					{
                    						System.out.println("Le format date d'une maintenance n'est pas respecté, veuillez réessayer");
                    						break;
                    					}
                    				
                    					t.ajout_date(nom, a_m_e_l, dateA, dateB, dateC, dateD);
                    					Avion_m a = new Avion_m(amel,   LocalDate.parse(dateA, DateTimeFormatter.ISO_DATE),  LocalDate.parse(dateB, DateTimeFormatter.ISO_DATE), LocalDate.parse(dateC, DateTimeFormatter.ISO_DATE),  LocalDate.parse(dateD, DateTimeFormatter.ISO_DATE));
                    					String retour = a.verif_all(a, dateA,  dateB,  dateC, dateD);
                    					
                    					if(!retour.equals("")) {
                    						l.add_name(nom);
                    					}
                    					
                    					l.add_maintenance(nom, retour);
                    					break;
                    				
                    				case("02") :
                    				case("2"):
                    					
                    					t.affiche_tableau();
                    					break;
                    					
                    				case("03"):
                    				case("3"):
                    					
                    					l.affiche_tableau();
                    					break;
                    				
                    				case("04"):
                    				case("4"):
                    					// Modifier une date dans le tableau
                    					
                    					System.out.println("Entrez le nom de l'avion que vous voulez modifier parmis la liste ci-dessous");
                    					l.affiche_tableau();
                    					String nom1 = commande.nextLine();
                    					
                    					if(!(l.is_inlist(nom1))) {
                    						System.out.println("Cet appareil ne figure pas dans la liste, veuillez réessayer");
                    						break;
                    					}
                    					
                    					System.out.println("Quelle visite voulez-vous actualiser ?");
                    					String visite = commande.nextLine();
                    					
                    					if(!"ABCD".contains(visite)) {
                    						System.out.println("Cette visite n'existe pas");
                    						break;
                    					}
                    					
                    					System.out.println("Indiquer la date de la dernière visite "+visite+" au format AAAA-MM-JJ");
                    					String date= commande.nextLine();
                    					
                    					try {
                    						String nv_visite = t.modification(nom1, visite, date);
                    					}
                    					catch(Exception e)
                    					{
                    						System.out.println("Le format date n'est pas respecté, veuillez réessayer");
                    						break;
                    					}
                    					
                    					String nv_visite = t.modification(nom1, visite, date);
                    					System.out.println("La date à été actualisé avec succès !");
                    					l.add_maintenance(nom1, nv_visite);
                    					break;
                    					
                    				default:
                    					System.out.println("Saisie Invalide");
                    					break;
                    				}
                    		
                    		}
                    	
                        }
                        }
                        
                
                        
                    } else if (Employe.getType().equals("Receptionist") || Employe.getType().equals("Manager")) {
                        System.out.print("\n---------------------------\n");
                        System.out.println("[01] Changer mes informations ");
                        System.out.print("\n---------------------------\n");
                        System.out.print("Votre choix: ");

                        int ch1 = Integer.parseInt(cin.next());
                        switch (ch1) {
                        case 1: {
                            System.out.print("\n---------------------------\n");
                            System.out.println("[01] Changer mon numero de telephonne");
                            System.out.println("[02] Changer mon mot de passe  ");
                            System.out.print("\n---------------------------\n");
                            System.out.print("[Votre choix:  ");

                            int ch = Integer.parseInt(cin.next());
                            switch (ch) {
                            case 1: {
                                System.out.println("Saisir un nouveau numero de telephonne: ");
                                String phoneno = cin.next();
                                Employe.setTelephonne(phoneno);
                                Entreprise.EmployeList.get(Employe.getIdentifiant()).AttribuerValeurs(Employe);
                                break;
                            }
                            case 2: {
                                System.out.println("Saisir le nouveau mot de passe: ");
                                String password1 = cin.next();
                                Employe.setMotDePasse(password1);
                                Entreprise.EmployeList.get(Employe.getIdentifiant()).AttribuerValeurs(Employe);
                                break;
                            }
                            }
                            break;
                        }
                        }
                    } else {
                        System.out.print("\n---------------------------\n");
                        System.out.println("----Changer mes informations----");
                        System.out.println("[01] Changer mon numero de telephonne");
                        System.out.println("[02] Changer mon mot de passe  ");
                        System.out.print("\n---------------------------\n");
                        System.out.print("Votre choix:  ");
                        int ch = Integer.parseInt(cin.next());
                        switch (ch) {
                        case 1: {
                            System.out.println("Saisir un nouveau numero de telephonne: ");
                            String phoneno = cin.next();
                            Employe.setTelephonne(phoneno);
                            break;
                        }
                        case 2: {
                            System.out.println("Saisir le nouveau mot de passe: ");
                            String password1 = cin.next();
                            Employe.setMotDePasse(password1);
                        }
                        }
                        break;
                    }
                } else {
                    System.out.print("Connexion echouee !\nNom d'utilisateur et/ou mot de passe invalide.");
                }

                System.out.print("\n\n---------------------------");
                break;
            
            case 0:
                System.out.print("\n  A bientot ! ...");
                done = true;
                System.out.print("\n\n---------------------------\n\n");
                break;

            case 2:
        	InfoClients infosC = InfoClients.Liste_des_clients();
        	infosC.afficheInfosClients();
                break;

            case 3:
        	InfoAvions infosA = InfoAvions.Liste_des_avions();
        	infosA.afficheInfosAvions();
                break;
                
            case 4:
	        airline.showFlitghts();
                break;
                
           case 5:
	        for (Airport airport:airline.getAirports()) {
	        	airport.showArrivingFlightss();
	        	}
                break;
                
          case 6:
		for (Airport airport:airline.getAirports()) {
		       airport.showDepartingFlights();
                break;}

            default:
                System.out.print("\n\nSaisie invalide!");
                System.out.print("\n\n---------------------------");
                break;
            }

        }

        TraitementFichier.writeToCSV();
        return;
    }   
  }

