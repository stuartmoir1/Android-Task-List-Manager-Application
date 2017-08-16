package com.example.tasklist;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by stuartmoir on 15/08/2017.
 */

public class ColoursTest {

    Colours colours;

    @Before
    public void before(){
        colours = new Colours();
    }

    @Test
    public void testColour1(){
        assertEquals("red", colours.getColour(0));
    }

    @Test
    public void testColour2(){
        assertEquals("blue", colours.getColour(1));
    }

    @Test
    public void testColour3(){
        assertEquals("green", colours.getColour(2));
    }

    @Test
    public void testColour4(){
        assertEquals("gray", colours.getColour(3));
    }

    @Test
    public void testColour5(){
        assertEquals("magenta", colours.getColour(4));
    }

    @Test
    public void testColour6(){
        assertEquals("yellow", colours.getColour(5));
    }

    @Test
    public void testColour7(){
        assertEquals("aqua", colours.getColour(6));
    }

    @Test
    public void testColour8(){
        assertEquals("fuchsia", colours.getColour(7));
    }
}