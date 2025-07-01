package org.example;

//должно быть из сервиса

import org.example.Calculator.ExpensesRepository;

public class Main {
    public static void main(String[] args) {
        ExpensesRepository expensesRepository = new ExpensesRepository();
        expensesRepository.expensesList(12000);
        expensesRepository.addExpense("Еда", 3000);
        expensesRepository.addExpense("Кредиты", 2000);
        expensesRepository.addExpense("Комуналка", 5000);
        expensesRepository.printExpenses();

    }
}
















