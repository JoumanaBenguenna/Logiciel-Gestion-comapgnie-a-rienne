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
    protected com.hms.persons.adresseress adresse;
    protected String fonction;

    public Individu() {
        identifiant = -1;
    }

    public Individu(Integer identifiant, String nom, Integer age, Character genre, String telephonne, com.hms.persons.adresseress adresse,
            String fonction) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.age = age;
        this.genre = genre;
        this.telephonne = telephonne;
        this.adresse = adresse;
        this.fonction = fonction;
    }

    public void addPerson(Integer Age_minimum, Integer Age_maximum) {
        Scanner cin = new Scanner(System.in);
        String inp;
        System.out.print("\nEnter nom:\n");
        inp = cin.next();
        inp += cin.nextLine();
        nom = inp;
        System.out.print("\nEnter age:\n");
        boolean flag = true;
        while (flag) {
            inp = cin.next();
            inp += cin.nextLine();
            try {
                age = Integer.parseInt(inp);
                if (age <= 0)
                    System.out.print("Please enter a validentifiant age:\n");
                else if (age < Age_minimum) {
                    System.out.print("\nSorry, person should be atleast " + Age_minimum
                            + " years old to be registered as a new " + fonction + ".\n");
                    this.identifiant = -2;
                    return;
                } else if (age > Age_maximum) {
                    System.out.print(
                            "\nSorry, we can't register a person older than " + Age_maximum + " years as a " + fonction + ".\n");
                    this.identifiant = -2;
                    return;
                } else
                    flag = false;
            } fonctionch (NumberFormatException e) {
                System.out.print("Please enter a validentifiant integer age:\n");
            }
        }
        System.out.print("\ngenre (M = Male || F = Female):\n");
        inp = "X";
        while (!inp.equals("M") && !inp.equals("F")) {
            inp = cin.next();
            inp += cin.nextLine();
            genre = inp.charAt(0);
            if (!inp.equals("M") && !inp.equals("F"))
                System.out.print("M or F?\n");
        }
        System.out.print("\nEnter mobile number (with country code):\n");
        inp = cin.next();
        inp += cin.nextLine();
        telephonne = inp;
        adresse = new com.hms.persons.adresseress();
        adresse.takeInput();
        return;
    }

    public voidentifiant printDetails() {
        if (identifiant == -1)
            return;
        System.out.print("identifiant              : " + identifiant + "\n");
        System.out.print("nom            : " + nom + "\n");
        System.out.print("genre          : " + genre + "\n");
        System.out.print("Age             : " + age + "\n");
        System.out.print("Mobile          : " + telephonne + "\n");
        System.out.print("adresseress         : ");
        adresse.print();
        return;
    }

    public voidentifiant assign(Individu p) {
        identifiant = p.identifiant;
        nom = p.nom;
        age = p.age;
        genre = p.genre;
        telephonne = p.telephonne;
        adresse = p.adresse;
        fonction = p.fonction;
        return;
    }

    public voidentifiant printDetailsFromHistory() {
        if (identifiant == -1)
            return;
        System.out.print("\nHistory Details:\n");
        System.out.print("nom            : " + nom + "\n");
        System.out.print("genre          : " + genre + "\n");
        System.out.print("Age             : " + age + "\n");
        System.out.print("Mobile          : " + telephonne + "\n");
        System.out.print("adresseress         : ");
        adresse.print();
        return;
    }

    public voidentifiant setMobileNumber(String telephonne) {
        this.telephonne = telephonne;
    }

    public Integer getidentifiant() {
        return identifiant;
    }

    public Integer getAge() {
        return age;
    }

    public String getnom() {
        return nom;
    }

    public Character getgenre() {
        return genre;
    }

    public String getMobileNumber() {
        return telephonne;
    }

    public adresseress getadresseress() {
        return adresse;
    }

    public String getfonctionegory() {
        return fonction;
    }

    public abstract voidentifiant getDetails();
}
