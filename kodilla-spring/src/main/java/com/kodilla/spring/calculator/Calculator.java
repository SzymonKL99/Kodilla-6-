package com.kodilla.spring.calculator;

import org.springframework.stereotype.Service;

@Service
public class Calculator {


    private final Display display;

    public Calculator(Display display) {
        this.display = display;
    }

    public void add(double a, double b) {
        double result = a + b;
        display.displayValue(result);

    }
    public void sub(double a, double b) {
        double result = a - b;
        display.displayValue(result);
    }
    public void mul(double a, double b) {
        double result = a * b;
        display.displayValue(result);

    }
    public void div(double a, double b) {
        if (b != 0) {
            double result = a / b;
            display.displayValue(result);
        } else {
            System.out.println("Don't divide by 0");
        }
    }
}
