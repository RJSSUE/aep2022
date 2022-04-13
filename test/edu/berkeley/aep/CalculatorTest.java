package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void oneAddTwoShouldBeThree() {
        var calculator = new Calculator("1+2");
        assertEquals(3, calculator.calculate(),1e-5);
    }

    @Test
    public void twoMultiplyThreeShouldBeSix() {
        var calculator = new Calculator("2*3");
        assertEquals(6, calculator.calculate(),1e-5);
    }

    @Test
    public void eightDivideTwoShouldBeFour() {
        var calculator = new Calculator("8/2");
        assertEquals(4, calculator.calculate(),1e-5);
    }

    @Test
    public void sevenMinusTwoShouldBeFive() {
        var calculator = new Calculator("7-2");
        assertEquals(5, calculator.calculate(),1e-5);
    }

    @Test
    public void fiveDivideTwoShouldBeTwoPointFive() {
        var calculator = new Calculator("5/2");
        assertEquals(2.5, calculator.calculate(),1e-5);
    }

    @Test
    public void twoAddTwoPointFiveShouldBeFourPointFive() {
        var calculator = new Calculator("2+2.5");
        assertEquals(4.5, calculator.calculate(),1e-5);
    }

    @Test
    public void twoAddTwoPointFiveMinusThreeShouldBeOnePointFive() {
        var calculator = new Calculator("2+2.5-3");
        assertEquals(1.5, calculator.calculate(),1e-5);
    }

    @Test(expected = RuntimeException.class)
    public void emptyStringIsNotValidExpression() {
        var calculator = new Calculator("");
        calculator.calculate();
    }

    @Test
    public void twoMultiplyThreeAddFourDivideTwoShouldBeEight() {
        var calculator = new Calculator("2*3+4/2");
        assertEquals(8, calculator.calculate(),1e-5);
    }

    @Test
    public void twoMultiplyLeftParenthesisThreeAddFourRightParenthesisDivideTwoShouldBeSeven() {
        var calculator = new Calculator("2*(3+4)/2");
        assertEquals(7, calculator.calculate(),1e-5);
    }
}
