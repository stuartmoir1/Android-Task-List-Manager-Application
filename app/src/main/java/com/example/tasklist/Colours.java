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
        colours = new ArrayList<String>(Arrays.asList("#0000FF", "#00FFFF", "#FFA500", "#008000",
                "#808080", "#FF00FF", "#FF0000", "#FFFF00"));
    }

    // Methods

    public String getColour(int index){
        return colours.get(index);
    }
}
