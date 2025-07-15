package org.example.Saving;


import java.util.ArrayList;
import java.util.List;

public class SavingRepository {


    private final List<Saving> savingList = new ArrayList<>();


    public void addSaving(String nameNewSavings, int newSavings) {
        savingList.add(new Saving(newSavings, nameNewSavings)); // Добавляю в список
    }

    public List<Saving> getSavingList() {
        return List.of(savingList.toArray(new Saving[0]));

    }
}



//    private int initialSaving;
//    private ArrayList<Saving> savingList;
//
//    public void savingRepository(int initialSaving) {
//        this.initialSaving = initialSaving;
//        this.savingList = new ArrayList<>();
//    }
//
//    public void addSaving(String nameNewSaving, int newSaving) {
//        savingList.add(new Saving(newSaving, nameNewSaving)); // Добавляю в список
//    }
//
//    public double getInitialSaving() {
//        return initialSaving;
//    }
//
//
//    public void printSaving() {
//        System.out.println("\nСбережения: " + getInitialSaving() + "\nСписок сбережений: ");
//        for (Saving saving : savingList) {
//            System.out.println(saving);
//        }
//
//    }

