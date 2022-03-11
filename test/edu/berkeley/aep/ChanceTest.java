package edu.berkeley.aep;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ChanceTest {
    @Test
    public void chanceOfDifferentEventsShouldBeDifferent(){
        var chanceDice = new Chance(1/(double)6);//cast into double, or 1d/6d, otherwise java conducts integer division: 1/6 = 0
        var chanceCoin = new Chance(0.5);
        assertNotEquals(chanceDice,chanceCoin);
    }

    @Test
    public void chanceOfSomethingNotHappeningShouldBeOneMinusProbabilityOfHappening(){
        var chance = new Chance(0.2);
        var chanceNotHappening = new Chance(1-0.2);
        assertTrue(chanceNotHappening.equals(chance.not()));
    }

    @Test
    public void chanceOfAndShouldBeMultiplication() {
        var chanceDice = new Chance(1d/6d);
        var chanceCoin = new Chance(0.5);
        var chanceAnd = new Chance(1d/6d*0.5);
        assertEquals(chanceCoin.and(chanceDice),chanceAnd);
    }

    @Test
    public void chanceOfOrShouldBePlusMinusMultiplication() {
        var chanceDice = new Chance(1d/6d);
        var chanceCoin = new Chance(0.5);
        var chanceOr = new Chance(1d/6d+0.5-1d/6d*0.5);// 7d/12d would cause truncation problems
        assertEquals(chanceCoin.or(chanceDice),chanceOr);
    }

    @Test
    public void valueObjectShouldOverrideHashcode(){
        var coinToss = new Chance(0.5);
        var coinTosses = new HashMap<Chance,String>();
        coinTosses.put(coinToss,"heads");
        assertEquals("heads",coinTosses.get(new Chance(0.5)));
    }

    @Test(expected = NullPointerException.class)
    public void nullObjectException() {
        var chanceCoin = new Chance(0.5);
        assertTrue(chanceCoin.betterThan(null));
    }

}
