package com.example.tasklist;

import java.util.ArrayList;

/**
 * Created by stuartmoir on 11/08/2017.
 */

public class TaskList {

    // Properties
    private ArrayList<Task> list;

    // Constructor
    public TaskList() {
        // TO BE REMOVED - Data to facilitate development.
        list = new ArrayList<Task>();
        list.add(new Task(1, "work", 1, "Task 1", "Date 1", false, "Notes 1"));
        list.add(new Task(2, "work", 2, "Task 2", "Date 2", false, "Notes 2"));
        list.add(new Task(3, "work", 3, "Task 3", "Date 3", false, "Notes 3"));
        list.add(new Task(4, "work", 2, "Task 4", "Date 4", false, "Notes 4"));
        list.add(new Task(5, "work", 1, "Task 5", "Date 5", false, "Notes 5"));
    }

    // Methods

    public ArrayList<Task> getList() {
        return new ArrayList<Task>(list);
    }
}
