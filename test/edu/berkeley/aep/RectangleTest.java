package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
    @Test
    public void rectangleWithSideTwoShouldHaveAreaFour(){
        var rectangle = new Rectangle(2,2);
        assertEquals(4, rectangle.getArea());
    }

    @Test
    public void rectangleWithSideFourShouldHaveAreaSixteen(){
        var rectangle = new Rectangle(4,4);
        assertEquals(16, rectangle.getArea());
    }

    @Test
    public void rectangleWithSideTwoShouldHavePerimeterEight(){
        var rectangle = new Rectangle(2,2);
        assertEquals(8,rectangle.getPerimeter());
    }

    @Test
    public void rectangleWithSideFourShouldHavePerimeterSixteen(){
        var rectangle = new Rectangle(4,4);
        assertEquals(16,rectangle.getPerimeter());
    }
}
