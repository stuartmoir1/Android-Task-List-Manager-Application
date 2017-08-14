package com.example.tasklist;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by stuartmoir on 14/08/2017.
 */

public class TestArrayListSort {

    ArrayList<Task> taskList;
    Task task1, task2, task3, task4, task5;

    @Before
    public void before(){

        task1 = new Task(5, "work", 1, "Task 1", "Date b", false, "Notes 1");
        task2 = new Task(3, "work", 2, "Task 2", "Date b", true, "Notes 2");
        task3 = new Task(2, "home", 1, "Task 3", "Date a", true, "Notes 3");
        task4 = new Task(4, "work", 3, "Task 4", "Date e", false, "Notes 4");
        task5 = new Task(1, "home", 2, "Task 5", "Date c", false, "Notes 5");

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
        Task[] tasks = new Task[]{task3, task1, task2, task5, task4};
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
        Task[] tasks = new Task[]{task3, task2, task1, task5, task4};
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
