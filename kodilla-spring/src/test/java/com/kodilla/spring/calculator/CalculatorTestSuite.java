package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {
        //Given
        //When
        calculator.add(2, 3);
        calculator.sub(10, 8);
        calculator.mul(14, 14);
        calculator.div(50, 10);
        //Then
    }
}
