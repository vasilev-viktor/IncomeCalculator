package org.example.GeneralCalculationsServices;


import org.example.Expenses.Expenses;
import org.example.Expenses.ExpensesRepository;
import org.example.Saving.Saving;
import org.example.Saving.SavingRepository;
import org.example.User.UserRepository;
import org.example.User.Users;

import java.util.ArrayList;
import java.util.List;


public class GeneralCalculations {
// нужно потокобезопасное значение


    private ExpensesRepository expensesRepository = new ExpensesRepository();
    private SavingRepository savingRepository = new SavingRepository();
    private UserRepository userRepository = new UserRepository();

    public void addExpense(String nameNewExpenses, int newExpenses) {
        expensesRepository.addExpense(nameNewExpenses, newExpenses);
    }

    // разделить на 2, класс где сначала заполняю список, другой метод считать(на вход список), результат вычислений будет список который нужно потом посчитать
    public void addSaving(String nameNewSaving, int newSaving) {
        savingRepository.addSaving(nameNewSaving, newSaving);
    }

    public void addUsers(int salaryOriginal) {
        userRepository.addUsersOriginal(salaryOriginal);
    }

    public void subtractionOfExpenses() {
        List<Expenses> expensesListExpenses = expensesRepository.getExpensesList();
        List<Users> usersExpenses = userRepository.getUsersOriginalList();
        for (Expenses expenses : expensesListExpenses) {
            for (Users user : usersExpenses) {
                int subtraction = user.getSalaryOriginal() - expenses.getNewExpenses();
                user.setSalaryOriginal(subtraction);
            }
        }
    }

    public void calculationSaving() {
        List<Users> usersSaving = userRepository.getUsersOriginalList();
        List<Saving> savingsListSaving = savingRepository.getSavingList();
        for (Saving saving : savingsListSaving) {
            for (Users user : usersSaving) {
                int calculationSaving = user.getSalaryOriginal() * saving.getNewSavings() / 100;
                saving.setNewSavings(calculationSaving);
                int subtractionSaving = user.getSalaryOriginal() - saving.getNewSavings();
                user.setSalaryOriginal(subtractionSaving);
            }

        }

    }

}
// for (Saving saving : savingsGeneral) {
//remainingAfterSavings = (salaryGeneral * saving.getNewSavings() / 100);



// можно без гетеров и сетеров, можно через них, бежно без, главное объеянить зачем они
// зависит от стиля команды, использовать гетеры в одном классе или нет, заложение логики в гетеры и сеттеры это плохая логика, делается ради инкопсуляции, почему в данном коде она не нужна.

// как классы, медоды и переменные между собой взаимодействуют! - надо это осознать

// фор ич ИЗУЧИТЬ!
// отдельно добовление! отдельно потсчет

// сингл тон


// тред сейф
// переменные класса должны быть константами
// использовать логер вместо System.out.println, нужен подключаемый логер
//метод СРП
// 1 метод сохраняем в себе, другой на вычисление

//синглтон - нет внедрения зависимости и контейнера класса. набор экземпляров класса. сервис = один объект. так как нет библиотек, можно сингл тон.
//инстанс?

// вопрос к собесу - геттеры и сеттеры как работают эти методы, как передаются


//    private int amount;
//    private int salaryGeneral;                      // Общая зарплата
//    private final int initialAmount;// Список расходов
//    private final ArrayList<Saving> savingsGeneral;       // Список сбережений
//    private int remainingAfterExpenses;          // Остаток после расходов
//    private int remainingAfterSavings;           // Остаток после сбережений
//
//    public GeneralCalculations(int initialAmount) {
//        this.salaryGeneral = initialAmount;
//        this.initialAmount = initialAmount;
//        this.savingsGeneral = new ArrayList<>();
//    }


// новый метод где считать будет все
//int totalPercentage = savingsGeneral.stream()
//        .mapToInt(Saving::getNewSavings).sum();
//
//        if (totalPercentage > 100.0) {
//        System.out.println("Внимание! Общий процент сбережений превышает 100%!");
//        }
//
//                // Вычисляем сбережения
//                for (Saving saving : savingsGeneral) {
//remainingAfterSavings = (salaryGeneral * saving.getNewSavings() / 100);
//            amount = remainingAfterSavings;
//        }
//        System.out.println(remainingAfterSavings);
//       amount = remainingAfterSavings;
//
// нужен массив


//    public int getAmount() {
//        return amount;
//    }
//
//    public int getInitialAmountGeneral() {
//        return initialAmount;
//    }
//
//    public int getSalaryGeneral() {
//        return salaryGeneral;
//    }
//
//    public int getRemainingAfterExpenses() {
//        return remainingAfterExpenses;
//    }
//
//    public int getRemainingAfterSavings() {
//        return remainingAfterSavings;
//    }
//
//
//    public  void printGeneralCalculations(){
//        System.out.println("\nЗарплата: " + getInitialAmountGeneral() + "\nСписок расходов: ");
//        for (Expenses expense : expensesRepository.getExpensesList()) {
//            System.out.println(expense);
//        }
//        System.out.println("\nОстаток после затрат: " + getSalaryGeneral());
//        System.out.println("\nСписок сбережений: ");
//        for (Saving saving : savingsGeneral) {
//            System.out.println(saving);
//            System.out.println(getRemainingAfterSavings());
//            System.out.println(amount);
//
//        }
//        System.out.println("\nОстаток после расходов и сбережений: " + getRemainingAfterExpenses());
//    }

















