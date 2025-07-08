package org.example;

//должно быть из сервиса

import org.example.Expenses.ExpensesRepository;
import org.example.GeneralCalculationsServices.GeneralCalculations;

public class Main {
    public static void main(String[] args) {


        GeneralCalculations generalCalculations = new GeneralCalculations(100000);
        generalCalculations.addExpenseCalculate("Еда", 3000);
        generalCalculations.addExpenseCalculate("Кредиты", 20000);
        generalCalculations.addExpenseCalculate("Комуналка", 5000);
        generalCalculations.addSavingCalculate("Ремонт", 60);
        generalCalculations.addSavingCalculate("Отпуск", 40);
        generalCalculations.printGeneralCalculations();









//        ExpensesRepository expensesRepository = new ExpensesRepository();
//        expensesRepository.expensesList(12000);
//        expensesRepository.addExpense("Еда", 3000);
//        expensesRepository.addExpense("Кредиты", 2000);
//        expensesRepository.addExpense("Комуналка", 5000);
//        expensesRepository.printExpenses();


    }
}
















