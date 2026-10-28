package org.example;

//должно быть из сервиса

import org.example.generalCalculationsServices.CalculationManager;
import org.example.user.UserDaoImpl;
import org.example.user.Users;

public class Main {
    public static void main(String[] args) {

        UserDaoImpl userDao = new UserDaoImpl();
        CalculationManager generalCalculations = new CalculationManager();
        userDao.save(new Users(0,"Viktor", 200000));
        generalCalculations.addExpense("Еда", 30000);
        generalCalculations.addExpense("Аренда", 70000);
        generalCalculations.addExpense("Квартплата", 9000);
        generalCalculations.addExpense("Валдберис", 8000);
        generalCalculations.addExpense("Еда сегодня", 3000);
        generalCalculations.addExpense("Поход", 10000);
        generalCalculations.addExpense("Танцы", 2000);
        generalCalculations.addExpense("Больница", 15000);

        generalCalculations.addSaving("Ремонт", 60);
        generalCalculations.addSaving("Инвестиции Витя", 15);
        generalCalculations.addSaving("Инвестиции Алена", 15);
        generalCalculations.addSaving("Ипотека Досрочно", 10);
//        generalCalculations.deleteExpense("Кредиты");
//        generalCalculations.correctionExpense("Комуналка", "комуналка", 1000);
//        generalCalculations.correctionUser("Viktor", "Alena", 150000);


        generalCalculations.additionOfExpenses();
        generalCalculations.subtractionOfExpenses();
        generalCalculations.calculationSaving();

    }
}
















