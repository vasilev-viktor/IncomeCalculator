package org.example;

//должно быть из сервиса

import org.example.GeneralCalculationsServices.GeneralCalculations;

public class Main {
    public static void main(String[] args) {


        GeneralCalculations generalCalculations = new GeneralCalculations();
        generalCalculations.addUsers(128000);
        generalCalculations.addExpense("Еда", 3000);
        generalCalculations.addExpense("Кредиты", 20000);
        generalCalculations.addExpense("Комуналка", 5000);
        generalCalculations.addSaving("Ремонт", 60);
        generalCalculations.addSaving("Отпуск", 40);

        generalCalculations.subtractionOfExpenses();
        generalCalculations.calculationSaving();


//        generalCalculations.printGeneralCalculations();



    }
}
















