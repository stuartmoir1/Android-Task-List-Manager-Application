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
    public void testNumberOfCategories(){
        assertEquals(2, categoryList.getNumberOfCategories());
    }

    @Test
    public void testPresetCategory1Name() {
        assertEquals("#FF0000", categoryList.getCategoryColour("Work"));
    }

    @Test
    public void testPresetCategory2Name() {
        assertEquals("#0000FF", categoryList.getCategoryColour("Home"));
    }

    @Test
    public void testAddCategory(){
        categoryList.addCategory("Shopping", "#FF00FF");
        assertEquals("#FF00FF", categoryList.getCategoryColour("Shopping"));
    }

    @Test
    public void testRemoveCategory(){
        categoryList.removeCategory("Work");
        assertNull(categoryList.getCategoryColour("Work"));
    }
}
