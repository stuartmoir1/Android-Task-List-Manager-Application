package com.example.tasklist;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by stuartmoir on 11/08/2017.
 */

public class TaskTest {

    // Properties
    Task task;

    @Before
    public void before(){
        task = new Task(1, "work", 1, "Task 1", "Date 1", false, "Notes 1");
    }

    // Tests

    // Id

    @Test
    public void testGetId(){
        assertEquals(1, task.getId());
    }

    @Test
    public void testSetId(){
        task.setId(2);
        assertEquals(2, task.getId());
    }

    // Category

    @Test
    public void testGetCategory(){
        assertEquals("work", task.getCategory());
    }

    @Test
    public void testSetCategory(){
        task.setCategory("home");
        assertEquals("home", task.getCategory());
    }

    // Priority

    @Test
    public void testGetCPriority(){
        assertEquals(1, task.getPriority());
    }

    @Test
    public void testSetPriority(){
        task.setPriority(2);
        assertEquals(2, task.getPriority());
    }

    // Description

    @Test
    public void testGetDescription(){
        assertEquals("Task 1", task.getDescription());
    }

    @Test
    public void testSetDescription(){
        task.setDescription("Task 1 changed");
        assertEquals("Task 1 changed", task.getDescription());
    }

    // Due date.

    @Test
    public void testGetDueDate(){
        assertEquals("Date 1", task.getDueDate());
    }

    @Test
    public void testSetDueDate(){
        task.setDueDate("Date 1 changed");
        assertEquals("Date 1 changed", task.getDueDate());
    }

    // Status

    @Test
    public void testGetStatus(){
        assertEquals(false, task.getStatus());
    }

    @Test
    public void testSetStatus(){
        task.setStatus(true);
        assertEquals(true, task.getStatus());
    }

    // Notes

    @Test
    public void testGetNotes(){
        assertEquals("Notes 1", task.getNotes());
    }

    @Test
    public void testSetNotes(){
        task.setNotes("Notes 1 edited");
        assertEquals("Notes 1 edited", task.getNotes());
    }
}
