package org.example;

import org.example.Calculator.GeneralCalculations;
import org.example.Calculator.OneWeeksCalculator;

public class Main {
    public static void main(String[] args) {
//        GeneralCalculations calculator = new GeneralCalculations(100000);
//        calculator.subtractionBasic();
//        calculator.repairInterest();

        OneWeeksCalculator oneWeeksCalculator = new OneWeeksCalculator(36000, 1);
        oneWeeksCalculator.calculationFirstWeek();
        oneWeeksCalculator.repairInterest();

    }
//    public static int getNumber(boolean useLargeNumber) {
//        return useLargeNumber ? 1000 : 10;
//    }
//
//    public static void main(String[] args) {
//        int num = getNumber(false);
//        System.out.println(num);  // 100
//    }



}