package org.example.GeneralCalculationsServices;

import org.example.Expenses.Expenses;
import org.example.Saving.Saving;

import java.util.ArrayList;

public class GeneralCalculations {
    private int salaryGeneral;                      // Общая зарплата
    private int initialAmount;
    private ArrayList<Expenses> expensesGeneral;    // Список расходов
    private ArrayList<Saving> savingsGeneral;       // Список сбережений
    private double remainingAfterExpenses;          // Остаток после расходов
    private double remainingAfterSavings;           // Остаток после сбережений

    public GeneralCalculations(int initialAmount) {
        this.salaryGeneral = initialAmount;
        this.initialAmount = initialAmount;
        this.expensesGeneral = new ArrayList<>();
        this.savingsGeneral = new ArrayList<>();
    }

    public void addExpenseCalculate(String nameNewExpenses, int newExpenses){
        expensesGeneral.add(new Expenses(newExpenses, nameNewExpenses));
        salaryGeneral -= newExpenses;
    }


    public  void addSavingCalculate(String nameNewSaving, double newSaving){
        savingsGeneral.add(new Saving(newSaving, nameNewSaving));

        double totalPercentage = savingsGeneral.stream()
                .mapToDouble(Saving::getNewSavings).sum();

        if (totalPercentage > 100) {
            System.out.println("Внимание! Общий процент сбережений превышает 100%!");
        }

        // Вычисляем остаток после сбережений
        remainingAfterSavings = remainingAfterExpenses;
        for (Saving saving : savingsGeneral) {
            double amount = remainingAfterExpenses * saving.getNewSavings() / 100;
            remainingAfterSavings -= amount;
        }
    }

    public int getInitialAmountGeneral() {
        return initialAmount;
    }

    public int getSalaryGeneral() {
        return salaryGeneral;
    }

    public double getRemainingAfterExpenses() {
        return remainingAfterExpenses;
    }

    public double getRemainingAfterSavings() {
        return remainingAfterSavings;
    }

    public  void printGeneralCalculations(){
        System.out.println("\nЗарплата: " + getInitialAmountGeneral() + "\nСписок расходов: ");
        for (Expenses expense : expensesGeneral) {
            System.out.println(expense);
        }
        System.out.println("\nОстаток после затрат: " + getSalaryGeneral());
        System.out.println("\nСбережения: " + getRemainingAfterExpenses() + "\nСписок сбережений: ");
        for (Saving saving : savingsGeneral) {
            System.out.println(saving);
        }
        System.out.println("\nОстаток после расходов: " + getRemainingAfterSavings());
    }


}











//    public void calculation() {
//        // Суммируем все расходы
//        double totalExpenses = expensesGeneral.stream()
//                .mapToDouble(Expenses::getNewExpenses).sum();
//        // Вычисляем остаток после расходов
//        remainingAfterExpenses = salaryGeneral - totalExpenses;
//
//        // Проверяем, чтобы сумма процентов не превышала 100%
//        double totalPercentage = savingsGeneral.stream()
//                .mapToDouble(Saving::getNewSavings).sum();
//
//        if (totalPercentage > 100) {
//            System.out.println("Внимание! Общий процент сбережений превышает 100%!");
//        }
//
//        /** @param
//         * stream() - преобразует коллекцию в поток данных (последовательность элементов, поддерживающих различные операции)
//         * mapToDouble - преобразует каждый элемент потока в double
//         * (Expenses::getNewExpenses) - method reference - компактный синтаксис для передачи аргумента
//         * sum() - Суммирует все элементы потока double, возвращает общую сумму в виде примитивного потока double
//         * */
//
//
//        // Вычисляем остаток после сбережений
//        remainingAfterSavings = remainingAfterExpenses;
//        for (Saving saving : savingsGeneral) {
//            double amount = remainingAfterExpenses * saving.getNewSavings() / 100;
//            remainingAfterSavings -= amount;
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "GeneralCalculations{" +
//                "salaryGeneral=" + salaryGeneral +
//                ", expensesGeneral=" + expensesGeneral +
//                ", savingsGeneral=" + savingsGeneral +
//                ", remainingAfterExpenses=" + remainingAfterExpenses +
//                ", remainingAfterSavings=" + remainingAfterSavings +
//                '}';
//    }


//    int salary;
//    int balance;
//    int newExpensesGeneral;
//    String nameNewExpensesGeneral;
//
//    public GeneralCalculations(int salary)  {
//        this.salary = salary;
//    }
//
//
//    public void setSalary(int salary) {
//        this.salary = salary;
//    }
//
//    public int getSalary() {
//        return salary;
//    }
//
//
//    // Класс subtractionBasic отражает все расходы, можно вписать сумму и узнать сколько останется после всех расходов
//    public void subtractionBasic(Expenses expenses) {
//
//        int amountConsumables = expenses.getNewExpenses();
//        String nameNewExpensesSubtractionBasic = expenses.getNameNewExpenses();
//        System.out.println("Посчитать");
//        System.out.println("Сумма поступила: " + salary);
//        System.out.println("Сумма всех ежемесячных расходников " + nameNewExpensesSubtractionBasic + ": "
//                + amountConsumables);
//        if (amountConsumables <= salary) {
//            balance = salary - amountConsumables;
//            System.out.println("Остаток зарплаты за вычетом расходников: " + balance);
//        }
//    }
//
//    // Метод отвечает за вычисление на ремонт и сбережения
//    public void repairInterest() {
//        if (balance > 0) {
//            double interestRepair = 0.7;
//            double savingsForRepairs = interestRepair * balance;
//            double remainder = balance - savingsForRepairs;
//            System.out.println("Отложить 70% от остатка на ремонт: " + savingsForRepairs);
//            System.out.println("Отложить остальное на общие сбережения: " + remainder);
//        } else {
//            System.out.println("Отложить не получится, оставшиеся сумма: " + balance);
//        }
//
//    }





