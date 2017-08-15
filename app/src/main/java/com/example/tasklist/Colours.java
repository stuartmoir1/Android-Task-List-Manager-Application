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
        colours = new ArrayList<String>(Arrays.asList("black", "grey", "silver", "white",
            "maroon", "red", "olive", "yellow", "green", "lime", "teal", "aqua", "navy","blue",
            "purple", "fuchsia"));
    }

    // Methods

    public String getColour(int index){
        return colours.get(index);
    }
}
