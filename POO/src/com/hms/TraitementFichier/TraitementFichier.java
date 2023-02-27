package com.hms.TraitementFichier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Vector;
import java.lang.Thread; 

import com.hms.Entreprise;
import com.hms.persons.Address;
import com.hms.persons.Employe;




class ThreadLecture implements Runnable {
    @Override
    public void run() {
        Entreprise.EmployeList.clear();

        try (BufferedReader br2 = new BufferedReader(new FileReader("../resources/Employe.csv"))) {
            String line;
            while ((line = br2.readLine()) != null) {
                String[] EmployeArray = line.split(",");
                Address _add = new Address();
                _add.traitementStr(EmployeArray[5]);

                Employe _Employe = new Employe(
                        Integer.parseInt(EmployeArray[0]),
                        EmployeArray[1],
                        Integer.parseInt(EmployeArray[2]),
                        EmployeArray[3].charAt(0),
                        EmployeArray[4],
                        _add,
                        EmployeArray[6],
                        EmployeArray[7],
                        EmployeArray[8],
                        Integer.parseInt(EmployeArray[9]),
                        EmployeArray[10],
                        EmployeArray[11]
                );

                Entreprise.EmployeList.put(Integer.parseInt(EmployeArray[0]), _Employe);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThreadEcriture implements Runnable {
    @Override
    public void run() {
        try {
            FileWriter clearFile2 = new FileWriter("../resources/Employe.csv");
            clearFile2.write("");
            clearFile2.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        try (FileWriter writer2 = new FileWriter("../resources/Employe.csv", true)) {
            for (Map.Entry<Integer, Employe> entry : Entreprise.EmployeList.entrySet()) {
                Employe _Employe = entry.getValue();

                StringBuilder s2 = new StringBuilder();
                s2.append(_Employe.getIdentifiant().toString() + ',');
                s2.append(_Employe.getNom() + ',');
                s2.append(_Employe.getAge().toString() + ',');
                s2.append(_Employe.getGenre().toString() + ',');
                s2.append(_Employe.getTelephonne() + ',');
                s2.append(_Employe.getAddresse().ajoutStr() + ',');
                s2.append(_Employe.getFonction() + ',');
                s2.append(_Employe.getType() + ',');
                s2.append(_Employe.getSalaire() + ',');
                s2.append(_Employe.getJoursTravail().toString() + ',');
                s2.append(_Employe.getIdDeConnexion() + ',');
                s2.append(_Employe.getMotDePasse());

                s2.append('\n');

                writer2.append(s2.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class TraitementFichier {
    public static void readFromCSV() {
        ThreadLecture ThreadLecture = new ThreadLecture();
        Thread t2 = new Thread(ThreadLecture);
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }


    public static void writeToCSV() {
        ThreadEcriture ThreadEcriture = new ThreadEcriture();
        Thread t2 = new Thread(ThreadEcriture);
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
}
}