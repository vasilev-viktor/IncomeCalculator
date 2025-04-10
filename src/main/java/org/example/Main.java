package org.example;

import org.example.Calculator.GeneralCalculations;

public class Main {
    public static void main(String[] args) {
        GeneralCalculations calculator = new GeneralCalculations(100000, 50000);
        calculator.subtractionBasic();
        calculator.repairInterest();
    }
}