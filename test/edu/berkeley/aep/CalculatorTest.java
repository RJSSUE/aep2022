package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void oneAddTwoShouldBeThree() {
        var calculator = new Calculator("1+2");
        assertEquals(3, calculator.calculate());
    }

    @Test
    public void twoMultiplyThreeShouldBeSix() {
        var calculator = new Calculator("2*3");
        assertEquals(6, calculator.calculate());
    }
}
