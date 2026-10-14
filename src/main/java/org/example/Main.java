package org.example;

//должно быть из сервиса

import org.example.generalCalculationsServices.CalculationManager;

public class Main {
    public static void main(String[] args) {

        CalculationManager generalCalculations = new CalculationManager();
        generalCalculations.addUsers(256000, "Viktor");
        generalCalculations.addExpense("Еда", 30000);
        generalCalculations.addExpense("Аренда", 70000);
        generalCalculations.addExpense("Квартплата", 9000);
        generalCalculations.addExpense("Валдберис", 8000);
        generalCalculations.addExpense("Возврат на счет", 47000);
        generalCalculations.addExpense("Еда сегодня", 3000);
        generalCalculations.addExpense("Поход", 10000);
        generalCalculations.addExpense("Танцы", 2000);
        generalCalculations.addExpense("Больница", 15000);

        generalCalculations.addSaving("Ремонт", 60);
        generalCalculations.addSaving("Инвестиции Витя", 15);
        generalCalculations.addSaving("Инвестиции Алена", 15);
        generalCalculations.addSaving("Ипотека Досрочно", 10);
//        generalCalculations.deleteExpense("Кредиты");
//        generalCalculations.correctionExpense("Комуналка", "комуналка", 1000);
//        generalCalculations.correctionUser("Viktor", "Alena", 150000);


        generalCalculations.additionOfExpenses();
        generalCalculations.subtractionOfExpenses();
        generalCalculations.calculationSaving();
    }
}
















