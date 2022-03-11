package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest {
    @Test
    public void twelveInchesEqualsOneFoot() {
        var length1 = new ArithmeticQuantity(Unit.INCH, 12.0);
        var length2 = new ArithmeticQuantity(Unit.FOOT, 1.0);
        assertEquals(length1, length2);
    }

    @Test
    public void threeInchesEqualsOneYard() {
        var length1 = new ArithmeticQuantity(Unit.FOOT, 3.0);
        var length2 = new ArithmeticQuantity(Unit.YARD, 1.0);
        assertEquals(length1, length2);
    }

    @Test
    public void thousand760YardsEqualsOneMile() {
        var length1 = new ArithmeticQuantity(Unit.YARD, 1760.0);
        var length2 = new ArithmeticQuantity(Unit.MILE, 1.0);
        assertEquals(length1, length2);
    }

    @Test
    public void threeTspEqualsOneTbsp() {
        var volume1 = new ArithmeticQuantity(Unit.TSP, 3.0);
        var volume2 = new ArithmeticQuantity(Unit.TBSP, 1.0);
        assertEquals(volume1, volume2);
    }

    @Test
    public void twoTbspEqualsOneOz() {
        var volume1 = new ArithmeticQuantity(Unit.TBSP, 2.0);
        var volume2 = new ArithmeticQuantity(Unit.OZ, 1.0);
        assertEquals(volume1, volume2);
    }

    @Test
    public void eightOzEqualsOneCup() {
        var volume1 = new ArithmeticQuantity(Unit.OZ, 8.0);
        var volume2 = new ArithmeticQuantity(Unit.CUP, 1.0);
        assertEquals(volume1, volume2);
    }

    @Test
    public void oneInchUnequalOneTsp() {
        var length = new ArithmeticQuantity(Unit.INCH, 1.0);
        var volume = new ArithmeticQuantity(Unit.TSP, 1.0);
        assertNotEquals(length, volume);
    }

    @Test
    public void twoInchesAddTwoInchesShouldEqualFourInches() {
        var length = new ArithmeticQuantity(Unit.INCH, 2.0);
        var length2 = new ArithmeticQuantity(Unit.INCH, 4.0);
        assertEquals(length2, length.add(length));
    }

    @Test
    public void twoTbspAddOneOzShouldEqualTwelveTsp() {
        var volume1 = new ArithmeticQuantity(Unit.TBSP, 2.0);
        var volume2 = new ArithmeticQuantity(Unit.OZ, 1.0);
        var volume3 = new ArithmeticQuantity(Unit.TSP, 12.0);
        assertEquals(volume3, volume1.add(volume2));
    }

    @Test(expected = RuntimeException.class)
    public void exceptionAddTest() {
        var length = new ArithmeticQuantity(Unit.INCH, 1.0);
        var volume = new ArithmeticQuantity(Unit.TSP, 1.0);
        length.add(volume);
    }

    @Test
    public void zeroCelsiusShouldEqualThirtyTwoFahrenheit() {
        var celsius = new ScaledQuantity(Unit.CELSIUS, 0.0);
        var fahrenheit = new ScaledQuantity(Unit.FAH, 32.0);
        assertEquals(celsius, fahrenheit);
    }

    @Test
    public void oneHundredCelsiusShouldEqualTwoHundredTwelveFahrenheit() {
        var celsius = new ScaledQuantity(Unit.CELSIUS, 100.0);
        var fahrenheit = new ScaledQuantity(Unit.FAH, 212.0);
        assertEquals(celsius, fahrenheit);
    }

    @Test
    public void twoInchesIsGreaterThanOneInch() {
        var twoInches = new ArithmeticQuantity(Unit.INCH, 2.0);
        var oneInch = new ArithmeticQuantity(Unit.INCH, 1.0);
        assertTrue(twoInches.betterThan(oneInch));
        assertFalse(oneInch.betterThan(twoInches));
    }

    @Test
    public void oneMileIsGreaterThanOneInch() {
        var oneMile = new ArithmeticQuantity(Unit.MILE, 1.0);
        var oneInch = new ArithmeticQuantity(Unit.INCH, 1.0);
        assertTrue(oneMile.betterThan(oneInch));
    }

    @Test(expected = RuntimeException.class)
    public void exceptionCompareTest() {
        var length = new ArithmeticQuantity(Unit.INCH, 1.0);
        var volume = new ArithmeticQuantity(Unit.TSP, 1.0);
        length.betterThan(volume);
    }
}
