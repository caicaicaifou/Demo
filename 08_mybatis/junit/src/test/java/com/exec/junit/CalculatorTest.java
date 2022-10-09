package com.exec.junit;

import org.junit.Test;

public class CalculatorTest {
    private Calculator cal = new Calculator();

    @Test
    public void add() {
        int result = cal.add(1, 2);
        System.out.println(result);
    }

    @Test
    public void subtract() {
        int result = cal.subtract(1, 2);
        System.out.println(result);
    }

    @Test
    public void multiply() {
        int result = cal.multiply(1, 2);
        System.out.println(result);
    }

    @Test
    public void divide() {
        float result = cal.divide(1, 2);
        System.out.println(result);
    }
}