package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void additionTest() {
        var calculator = new Calculator("1+2");
        assertEquals(3, calculator.calculate());
    }
}
