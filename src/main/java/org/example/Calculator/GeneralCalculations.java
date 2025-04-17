package org.example.Calculator;

public abstract class GeneralCalculations {

    // salary - зарплата/ сумму которую вводишь изначально
    // loans - кредиты
    // communal - коммуналка
    // savingsForRepairs - ремонт
    // saving - сбережения
    // entertainment - развлечения
    // food - еда
    // sports - спорт (качалка, забеги, гонки, походы)
    // additionalExpenses - дополнительные расходы (ДР, ремонт машины, бензин, проезд, одежда)

    int salary;
    int loans = 32000;
    int communal = 6000;
    int savingsForRepairs;
    int saving;
    int entertainment = 6000;
    int food = 30000;
    int sports = 4000;
    int additionalExpenses;
    int balance;



    public GeneralCalculations(int salary, int additionalExpenses) {
        this.salary = salary;
        this.additionalExpenses = additionalExpenses;
    }


    // Класс subtractionBasic отражает все расходы, можно вписать сумму и узнать сколько останется после всех расходов
    public void subtractionBasic() {
        int amountConsumables = loans + communal + food + additionalExpenses + sports + entertainment;
        System.out.println("Посчитать");
        System.out.println("Сумма поступила: " + salary);
        System.out.println("Сумма всех ежемесячных расходников (кредиты, комуналка, еда, развлечения, спорт, доп расходы): "
                + amountConsumables);
        if (amountConsumables <= salary) {
            balance = salary - amountConsumables;
            System.out.println("Остаток зарплаты за вычетом расходников: " + balance);
        }
    }

    // Метод отвечает за вычисление на ремонт и сбережения
    public void repairInterest(int balance) {
        if (balance > 0) {
            double interestRepair = 0.7;
            double savingsForRepairs = interestRepair * balance;
            double remainder = balance - savingsForRepairs;
            System.out.println("Отложить 70% от остатка на ремонт: " + savingsForRepairs);
            System.out.println("Отложить остальное на общие сбережения: " + remainder);
        }else {
            System.out.println("Отложить не получится, оставшиеся сумма: " + balance);
        }

    }


    public String toString() {
        return "\nВведенная сумма: " + salary +
                "Кредиты: " + loans +
                "Коммуналка: " + communal +
                "На ремонт: " + savingsForRepairs +
                "Сбережения: " + saving +
                "Развлечения: " + entertainment +
                "Еда: " + food +
                "На спорт: " + sports +
                "Доп расходы: " + additionalExpenses;
    }

    public abstract void repairInterest();
}
