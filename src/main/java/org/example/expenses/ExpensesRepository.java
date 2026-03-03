package org.example.expenses;

// нужно из него сделать сингл тон, отвечает за хранение, поиск, удаление, взаимодействие с БД
// неужна сортировка для того чтобы вывести на экран, например по сумме

import org.example.Utils.ValidationUtils;
import org.example.validation.ValidationResult;

import java.util.ArrayList;
import java.util.List;

public class ExpensesRepository {

    private final List<Expenses> expensesList = new ArrayList<>();

    private ValidationResult validateExpense(String nameNewExpenses, int newExpenses) {
        ValidationResult result = new ValidationResult();
        ValidationUtils.validateProcessingErrors(result, "mandatory", "nameNewExpenses", nameNewExpenses);
        ValidationUtils.validateProcessingErrors(result, "mandatory", "newExpenses", newExpenses);
        ValidationUtils.validateProcessingErrors(result, "number", "newExpenses", newExpenses);
        ValidationUtils.validateProcessingErrors(result, "int max and min", "newExpenses", newExpenses);
        ValidationUtils.validateProcessingErrors(result, "string max and min", "nameNewExpenses", nameNewExpenses);
        ValidationUtils.validateProcessingErrors(result, "allowed characters", "nameNewExpenses", nameNewExpenses);
        return result;
    }

    public void addExpense(String nameNewExpenses, int newExpenses) {
        ValidationResult validationResult = validateExpense(nameNewExpenses, newExpenses);
        if (!validationResult.isValid()) {
            throw new IllegalArgumentException("Validation failed: " + validationResult.getErrors());
        }
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
        expensesList.removeIf(expenses -> expenses.getNameNewExpenses().equals(nameNewExpenses));
        System.out.println("Удаленный расход: " + nameNewExpenses);
    }

    public List<Expenses> getExpensesList() {
        return  new ArrayList<>(expensesList);
    }
}


