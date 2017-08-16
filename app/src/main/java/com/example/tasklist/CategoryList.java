package com.example.tasklist;

import java.util.HashMap;

/**
 * Created by stuartmoir on 15/08/2017.
 */

public class CategoryList {

    // Properties
    private HashMap<String, String> categories;

    // Constructor
    public CategoryList(){
        this.categories = new HashMap<String, String>();
        this.categories.put("work", "red");
        this.categories.put("home", "blue");
    }

    // Methods

    public int getNumberOfCategories(){
        return categories.size();
    }

    public String getCategoryColour(String name){
        return categories.get(name);
    }

    public void addCategory(String name, String colour){
        categories.put(name.toLowerCase(), colour);
    }

    public void removeCategory(String name){
        categories.remove(name);
    }
}
