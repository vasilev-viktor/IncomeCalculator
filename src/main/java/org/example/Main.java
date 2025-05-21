package org.example;

import org.example.Calculator.Expenses;
import org.example.Calculator.GeneralCalculations;

public class Main {
    public static void main(String[] args) {
        GeneralCalculations calculator1 = new GeneralCalculations(100000);
        calculator1.subtractionBasic(new Expenses(40000, "Кредит"));
        calculator1.subtractionBasic(new Expenses(3000, "Спорт"));
        calculator1.repairInterest();
        Expenses.dataExpenses(40000, "Кредит");
        Expenses.dataExpenses(3000, "Спорт");







    }


}