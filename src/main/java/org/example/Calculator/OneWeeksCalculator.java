package org.example.Calculator;

// Первая неделя - 5е число

public class OneWeeksCalculator extends GeneralCalculations implements Print {

    public OneWeeksCalculator(int salary) {
        super(salary);
    }

    public void calculationFirstWeek() {
        int toDealSports = sports / 2;
        int loansFirstWeek = loans / 3;
        int consumablesFirstWeek = communal + toDealSports + loansFirstWeek;

    }


    @Override
    public void repairInterest(){
        super.repairInterest();
    }


    @Override
    public void printLn() {

    }




}
