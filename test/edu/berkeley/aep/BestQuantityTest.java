package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestQuantityTest {
    @Test
    public void bestQuantityOfInch123ShouldBe3Inches() {
        var length1 = new ArithmeticQuantity(Unit.INCH, 1.0);
        var length2 = new ArithmeticQuantity(Unit.INCH, 2.0);
        var length3 = new ArithmeticQuantity(Unit.INCH, 3.0);
        var bestQuantity = new BestQuantity(length1, length2, length3);
        assertEquals(length3, bestQuantity.findMax());
    }

    @Test
    public void bestQuantityOfVolume1TspTbspOzShouldBe1Oz() {
        var volume1 = new ArithmeticQuantity(Unit.TSP, 1.0);
        var volume2 = new ArithmeticQuantity(Unit.TBSP, 1.0);
        var volume3 = new ArithmeticQuantity(Unit.OZ, 1.0);
        var bestQuantity = new BestQuantity(volume1, volume2, volume3);
        assertEquals(volume3, bestQuantity.findMax());
    }

    @Test(expected = RuntimeException.class)
    public void bestQuantityException() {
        var length1 = new ArithmeticQuantity(Unit.INCH, 1.0);
        var length2 = new ArithmeticQuantity(Unit.INCH, 2.0);
        var volume1 = new ArithmeticQuantity(Unit.TSP, 1.0);
        var bestQuantity = new BestQuantity(length1, length2, volume1);
        bestQuantity.findMax();
    }

    @Test(expected = NullPointerException.class)
    public void nullObjectException() {
        var length1 = new ArithmeticQuantity(Unit.INCH, 1.0);
        var bestQuantity = new BestQuantity(length1, null);
        bestQuantity.findMax();
    }

    @Test(expected = NullPointerException.class)
    public void nullValueException() {
        var length1 = new ArithmeticQuantity(Unit.INCH, 1.0);
        var length2 = new ArithmeticQuantity(Unit.INCH, null);
        var bestQuantity = new BestQuantity(length1, length2);
        bestQuantity.findMax();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void EmptyListException() {
        var bestQuantity = new BestQuantity();
        bestQuantity.findMax();
    }

    @Test
    public void bestChanceOfDiceCoinShouldBeNotDice() {
        var chanceDice = new Chance(1d/6d);
        var chanceCoin = new Chance(0.5);
        var chanceNotDice = chanceDice.not();
        var bestQuantity = new BestQuantity(chanceCoin,chanceDice,chanceNotDice);
        assertEquals(chanceNotDice, bestQuantity.findMax());
    }

    @Test(expected = NullPointerException.class)
    public void nullChanceObjectException() {
        var chanceCoin = new Chance(0.5);
        var bestQuantity = new BestQuantity(chanceCoin, null);
        bestQuantity.findMax();
    }
}
