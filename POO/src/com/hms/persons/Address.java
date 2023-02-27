package com.hms.persons;

import java.util.*;
import java.io.*;

public class Address {
    protected String adresse1;
    protected String adresse2;
    protected String ville;
    protected String departement;
    protected String codePostal;
    protected String pays;

    public Address() {
        adresse1 =    "";
        adresse2 =    "";
        ville =       "";
        departement = "";
        codePostal =  "";
        pays =        "";
    }

    public void takeInput() {
        Scanner cin = new Scanner(System.in);
        System.out.print("\nEnter Address:\n");
        System.out.print("\nEnter Line 1:\n");
        adresse1 = cin.nextLine();
        System.out.print("\nEnter Line 2:\n");
        adresse2 = cin.nextLine();
        System.out.print("\nEnter ville:\n");
        ville = cin.nextLine();
        System.out.print("\nEnter departement:\n");
        departement = cin.nextLine();
        System.out.print("\nEnter codePostal:\n");
        codePostal = cin.nextLine();
        System.out.print("\nEntrer pays:\n");
        pays = cin.nextLine();
    }

    public void print() {
        System.out.print("Adresse 1: " + adresse1 + "\n");
        if (adresse2 != "")
        System.out.print("------------------Adresse 2: " + adresse2 + "\n");
        System.out.print("----------------------ville: " + ville + "\n");
        System.out.print("----------------departement: " + departement + "\n");
        System.out.print("-----------------codePostal: " + codePostal + "\n");
        System.out.print("-----------------------pays: " + pays + "\n");
        return;
    }

    public void traitementStr(String add) {
        String[] arr = add.split("`");
        adresse1 = arr[0].replace("^", ",");
        adresse2 = arr[1].replace("^", ",");
        ville = arr[2];
        departement = arr[3];
        codePostal = arr[4];
        pays = arr[5];
    }

    public String ajoutStr() {
        String add = String.format("%s`%s`%s`%s`%s`%s`",
                                   adresse1.replace(",", "^"),
                                   adresse2.replace(",", "^"),
                                   ville, departement, codePostal, pays);
        return add;
    }
}