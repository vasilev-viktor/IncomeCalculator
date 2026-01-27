package org.example;

//должно быть из сервиса

import org.example.generalCalculationsServices.GeneralCalculations;

public class Main {
    public static void main(String[] args) {


        GeneralCalculations generalCalculations = new GeneralCalculations();
        generalCalculations.addUsers(200000, "Viktor");
        generalCalculations.addExpense("Еда", 4000);
        generalCalculations.addExpense("Остальные расходы (одежда)", 3000);
        generalCalculations.addExpense("Комуналка", 3000);

        generalCalculations.addSaving("Сбережения", 20);
        generalCalculations.addSaving("Инвестиции", 10);
        generalCalculations.addSaving("Ипотека (Досрочно)", 70);
//        generalCalculations.deleteExpense("Кредиты");
//        generalCalculations.correctionExpense("Комуналка", "комуналка", 1000);
//        generalCalculations.correctionUser("Viktor", "Alena", 150000);



        generalCalculations.additionOfExpenses();
        generalCalculations.subtractionOfExpenses();
        generalCalculations.calculationSaving();

//        generalCalculations.printGeneralCalculations();


    }
}
















