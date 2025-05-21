package org.example.Calculator;

import java.util.ArrayList;

public class Expenses {

    int newExpenses;
    String nameNewExpenses;

    public Expenses(int newExpenses, String nameNewExpenses) {
        this.newExpenses = newExpenses;
        this.nameNewExpenses = nameNewExpenses;
    }


    public int getNewExpenses() {
        return newExpenses;
    }

    public void setNewExpenses(int newExpenses) {
        this.newExpenses = newExpenses;
    }

    public String getNameNewExpenses() {
        return nameNewExpenses;
    }

    public void setNameNewExpenses(String nameNewExpenses) {
        this.nameNewExpenses = nameNewExpenses;
    }

    public static ArrayList<Expenses> dataExpenses(int newExpenses, String nameNewExpenses){
        ArrayList<Expenses> expenses = new ArrayList<Expenses>();
        expenses.add(new Expenses(newExpenses, nameNewExpenses));
      for (Expenses expense : expenses) {
          System.out.println(expense);
      }
        return expenses;
    }

}

