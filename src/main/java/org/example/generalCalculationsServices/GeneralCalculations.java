package org.example.generalCalculationsServices;


import org.example.expenses.Expenses;
import org.example.expenses.ExpensesRepository;
import org.example.saving.Saving;
import org.example.saving.SavingRepository;
import org.example.user.UserRepository;
import org.example.user.Users;
import org.example.validation.ValidatorFactory;

import java.util.List;

public class GeneralCalculations {

    private int addingUpExpenses;
    private int salaryAfterDeductionOfExpenses;

    private ExpensesRepository expensesRepository = new ExpensesRepository();
    private SavingRepository savingRepository = new SavingRepository();
    private UserRepository userRepository = new UserRepository();
    private ValidatorFactory validatorFactory = new ValidatorFactory();

    public void addExpense(String nameNewExpenses, int newExpenses) {
        expensesRepository.addExpense(nameNewExpenses, newExpenses);
    }

    public void addSaving(String nameNewSaving, int newSaving) {
        savingRepository.addSaving(nameNewSaving, newSaving);
    }

    public void addUsers(int salaryOriginal, String userName) {
        userRepository.addUsersOriginal(salaryOriginal, userName);
    }

    public void deleteExpense(String nameNewExpenses) {
        expensesRepository.deleteExpense(nameNewExpenses);
    }

    public void correctionExpense(String oldName, String nameNewExpenses, int newExpenses) {
        expensesRepository.correctionExpense(oldName, nameNewExpenses, newExpenses);
    }

    public void deleteSaving(String nameSaving) {
        savingRepository.deleteSaving(nameSaving);
    }

    public void deleteUser(String nameUser) {
        userRepository.deleteUser(nameUser);
    }

    public void correctionSaving(String oldName, String nameSaving, int newSaving) {
        savingRepository.correctionSaving(oldName, nameSaving, newSaving);
    }

    public void correctionUser(String oldName, String nameUser, int newUser) {
        userRepository.correctionUser(oldName, nameUser, newUser);
    }

    public void additionOfExpenses() {
        List<Expenses> expensesListExpenses = expensesRepository.getExpensesList();
        addingUpExpenses = expensesListExpenses.stream().mapToInt(Expenses::getNewExpenses).sum();
        userRepository.getUsersOriginalList().forEach(System.out::println);
        System.out.println("\n//СУММА РАСХОДОВ: " + addingUpExpenses);
        expensesListExpenses.forEach(System.out::print);
    }

    public void subtractionOfExpenses() {
        List<Users> usersExpenses = userRepository.getUsersOriginalList();
        for (Users user : usersExpenses) {
            salaryAfterDeductionOfExpenses = user.getSalaryOriginal() - addingUpExpenses;
            System.out.println();
            System.out.println("\n//ОСТАЛОСЬ ПОСЛЕ РАСХОДОВ: " + salaryAfterDeductionOfExpenses);
        }
    }

    public void calculationSaving() {
        List<Saving> savingListSaving = savingRepository.getSavingList();
        for (Saving saving : savingListSaving) {
            int total = salaryAfterDeductionOfExpenses * saving.getNewSavings() / 100;
            System.out.print(saving + " " + total);
        }
    }
}



