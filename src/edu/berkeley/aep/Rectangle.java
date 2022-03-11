package edu.berkeley.aep;

import java.util.HashMap;
import java.util.Map;

//understands a shape with four sides and right angles
public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public static Rectangle createSquare(int side) {
        return new Rectangle(side,side);
    }

    public int getArea(){
        return width*height;
    }

    public int getPerimeter(){
        return 2*width + 2*height;
    }

/*
    // Don't break encapsulation by implementing set() and get()
    // Tell don't ask, pass in an object
    //if we're comparing the length of triangle with a rectangle,
    // we pass in the object of triangle, compute inside this object, and return the result

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

 */
}
