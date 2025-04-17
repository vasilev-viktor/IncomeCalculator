package org.example.Calculator;

// Первая неделя - 5е число

public class OneWeeksCalculator extends GeneralCalculations implements Print {

    private int balanceSecondWeek;

    public OneWeeksCalculator(int salary, int additionalExpenses) {
        super(salary, additionalExpenses);
    }

    public void calculationFirstWeek() {
        int toDealSports = sports / 2;
        int loansFirstWeek = loans / 3;
        int consumablesFirstWeek = communal + toDealSports + loansFirstWeek + additionalExpenses;
        System.out.println("Сумма поступила: " + salary);
        System.out.println("Расходники за первую неделю: " + consumablesFirstWeek);
        if (salary > consumablesFirstWeek) {
            salary -= consumablesFirstWeek;
            System.out.println("Расчеты за первую неделю (вычет расходников и доп. расходов из введенной зарплаты): " + salary);
            balanceSecondWeek = salary - consumablesFirstWeek;
        }else {
            System.out.println("\nНедостаточно средств чтобы покрыть обязательные расходы: "
                    + "Веденная зарплата - " + balance
                    + "Обязательные расходы - " + consumablesFirstWeek);
        }

    }

     @Override
     public void repairInterest() {
         super.repairInterest(balanceSecondWeek);

     }

    @Override
    public void printLn() {
    }

//    @Override
//    public  String toString() {
//        return  super.toString();
//    }




}
