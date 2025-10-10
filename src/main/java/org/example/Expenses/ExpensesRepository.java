package org.example.Expenses;

// нужно из него сделать сингл тон, отвечает за хранение, поиск, удаление, взаимодействие с БД
// неужна сортировка для того чтобы вывести на экран, например по сумме

import java.util.ArrayList;
import java.util.List;

public class ExpensesRepository {


    private final List<Expenses> expensesList = new ArrayList<>();


    public void addExpense(String nameNewExpenses, int newExpenses) {
        expensesList.add(new Expenses(newExpenses, nameNewExpenses)); // Добавляю в список
    }

    public List<Expenses> getExpensesList() {
        return  new ArrayList<>(expensesList);
    }



    // + еще 2 метеда, удалить и обновить

    //нужна еще одна связка по пользователю (хранение ЗП) репозиторий и класс создания


}


