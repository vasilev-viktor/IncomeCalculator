package org.example.expenses;

// нужно из него сделать сингл тон, отвечает за хранение, поиск, удаление, взаимодействие с БД
// неужна сортировка для того чтобы вывести на экран, например по сумме

import org.example.Utils.ValidationUtils;
import org.example.validation.FieldValidator;
import org.example.validation.ValidationResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpensesRepository {

    private final List<Expenses> expensesList = new ArrayList<>();

    private ValidationResult validateExpense(String name, int amount) {
        ValidationResult result = new ValidationResult();

        FieldValidator nameValidator = ValidationUtils.getValidator("mandatory");
        ValidationResult nameResult = nameValidator.validate("nameNewExpenses", name);
        if (!nameResult.isValid()) for (Map.Entry<String, List<String>> entry : nameResult.getErrors().entrySet())
            for (String error : entry.getValue()) {
                result.addError(entry.getKey(), error);
            }

        FieldValidator numberValidator = ValidationUtils.getValidator("number");
        ValidationResult numberResult = numberValidator.validate("newExpenses", String.valueOf(amount));
        if (!numberResult.isValid()) for (Map.Entry<String, List<String>> entry : numberResult.getErrors().entrySet())
            for (String error : entry.getValue()) {
                result.addError(entry.getKey(), error);
            }

        FieldValidator minMaxValidator = ValidationUtils.getValidator("max and min");
        ValidationResult minMaxResult = minMaxValidator.validate("newExpenses", amount);
        if (!minMaxResult.isValid()) for (Map.Entry<String, List<String>> entry : minMaxResult.getErrors().entrySet())
            for (String error : entry.getValue()) {
                result.addError(entry.getKey(), error);
            }
        return result;
    }

    public void addExpense(String nameNewExpenses, int newExpenses) {
        ValidationResult validationResult = validateExpense(nameNewExpenses, newExpenses);

        if (!validationResult.isValid()) {
            // Выводим ошибки
            for (Map.Entry<String, List<String>> entry : validationResult.getErrors().entrySet()) {
                for (String error : entry.getValue()) {
                    System.out.println("Ошибка валидации: поле " + entry.getKey() + " - " + error);
                }
            }
            return; // Не добавляем, если есть ошибки
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


