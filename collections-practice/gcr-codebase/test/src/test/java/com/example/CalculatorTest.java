package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void testAddition() {
        assertEquals(10, calc.add(7, 3));
    }

    @Test
    void testSubtraction() {
        assertEquals(4, calc.subtract(9, 5));
    }

    @Test
    void testMultiplication() {
        assertEquals(20, calc.multiply(4, 5));
    }

    @Test
    void testDivision() {
        assertEquals(5, calc.divide(10, 2));
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
