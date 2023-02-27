package com.hms.persons;

import java.util.*;
import java.io.*;

public class Employe extends Individu {
    protected String type;
    protected String salaire;
    protected Integer JoursTravail;
    protected String IdDeConnexion;
    protected String MotDePasse;

    public Employe() {
        identifiant = -1;
        fonction = "Employe";
    }

    public Employe(Employe employe) {
        this.AttribuerValeurs(employe);
    }

    public Employe(Integer identifiant, String nom, Integer age, Character genre, String telephonne, com.hms.persons.Address addresse,
            String fonction, String type, String salaire, Integer JoursTravail, String IdDeConnexion, String MotDePasse) {
        super(identifiant, nom, age, genre, telephonne, addresse, fonction); //On recupere ces attribus de la classe Individu
        // Puis on remplit le reste des attribus
        this.type = type;
        this.salaire = salaire;
        this.JoursTravail = JoursTravail;
        this.IdDeConnexion = IdDeConnexion;
        this.MotDePasse = MotDePasse;
    }

    public void AttribuerValeurs(Employe emp) {
        super.AttribuerValeurs(emp);
        this.type = emp.type;
        this.salaire = emp.salaire;
        this.JoursTravail = emp.JoursTravail;
        this.IdDeConnexion = emp.IdDeConnexion;
        this.MotDePasse = emp.MotDePasse;
        return;
    }

    //Liste des getters 
    
    public String getIdDeConnexion() {
        return IdDeConnexion;
    }

    public String getType() {
        return type;
    }

    public String getSalaire() {
        return salaire;
    }

    public String getMotDePasse() {
        return MotDePasse;
    }

    //Liste des setters

    public void setIdDeConnexion(String IdDeConnexion) {
        this.IdDeConnexion = IdDeConnexion;
    }

    public void setMotDePasse(String MotDePasse) {
        this.MotDePasse = MotDePasse;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }

    public Integer getJoursTravail() {
        return JoursTravail;
    }

    public void setJoursTravail(Integer JoursTravail) {
        this.JoursTravail = JoursTravail;
    }


// Saisie d'informations et affichages 

    public void SaisirInfos() {
        super.AjouterPersonnel(18, 100); 
        if (this.identifiant == -2) 
            return;
        Scanner cin = new Scanner(System.in);
        String input;
        System.out.print("\nSaisir type de l'employe:\n");
        type = cin.nextLine();
        System.out.print("\nSaisir salaire de l'employe:\n");
        salaire = cin.nextLine();
        System.out.println("\nSaisir l'identifiant de l'employe:\n");
        IdDeConnexion = cin.nextLine();
        System.out.println("\nSaisir un nouveau mot de passe:\n");
        MotDePasse = cin.nextLine();
        JoursTravail = 1; //Je commence par un jour de travail
        fonction = "Employe";
    }

    public void AjouterPersonnel(int Age_minimum, int Age_maximum) {
        super.AjouterPersonnel(18, 100); 
        if (this.identifiant == -2) 
            return;
        Scanner cin = new Scanner(System.in);
        String input;
        System.out.print("\nSaisir type de l'employe:\n");
        type = cin.nextLine();
        System.out.print("\nSaisir salaire de l'employe:\n");
        salaire = cin.nextLine();
        System.out.println("\nSaisir l'identifiant de l'employe:\n");
        IdDeConnexion = cin.nextLine();
        System.out.println("\nSaisir un nouveau mot de passe:\n");
        MotDePasse = cin.nextLine();
        JoursTravail = 0;
        fonction = "Employe";
        if (com.hms.Entreprise.EmployeList.size() > 0) {
            this.identifiant = com.hms.Entreprise.EmployeList.lastEntry().getKey() + 1;
            com.hms.Entreprise.EmployeList.put(this.identifiant, new Employe(this));
        } else {
            this.identifiant = 1;
            com.hms.Entreprise.EmployeList.put(this.identifiant, new Employe(this));
        }
    }

    public void AfficherInfo() {
        if (identifiant == -1)
            return;
        System.out.print("\nInformations des employes:\n");
        super.AfficherInfo();
        System.out.print("Type                           : " + type + "\n");
        System.out.print("salaire                        : " + salaire + "\n");
        System.out.print("Jours de travail               : " + JoursTravail + "\n");
        return;
    }


    public void getInfos() {
        Scanner cin = new Scanner(System.in);
        boolean done = false;


        while (!done) {
            Integer opt = 0;
            String input;
            System.out.print(
                    "\nNaviguez en utilisant parmi ces options: \n1. Identifiant\n2. Nom\n3.Numero de Telephonne \n4. Type\n");
            input = cin.next();
            input += cin.nextLine();
            opt = Integer.parseInt(input);
            while (opt < 1 || opt > 4) {
                System.out.print("\nChoix invalide !\nSaisir a nouveau\n ");
                input = cin.next();
                input += cin.nextLine();
                opt = Integer.parseInt(input);
            }
            switch (opt) {

            case 1:
                    Integer reqId = 0;
                    System.out.print("\nSaisir un identifiant:\n");
                    input = cin.nextLine();
                    reqId = Integer.parseInt(input);
                    if (com.hms.Entreprise.EmployeList.containsKey(reqId)) {
                        this.AttribuerValeurs(com.hms.Entreprise.EmployeList.get(reqId));
                        done = true;
                        break;
                    } else {
                        System.out.print("\nAucune donnee trouvee!\n");
                        System.out.print("\nEssayer a nouveau ? (Y = Oui | N = Non)\n");
                        input = cin.nextLine();
                        while (!input.equals("Y") && !input.equals("N")) {
                            System.out.print("\nChoix invalide!\nSaisir a nouveau:\n");
                            input = cin.nextLine();
                        }
                        if (input.equals("N")) {
                            done = true;
                            break;
                        }
                    }
                    break;
            case 2:
                String reqName = "";
                System.out.print("\nSaisir un nom:\n");
                input = cin.next();
                input += cin.nextLine();
                reqName = input;
                Integer found = 0;
                TreeMap<Integer, Employe> MatchingRecords = new TreeMap<Integer, Employe>();
                for (Map.Entry<Integer, Employe> entry : com.hms.Entreprise.EmployeList.entrySet())
                    if (entry.getValue().nom.equals(reqName)) {
                        MatchingRecords.put(entry.getKey(), entry.getValue());
                        found++;
                    }
                if (found == 0) {
                    System.out.print("\nAucune donnee trouvee!\n");
                    System.out.print("\nEssayer a nouveau ? (Y = Oui | N = Non)\n");
                    input = cin.next();
                    input += cin.nextLine();
                    while (!input.equals("Y") && !input.equals("N")) {
                        System.out.print("\nChoix invalide!\nSaisir a nouveau:\n");
                        input = cin.next();
                        input += cin.nextLine();
                    }
                    if (input.equals("N")) {
                        done = true;
                        break;
                    }
                } else {
                    System.out.print("\nDonnes trouvees -->\n");
                    for (Map.Entry<Integer, Employe> entry : MatchingRecords.entrySet()) {
                        entry.getValue().AfficherInfo();
                        System.out.print("\n");
                    }
                    Boolean done1 = false;
                    while (!done1) {
                        System.out.print("\nSaisir l'identifiant recherche de la liste ci-dessus:\n");
                        input = cin.next();
                        input += cin.nextLine();
                        identifiant = Integer.parseInt(input);
                        if (!MatchingRecords.containsKey(identifiant)) {
                            System.out.print("\nL'identifiant entre ne fait pas partie de la liste donnee!\n");
                            System.out.print("\nEssayer a nouveau ? (Y = Oui | N = Non)\n");
                            input = cin.next();
                            input += cin.nextLine();
                            while (!input.equals("Y") && !input.equals("N")) {
                                System.out.print("\nChoix invalide!\nSaisir a nouveau:\n");
                                input = cin.next();
                                input += cin.nextLine();
                            }
                            if (input.equals("N")) {
                                done1 = true;
                                break;
                            }
                        } else {
                            this.AttribuerValeurs(MatchingRecords.get(identifiant));
                            done1 = done = true;
                            break;
                        }
                    }
                    if (done)
                        break;
                    else {
                        System.out.print("\nAucune donnee trouvee!\n");
                        System.out.print("\nAucune donnee trouvee!\n");
                        input = cin.next();
                        input += cin.nextLine();
                        while (!input.equals("Y") && !input.equals("N")) {
                            System.out.print("\nChoix invalide!\nSaisir a nouveau:\n ");
                            input = cin.next();
                            input += cin.nextLine();
                        }
                        if (input.equals("N")) {
                            done = true;
                            break;
                        }
                    }
                }
                break;
            case 3:
                String reqMobNumber = "";
                System.out.print("\nSaisir un numero de telephonne:\n");
                input = cin.next();
                input += cin.nextLine();
                reqMobNumber = input;
                Integer found1 = 0;
                TreeMap<Integer, Employe> MatchingRecords1 = new TreeMap<Integer, Employe>();
                for (Map.Entry<Integer, Employe> entry : com.hms.Entreprise.EmployeList.entrySet())
                    if (entry.getValue().telephonne.equals(reqMobNumber)) {
                        MatchingRecords1.put(entry.getKey(), entry.getValue());
                        found1++;
                    }
                if (found1 == 0) {
                    System.out.print("\nAucune donnee trouvee!\n");
                    System.out.print("\nAucune donnee trouvee!\n");
                    input = cin.next();
                    input += cin.nextLine();
                    while (!input.equals("Y") && !input.equals("N")) {
                        System.out.print("\nChoix invalide!\nSaisir a nouveau:\n ");
                        input = cin.next();
                        input += cin.nextLine();
                    }
                    if (input.equals("N")) {
                        done = true;
                        break;
                    }
                } else {
                    System.out.print("\nDonnes trouvees:\n");
                    for (Map.Entry<Integer, Employe> entry : MatchingRecords1.entrySet()) {
                        entry.getValue().AfficherInfo();
                        System.out.print("\n");
                    }
                    Boolean done2 = false;
                    while (!done2) {
                        System.out.print("\nSaisir l'identifiant recherche de la liste ci-dessus:\n");
                        input = cin.next();
                        input += cin.nextLine();
                        identifiant = Integer.parseInt(input);
                        if (!MatchingRecords1.containsKey(identifiant)) {
                            System.out.print("\nL'identifiant entre ne fait pas partie de la liste donnee!\n");
                            System.out.print("\nAucune donnee trouvee!\n");
                            input = cin.next();
                            input += cin.nextLine();
                            while (!input.equals("Y") && !input.equals("N")) {
                                System.out.print("\nChoix invalide!\nSaisir a nouveau:\n ");
                                input = cin.next();
                                input += cin.nextLine();
                            }
                            if (input.equals("N")) {
                                done2 = true;
                                break;
                            }
                        } else {
                            this.AttribuerValeurs(MatchingRecords1.get(identifiant));
                            done2 = done = true;
                            break;
                        }
                    }
                    if (done)
                        break;
                    else {
                        System.out.print("\nAucune donnee trouvee!\n");
                        System.out.print("\nAucune donnee trouvee!\n");
                        input = cin.next();
                        input += cin.nextLine();
                        while (!input.equals("Y") && !input.equals("N")) {
                            System.out.print("\nChoix invalide!\nSaisir a nouveau:\n ");
                            input = cin.next();
                            input += cin.nextLine();
                        }
                        if (input.equals("N")) {
                            done = true;
                            break;
                        }
                    }

                }
                break;
            case 4:
                String reqType = "";
                System.out.print("\nEnter Type:\n");
                input = cin.next();
                input += cin.nextLine();
                reqType = input;
                Integer found2 = 0;
                TreeMap<Integer, Employe> MatchingRecords2 = new TreeMap<Integer, Employe>();
                for (Map.Entry<Integer, Employe> entry : com.hms.Entreprise.EmployeList.entrySet())
                    if (entry.getValue().type.equals(reqType)) {
                        MatchingRecords2.put(entry.getKey(), entry.getValue());
                        found2++;
                    }
                if (found2 == 0) {
                    System.out.print("\nAucune donnee trouvee!\n");
                    System.out.print("\nAucune donnee trouvee!\n");
                    input = cin.next();
                    input += cin.nextLine();
                    while (!input.equals("Y") && !input.equals("N")) {
                        System.out.print("\nChoix invalide!\nSaisir a nouveau:\n ");
                        input = cin.next();
                        input += cin.nextLine();
                    }
                    if (input.equals("N")) {
                        done = true;
                        break;
                    }
                } else {
                    System.out.print("\nDonnes trouvees:\n");
                    for (Map.Entry<Integer, Employe> entry : MatchingRecords2.entrySet()) {
                        entry.getValue().AfficherInfo();
                        System.out.print("\n");
                    }
                    Boolean done2 = false;
                    while (!done2) {
                        System.out.print("\nSaisir l'identifiant recherche de la liste ci-dessus:\n");
                        input = cin.next();
                        input += cin.nextLine();
                        identifiant = Integer.parseInt(input);
                        if (!MatchingRecords2.containsKey(identifiant)) {
                            System.out.print("\nL'identifiant entre ne fait pas partie de la liste donnee!\n");
                            System.out.print("\nAucune donnee trouvee!\n");
                            input = cin.next();
                            input += cin.nextLine();
                            while (!input.equals("Y") && !input.equals("N")) {
                                System.out.print("\nChoix invalide!\nSaisir a nouveau:\n ");
                                input = cin.next();
                                input += cin.nextLine();
                            }
                            if (input.equals("N")) {
                                done2 = true;
                                break;
                            }
                        } else {
                            this.AttribuerValeurs(MatchingRecords2.get(identifiant));
                            done2 = done = true;
                            break;
                        }
                    }
                    if (done)
                        break;
                    else {
                        System.out.print("\nAucune donnee trouvee!\n");
                        System.out.print("\nAucune donnee trouvee!\n");
                        input = cin.next();
                        input += cin.nextLine();
                        while (!input.equals("Y") && !input.equals("N")) {
                            System.out.print("\nChoix invalide!\nSaisir a nouveau:\n ");
                            input = cin.next();
                            input += cin.nextLine();
                        }
                        if (input.equals("N")) {
                            done = true;
                            break;
                        }
                    }
                }
            }
        }
        return;
    }

// Fonction de Connexion 

    public boolean connexion(String IdDeConnexion, String MotDePasse) {
        for (Employe employee : com.hms.Entreprise.EmployeList.values()) {
            if (employee.IdDeConnexion.equals(IdDeConnexion) && employee.MotDePasse.equals(MotDePasse)) {
                this.AttribuerValeurs(employee);
                return true;
            }
        }
        return false;
    }
}