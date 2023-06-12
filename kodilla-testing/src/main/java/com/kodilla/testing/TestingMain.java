package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int result = calculator.add(20,7);
        int resul2 = calculator.subtract(20,7);

        if (result == 27) {
            System.out.println("Correct");
        }else {
            System.out.println("Incorrect");
        }
        if (resul2 == 13) {
            System.out.println("Correct");
        }else {
            System.out.println("Incorrect");
        }
    }
}
