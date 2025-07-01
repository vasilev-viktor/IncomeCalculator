package org.example.Calculator;

// нужно из него сделать сингл тон, отвечает за хранение, поиск, удаление, взаимодействие с БД
// неужна сортировка для того чтобы вывести на экран, например по сумме

import java.util.ArrayList;

public class ExpensesRepository {

    private int salary;
    private int initialSalary;
    private ArrayList<Expenses> expensesList;


    public void expensesList(int initialSalary) {
        this.salary = initialSalary;
        this.initialSalary = initialSalary;
        this.expensesList = new ArrayList<>();
    }

    public void addExpense(String nameNewExpenses, int newExpenses) {
        expensesList.add(new Expenses(newExpenses, nameNewExpenses)); // Добавляю в список
        salary -= newExpenses;
    }

    // Возвращает текущий остаток зарплаты
    public int getRemainingSalary() {
        return salary;
    }
    // Возвращает введенной зарплаты
    public int getInitialSalary() {
        return initialSalary;
    }

    public void printExpenses() {
        System.out.println("\nЗарплата: " + getInitialSalary() + "\nСписок расходов: ");
        for (Expenses expense : expensesList) {
            System.out.println(expense);
        }
        System.out.println("\nОстаток после расходов: " + getRemainingSalary());
    }
}


