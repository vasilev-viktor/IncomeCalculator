package org.example.Expenses;

public class Expenses {


   private int newExpenses;
   private String nameNewExpenses;


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



    @Override
    public String toString() {
        return  "\nСумма: " + newExpenses +
                " Название: " + nameNewExpenses;
    }


}

// надо создать храниище данных
// мап нужен чтобы создать
// дто?
