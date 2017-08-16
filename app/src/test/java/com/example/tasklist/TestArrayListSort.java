package com.example.tasklist;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created by stuartmoir on 14/08/2017.
 */

public class TestArrayListSort {

    ArrayList<Task> taskList;
    Task task1, task2, task3, task4, task5;
    String dueDateStr1, dueDateStr2, dueDateStr3, dueDateStr4, dueDateStr5;
    Date dueDate1, dueDate2, dueDate3, dueDate4, dueDate5;

    @Before
    public void before(){

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        dueDateStr1 = "01/19/2009";
        dueDateStr2 = "02/20/2010";
        dueDateStr3 = "03/21/2011";
        dueDateStr4 = "04/22/2012";
        dueDate1 = new Date();
        dueDate2 = new Date();
        dueDate3 = new Date();
        dueDate4 = new Date();
        try {
            dueDate1 = formatter.parse(dueDateStr1);
            dueDate2 = formatter.parse(dueDateStr2);
            dueDate3 = formatter.parse(dueDateStr3);
            dueDate4 = formatter.parse(dueDateStr4);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        task1 = new Task(5, "work", 1, "Task 1", dueDate4, false, "Notes 1");
        task2 = new Task(3, "work", 2, "Task 2", dueDate3, true, "Notes 2");
        task3 = new Task(2, "home", 1, "Task 3", dueDate2, true, "Notes 3");
        task4 = new Task(4, "work", 3, "Task 4", dueDate1, false, "Notes 4");
        task5 = new Task(1, "home", 2, "Task 5", dueDate4, false, "Notes 5");

        taskList = new ArrayList<Task>();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        taskList.add(task4);
        taskList.add(task5);
    }

    @Test
    public void testSortByPriority(){
        // Expected
        Task[] tasks = new Task[]{task1, task3, task2, task5, task4};
        // Sort
        ArrayListSort sort = new ArrayListSort();
        ArrayList<Task> sortedArr = sort.byPriority(taskList);
        // Test
        int i = 0;
        for (Task task : sortedArr) {
            assertEquals(tasks[i].toString(), task.toString());
            i++;
        }
    }

    @Test
    public void testSortByCategory(){
        // Expected
        Task[] tasks = new Task[]{task3, task5, task1, task2, task4};
        // Sort
        ArrayListSort sort = new ArrayListSort();
        ArrayList<Task> sortedArr = sort.byCategory(taskList);
        // Test
        int i = 0;
        for (Task task : sortedArr) {
            assertEquals(tasks[i].toString(), task.toString());
            i++;
        }
    }

    @Test
    public void testSortByDate(){
        // Expected
        Task[] tasks = new Task[]{task4, task3, task2, task1, task5};
        // Sort
        ArrayListSort sort = new ArrayListSort();
        ArrayList<Task> sortedArr = sort.byDueDate(taskList);
        // Test
        int i = 0;
        for (Task task : sortedArr) {
            assertEquals(tasks[i].toString(), task.toString());
            i++;
        }
    }

    @Test
    public void testSortById(){
        // Expected
        Task[] tasks = new Task[]{task5, task3, task2, task4, task1};
        // Sort
        ArrayListSort sort = new ArrayListSort();
        ArrayList<Task> sortedArr = sort.byId(taskList);
        // Test
        int i = 0;
        for (Task task : sortedArr) {
            assertEquals(tasks[i].toString(), task.toString());
            i++;
        }
    }

    @Test
    public void testSortByPriorityThenId(){
        // Expected
        Task[] tasks = new Task[]{task3, task1, task5, task2, task4};
        // Sort
        ArrayListSort sort = new ArrayListSort();
        ArrayList<Task> sortedArr = sort.byPriorityThenId(taskList);
        // Test
        int i = 0;
        for (Task task : sortedArr) {
            assertEquals(tasks[i].toString(), task.toString());
            i++;
        }
    }

    @Test
    public void testSortByCategoryThenId(){
        // Expected
        Task[] tasks = new Task[]{task5, task3, task2, task4, task1};
        // Sort
        ArrayListSort sort = new ArrayListSort();
        ArrayList<Task> sortedArr = sort.byCategoryThenId(taskList);
        // Test
        int i = 0;
        for (Task task : sortedArr) {
            assertEquals(tasks[i].toString(), task.toString());
            i++;
        }
    }

    @Test
    public void testSortByDueDateThenId(){
        // Expected
        Task[] tasks = new Task[]{task4, task3, task2, task5, task1};
        // Sort
        ArrayListSort sort = new ArrayListSort();
        ArrayList<Task> sortedArr = sort.byDueDateThenId(taskList);
        // Test
        int i = 0;
        for (Task task : sortedArr) {
            assertEquals(tasks[i].toString(), task.toString());
            i++;
        }
    }

    @Test
    public void testShowOpenTasksOnly(){
        // Expected
        Task[] tasks = new Task[]{task3, task2};
        // Filter
        ArrayListSort sort = new ArrayListSort();
        ArrayList<Task> openTasks = sort.showStatusOpenOnly(taskList);
        // Test
        int i = 0;
        for (Task task : openTasks) {
            assertEquals(tasks[i].toString(), task.toString());
            i++;
        }
    }

    @Test
    public void testShowClosedTasksOnly(){
        // Expected
        Task[] tasks = new Task[]{task5, task4, task1};
        // Filter
        ArrayListSort sort = new ArrayListSort();
        ArrayList<Task> openTasks = sort.showStatusClosedOnly(taskList);
        // Test
        int i = 0;
        for (Task task : openTasks) {
            assertEquals(tasks[i].toString(), task.toString());
            i++;
        }
    }
}
