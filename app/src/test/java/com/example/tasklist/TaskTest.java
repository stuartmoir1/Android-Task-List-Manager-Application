package com.example.tasklist;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by stuartmoir on 11/08/2017.
 */

public class TaskTest {

    // Properties
    Task task;
    Date dueDate1, dueDate2;
    String dueDateStr1, dueDateStr2;

    @Before
    public void before(){

        // Setup dates.
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        dueDateStr1 = "09/22/2009";
        dueDateStr2 = "10/23/2010";
        dueDate1 = new Date();
        dueDate2 = new Date();
        try {
            dueDate1 = formatter.parse(dueDateStr1);
            dueDate2 = formatter.parse(dueDateStr2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        task = new Task(1, "work", 1, "Task 1", dueDate1, false, "Notes 1");
    }

    // Tests

    // Id

    @Test
    public void testGetId(){
        Integer id = 1;
        assertEquals(id, task.getId());
    }

    @Test
    public void testSetId(){
        Integer id = 2;
        task.setId(id);
        assertEquals(id, task.getId());
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
    public void testGetPriority(){
        Integer priority = 1;
        assertEquals(priority, task.getPriority());
    }

    @Test
    public void testSetPriority(){
        Integer priority = 2;
        task.setPriority(priority);
        assertEquals(priority, task.getPriority());
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

    //@Test
    //public void testGetDueDate(){
    //    assertEquals("Date 1", task.getDueDate());
    //}

    //@Test
    //public void testSetDueDate(){
    //    task.setDueDate("Date 1 changed");
    //    assertEquals("Date 1 changed", task.getDueDate());
    //}

    @Test
    public void testGetDueDate(){
        assertEquals(dueDate1, task.getDueDate());
    }

    @Test
    public void testSetDueDate(){
        task.setDueDate(dueDate2);
        assertEquals(dueDate2, task.getDueDate());
    }

    @Test
    public void testSetDueDateFromString(){
        task.setDueDateFromString(dueDateStr1);
        assertEquals(dueDate1, task.getDueDate());
    }

    @Test
    public void testGetDueDateAsString(){
        assertEquals(dueDateStr1, task.getDueDateAsString());
    }

    // Status

    @Test
    public void testGetStatus(){
        assertFalse(task.getStatus());
    }

    @Test
    public void testSetStatus(){
        task.setStatus(true);
        assertTrue(task.getStatus());
    }

    // Status task

    @Test
    public void testGetStatusTaskOpen(){
        task.setStatus(true);
        assertEquals("open", task.getStatusTask());
    }

    @Test
    public void testSetStatusTaskClosed(){
        task.setStatus(false);
        assertEquals("closed", task.getStatusTask());
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
