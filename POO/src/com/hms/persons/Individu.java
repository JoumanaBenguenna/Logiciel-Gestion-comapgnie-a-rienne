package com.hms.persons;

import java.util.*;
import java.io.*;

// Ce script sert a creer une classe personne aevc les methodes associees //

abstract class Individu {
    protected Integer identifiant;
    protected String nom;
    protected Integer age;
    protected Character genre;
    protected String telephonne;
    protected com.hms.persons.Address adresse;
    protected String fonction;

    public Individu() {
        // On met l'identifiant a -1 pour commencer //
        identifiant = -1;
    }

    public Individu(Integer identifiant, String nom, Integer age, Character genre, String telephonne, com.hms.persons.Address adresse,
            String fonction) { 
        this.identifiant = identifiant;
        this.nom = nom;
        this.age = age;
        this.genre = genre;
        this.telephonne = telephonne;
        this.adresse = adresse;
        this.fonction = fonction;
    }

    public void AjouterPersonnel(Integer Age_minimum, Integer Age_maximum) {
        Scanner cin = new Scanner(System.in); // Demander des informations sur la console //
        String valeur_input; // Cette variable sert de buffer pour mettre les entrees //


        System.out.print("\nEntrez le nom:\n");
        // Lecture de la donnee entree en ligne de commande //
        valeur_input = cin.next();
        valeur_input += cin.nextLine();
        nom = valeur_input; //On stocke la valeur entree dans la variable nom //


        System.out.print("\nEntrez l'age:\n");
        boolean flag = true;
        while (flag) {
            // Lecture de la donnee entree en ligne de commande //
            valeur_input = cin.next();
            valeur_input += cin.nextLine();
            try {
                age = Integer.parseInt(valeur_input); // On cast la donne entree en entier //
                //Disjonction des cas //
                if (age <= 0)
                    System.out.print("Veuillez saisir un age valide.\n");
                else if (age < Age_minimum) {
                    System.out.print("\n Desole, cette personne doit avoir au minimim " + Age_minimum
                            + "ans pour pouvoir etre inscrite" + fonction + ".\n");
                    this.identifiant = -2;
                    return;
                } else if (age > Age_maximum) {
                    System.out.print(
                            "\nDesole, aucune personne de plus que " + Age_maximum + " and ne peut etre inscrite" + fonction + ".\n");
                    this.identifiant = -2;
                    return;
                } else
                    flag = false; // On sort de la boucle
            } catch (NumberFormatException e) {  // Si la saisie n'est pas un entier
                System.out.print("Veuillez saisir un age valide:\n");
            }
        }
        System.out.print("\ngenre (M = Masculin || F = Feminin):\n");
        valeur_input = "A"; //On ne sait pas encore si c'est masculin ou feminin
        while (!valeur_input.equals("M") && !valeur_input.equals("F")) {
            //On rentre dans la boucle une premiere fois et on lit sur la console la valeur
            valeur_input = cin.next();
            valeur_input += cin.nextLine();
            genre = valeur_input.charAt(0); //On rentre le premier parametre entre en console
            if (!valeur_input.equals("M") && !valeur_input.equals("F"))
                System.out.print("M ou F?\n");
        }
        System.out.print("\nVeuillez saisir un numero de telephonne:\n");
        //On lit dans la ligne de commande
        valeur_input = cin.next();
        valeur_input += cin.nextLine();
        telephonne = valeur_input;
        adresse = new com.hms.persons.Address();
        adresse.takeInput(); // Voir la classe Adress pour cette methode //
        return;
    }

    public void AfficherInfo() {
        if (identifiant == -1)
            return;
        System.out.print("Identifiant                    : " + identifiant + "\n");
        System.out.print("Nom de l'employe               : " + nom + "\n");
        System.out.print("Genre de l'employe             : " + genre + "\n");
        System.out.print("Age de l'employe               : " + age + "\n");
        System.out.print("Numero de telephonne           : " + telephonne + "\n");
        System.out.print("Adresse de l'employe           : ");
        adresse.print();
        return;
    }

    public void AttribuerValeurs(Individu individu) {
        // Cette methode attribu les valeurs des attribus de la classe a des variables
        identifiant = individu.identifiant;
        nom = individu.nom;
        age = individu.age;
        genre = individu.genre;
        telephonne = individu.telephonne;
        adresse = individu.adresse;
        fonction = individu.fonction;
        return;
    }

    public void  AfficherInfoDansHistorique() {
        // Cette methode affiche les informations du personnel sur la console
        if (identifiant == -1)
            return;
        System.out.print("\n Informations de l'employe :\n");
        System.out.print("Nom de l'employe           : " + nom + "\n");
        System.out.print("Genre de l'employe         : " + genre + "\n");
        System.out.print("Age de l'employe           : " + age + "\n");
        System.out.print("Numero de telephonne       : " + telephonne + "\n");
        System.out.print("Adresse de l'employe       : ");
        adresse.print();
        return;
    }

    public void setTelephonne(String telephonne) {
        //Cette fonction est un setter
        this.telephonne = telephonne;
    }

    // Ces methodes sont des getter desattribus de la classe Individu

    public Integer getAge() {
        return age;
    }

    public String getNom() {
        return nom;
    }

    public Integer getIdentifiant() {
        return identifiant;
    }

    public String getFonction() {
        return fonction;
    }

    public String getTelephonne() {
        return telephonne;
    }

    public Address getAddresse() {
        return adresse;
    }

    public Character getGenre() {
        return genre;
    }

    // Methode abstraite//
    public abstract void getInfos(); // Voir la classe Employes Pour les details
}
