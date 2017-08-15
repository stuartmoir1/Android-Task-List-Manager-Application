package com.example.tasklist;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Created by stuartmoir on 15/08/2017.
 */

public class CategoryListTest {

    //
    CategoryList categoryList;

    @Before
    public void before() {
        categoryList = new CategoryList();
    }

    @Test
    public void testPresetCategory1Name() {
        assertEquals("red", categoryList.getCategoryColour("Work"));
    }

    @Test
    public void testPresetCategory2Name() {
        assertEquals("blue", categoryList.getCategoryColour("Home"));
    }

    @Test
    public void testAddCategory(){
        categoryList.addCategory("Shopping", "green");
        assertEquals("green", categoryList.getCategoryColour("Shopping"));
    }

    @Test
    public void testRemoveCategory(){
        categoryList.removeCategory("Work");
        assertNull(categoryList.getCategoryColour("Work"));
    }
}
