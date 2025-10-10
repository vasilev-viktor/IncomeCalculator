package org.example.GeneralCalculationsServices;


import org.example.Expenses.Expenses;
import org.example.Expenses.ExpensesRepository;
import org.example.Saving.Saving;
import org.example.Saving.SavingRepository;
import org.example.User.UserRepository;
import org.example.User.Users;

import java.util.List;

public class GeneralCalculations {
// нужно потокобезопасное значение

    private int addingUpExpenses;
    private int salaryAfterDeductionOfExpenses;


    private ExpensesRepository expensesRepository = new ExpensesRepository();
    private SavingRepository savingRepository = new SavingRepository();
    private UserRepository userRepository = new UserRepository();

    public void addExpense(String nameNewExpenses, int newExpenses) {
        expensesRepository.addExpense(nameNewExpenses, newExpenses);
    }

    public void addSaving(String nameNewSaving, int newSaving) {
        savingRepository.addSaving(nameNewSaving, newSaving);
    }

    public void addUsers(int salaryOriginal, String userName) {
        userRepository.addUsersOriginal(salaryOriginal, userName);
    }

    // вычесть из ЗП расходы (additionOfExpenses())
    public void subtractionOfExpenses() {
        List<Users> usersExpenses = userRepository.getUsersOriginalList();
        for (Users user : usersExpenses) {
            salaryAfterDeductionOfExpenses = user.getSalaryOriginal() - addingUpExpenses;
            System.out.println(salaryAfterDeductionOfExpenses);
        }
    }

    // сложить все расходы
    public void additionOfExpenses() {
        List<Expenses> expensesListExpenses = expensesRepository.getExpensesList();
        addingUpExpenses = expensesListExpenses.stream().mapToInt(Expenses::getNewExpenses).sum();
        System.out.println("Total additional expenses: " + addingUpExpenses);
    }

    //Вычисление сбережений
    public void calculationSaving() {
        List<Saving> savingListSaving = savingRepository.getSavingList();
        for (Saving saving : savingListSaving) {
            int total = salaryAfterDeductionOfExpenses * saving.getNewSavings() / 100;
            System.out.println("Total salary after deduction of expenses: " + total);

        }
    }
}



