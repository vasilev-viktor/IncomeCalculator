package org.example;

//должно быть из сервиса

import org.example.GeneralCalculationsServices.GeneralCalculations;

public class Main {
    public static void main(String[] args) {


        GeneralCalculations generalCalculations = new GeneralCalculations();
        generalCalculations.addUsers(150000, "Viktor");
        generalCalculations.addExpense("Еда", 3000);
        generalCalculations.addExpense("Кредиты", 20000);
        generalCalculations.addExpense("Комуналка", 5000);
        generalCalculations.addSaving("Ремонт", 39);
        generalCalculations.addSaving("Отпуск", 46);
        generalCalculations.addSaving("Отпуск", 15);
        generalCalculations.deleteExpense("Кредиты");
        generalCalculations.correctionExpense("Комуналка", "комуналка", 1000);



        generalCalculations.additionOfExpenses();
        generalCalculations.subtractionOfExpenses();
        generalCalculations.calculationSaving();

//        generalCalculations.printGeneralCalculations();



    }
}
















