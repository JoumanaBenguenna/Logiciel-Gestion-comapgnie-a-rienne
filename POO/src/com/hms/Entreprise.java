package com.hms;

import com.hms.persons.*;
import java.util.*;
import java.io.*;

public class Entreprise {
    public static TreeMap<Integer, Employe> EmployeList = new TreeMap<>();


    public static void printEmployeDetails() {
        for (var Employe : EmployeList.entrySet()) {
            Employe.getValue().AfficherInfo();
            System.out.print("\n");
        }
    }

}
