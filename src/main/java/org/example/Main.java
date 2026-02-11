package org.example;

//должно быть из сервиса

import org.example.generalCalculationsServices.GeneralCalculations;

public class Main {
    public static void main(String[] args) {


        GeneralCalculations generalCalculations = new GeneralCalculations();
        generalCalculations.addUsers(287000, "Viktor");
        generalCalculations.addExpense("Еда", 30000);
        generalCalculations.addExpense("Аренда квартиры", 70000);
        generalCalculations.addExpense("Комуналка", 15000);
        generalCalculations.addExpense("Спорт", 10000);
        generalCalculations.addExpense("Разное (ДР, стол, подставка)", 4500);
        generalCalculations.addExpense("Интернет", 1500);
        generalCalculations.addExpense("Чемоданы", 20000);
        generalCalculations.addExpense("Кредит", 5000);
        generalCalculations.addExpense("Планшет", 40000);


        generalCalculations.addSaving("Доллары", 20);
        generalCalculations.addSaving("Инвестиции Витя", 10);
        generalCalculations.addSaving("Инвестиции Алена", 10);
        generalCalculations.addSaving("Ипотека (Досрочно)", 60);
//        generalCalculations.deleteExpense("Кредиты");
//        generalCalculations.correctionExpense("Комуналка", "комуналка", 1000);
//        generalCalculations.correctionUser("Viktor", "Alena", 150000);



        generalCalculations.additionOfExpenses();
        generalCalculations.subtractionOfExpenses();
        generalCalculations.calculationSaving();
    }
}
















