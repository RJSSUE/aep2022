package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareTest {
    @Test
    public void squareWithLengthThreeShouldHaveAreaNine(){
        var square = Rectangle.createSquare(3);//new Square(3);
        assertEquals(9,square.getArea());
    }

    @Test
    public void squareWithLengthThreeShouldHavePerimeterTwelve(){
        var square = Rectangle.createSquare(3);
        assertEquals(12,square.getPerimeter());
    }
}
