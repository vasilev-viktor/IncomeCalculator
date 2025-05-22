package org.example.Calculator;

// нужно из него сделать синг тон, отвечает за хранение, поиск, удаление, взаимодействие с БД

import java.util.ArrayList;

public class ExpensesRepository {

    private ArrayList<Expenses> allExpenses = new ArrayList<>();

    public void addExpense(Expenses newExpense) {
        allExpenses.add(newExpense);
        System.out.println("Добавлен расход: " + newExpense);
    }

    public ArrayList<Expenses> getAllExpenses() {
        return new ArrayList<>(allExpenses);
    }

//    неужна сортировка для того чтобы вывести на экран, например по сумме

}
