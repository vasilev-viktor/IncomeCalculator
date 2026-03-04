package org.example;

//должно быть из сервиса

import org.example.generalCalculationsServices.CalculationManager;

public class Main {
    public static void main(String[] args) {


        CalculationManager generalCalculations = new CalculationManager();
        generalCalculations.addUsers(11000, "Viktor");
        generalCalculations.addExpense("!a", 1000000000);
//        generalCalculations.addExpense("Шоппинг", 10000);
//        generalCalculations.addExpense("Разные расходы", 3000);

        generalCalculations.addSaving("Д", 20);
        generalCalculations.addSaving("Инвестиции Витя", 10);
        generalCalculations.addSaving("Инвестиции Алена", 10);
        generalCalculations.addSaving("Ипотека (Досрочно)", 60);
//        generalCalculations.deleteExpense("Кредиты");
//        generalCalculations.correctionExpense("Комуналка", "комуналка", 1000);
//        generalCalculations.correctionUser("Viktor", "Alena", 150000);



        generalCalculations.additionOfExpenses();
        generalCalculations.subtractionOfExpenses();
        generalCalculations.calculationSaving();
    }
}
















