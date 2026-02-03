package org.example.expenses;

// нужно из него сделать сингл тон, отвечает за хранение, поиск, удаление, взаимодействие с БД
// неужна сортировка для того чтобы вывести на экран, например по сумме

import java.util.ArrayList;
import java.util.List;

public class ExpensesRepository {

    private final List<Expenses> expensesList = new ArrayList<>();

    public void addExpense(String nameNewExpenses, int newExpenses) {
        expensesList.add(new Expenses(newExpenses, nameNewExpenses)); // Добавляю в список
    }

    public void correctionExpense(String oldName, String nameNewExpenses, int newExpenses) {
        for (Expenses expenses : expensesList) {
            if (expenses.getNameNewExpenses().equals(oldName)) {
                expenses.setNameNewExpenses(nameNewExpenses);
                expenses.setNewExpenses(newExpenses);
            }
        }
        System.out.println("Старое значение: "+oldName + ", Новое имя расхода: " + nameNewExpenses + ", Новая сумма расхода: " + newExpenses);
    }

    public void deleteExpense(String nameNewExpenses) {
        for (Expenses expenses : expensesList) {
            if (expenses.getNameNewExpenses().equals(nameNewExpenses)) {
                expensesList.remove(expenses);
            }
        }
        System.out.println("Удаленный расход: " + nameNewExpenses);
    }

    public List<Expenses> getExpensesList() {
        return  new ArrayList<>(expensesList);
    }
}


