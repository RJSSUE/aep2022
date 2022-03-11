package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringTest {
    @Test
    public void emptyStringReverseIsEmpty(){
        var string = new MyString("");
        assertEquals("",string.reversed());
    }

    @Test
    public void singleLetterStringReverseIsItself(){
        var string = new MyString("a");
        assertEquals("a",string.reversed());
    }

    @Test
    public void appleReverseIsELPPA(){
        var string = new MyString("apple");
        assertEquals("elppa",string.reversed());
    }
}
