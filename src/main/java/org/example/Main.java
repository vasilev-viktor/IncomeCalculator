package org.example;

import org.example.Calculator.GeneralCalculations;
import org.example.Calculator.OneWeeksCalculator;

public class Main {
    public static void main(String[] args) {
//        GeneralCalculations calculator = new GeneralCalculations(100000);
//        calculator.subtractionBasic();
//        calculator.repairInterest();

        OneWeeksCalculator oneWeeksCalculator = new OneWeeksCalculator(100000);
        oneWeeksCalculator.calculationFirstWeek(5000);
        oneWeeksCalculator.repairInterest();

    }



}