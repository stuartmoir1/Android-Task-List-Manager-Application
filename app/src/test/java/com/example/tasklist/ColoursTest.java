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
        assertEquals("#0000FF", colours.getColour(0));
    }

    @Test
    public void testColour2(){
        assertEquals("#00FFFF", colours.getColour(1));
    }

    @Test
    public void testColour3(){
        assertEquals("#FFA500", colours.getColour(2));
    }

    @Test
    public void testColour4(){
        assertEquals("#008000", colours.getColour(3));
    }

    @Test
    public void testColour5(){
        assertEquals("#808080", colours.getColour(4));
    }

    @Test
    public void testColour6(){
        assertEquals("#FF00FF", colours.getColour(5));
    }

    @Test
    public void testColour7(){
        assertEquals("#FF0000", colours.getColour(6));
    }

    @Test
    public void testColour8(){
        assertEquals("#FFFF00", colours.getColour(7));
    }
}