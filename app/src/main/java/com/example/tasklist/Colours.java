package com.example.tasklist;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by stuartmoir on 15/08/2017.
 */

public class Colours {

    // Properties
    private ArrayList<String> colours;

    // Constructor
    public Colours(){
        colours = new ArrayList<String>(Arrays.asList("red", "blue", "green", "gray",
                "magenta", "yellow", "aqua", "fuchsia"));
    }

    // Methods

    public String getColour(int index){
        return colours.get(index);
    }
}
