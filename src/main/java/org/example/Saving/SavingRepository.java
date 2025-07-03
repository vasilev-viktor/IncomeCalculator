package org.example.Saving;

import org.example.Expenses.Expenses;

import java.util.ArrayList;

public class SavingRepository {

    private double initialSaving;
    private ArrayList<Saving> savingList;

    public void savingRepository(double initialSaving) {
        this.initialSaving = initialSaving;
        this.savingList = new ArrayList<>();
    }

    public void addSaving(String nameNewSaving, double newSaving) {
        savingList.add(new Saving(newSaving, nameNewSaving)); // Добавляю в список
    }

    public double getInitialSaving() {
        return initialSaving;
    }


    public void printSaving() {
        System.out.println("\nСбережения: " + getInitialSaving() + "\nСписок сбережений: ");
        for (Saving saving : savingList) {
            System.out.println(saving);
        }

    }
}
