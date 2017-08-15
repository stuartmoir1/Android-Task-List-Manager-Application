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
        assertEquals("black", colours.getColour(0));
    }

    @Test
    public void testColour2(){
        assertEquals("grey", colours.getColour(1));
    }

    @Test
    public void testColour3(){
        assertEquals("silver", colours.getColour(2));
    }

    @Test
    public void testColour4(){
        assertEquals("white", colours.getColour(3));
    }

    @Test
    public void testColour5(){
        assertEquals("maroon", colours.getColour(4));
    }

    @Test
    public void testColour6(){
        assertEquals("red", colours.getColour(5));
    }

    @Test
    public void testColour7(){
        assertEquals("olive", colours.getColour(6));
    }

    @Test
    public void testColour8(){
        assertEquals("yellow", colours.getColour(7));
    }

    @Test
    public void testColour9(){
        assertEquals("green", colours.getColour(8));
    }

    @Test
    public void testColour10(){
        assertEquals("lime", colours.getColour(9));
    }

    @Test
    public void testColour11(){
        assertEquals("teal", colours.getColour(10));
    }

    @Test
    public void testColour12(){
        assertEquals("aqua", colours.getColour(11));
    }

    @Test
    public void testColour13(){
        assertEquals("navy", colours.getColour(12));
    }

    @Test
    public void testColour14(){
        assertEquals("blue", colours.getColour(13));
    }

    @Test
    public void testColour15(){
        assertEquals("purple", colours.getColour(14));
    }

    @Test
    public void testColour16(){
        assertEquals("fuchsia", colours.getColour(15));
    }
}