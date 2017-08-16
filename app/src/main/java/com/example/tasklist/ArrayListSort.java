package com.example.tasklist;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by stuartmoir on 14/08/2017.
 */

public class ArrayListSort {

    // Properties


    // Constructor


    // Methods

    public ArrayList<Task> byPriority(ArrayList<Task> taskList){
        Collections.sort(taskList, Task.TaskPriorityComparator);
        return taskList;
    }

    public ArrayList<Task> byCategory(ArrayList<Task> taskList){
        Collections.sort(taskList, Task.TaskCategoryComparator);
        return taskList;
    }

    public ArrayList<Task> byDueDate(ArrayList<Task> taskList){
        Collections.sort(taskList, Task.TaskDueDateComparator);
        return taskList;
    }

    public ArrayList<Task> byId(ArrayList<Task> taskList){
        Collections.sort(taskList, Task.TaskIdComparator);
        return taskList;
    }

    public ArrayList<Task> byPriorityThenId(ArrayList<Task> taskList){
        Collections.sort(taskList, Task.TaskPriorityThenIdComparator);
        return taskList;
    }

    public ArrayList<Task> byCategoryThenId(ArrayList<Task> taskList){
        Collections.sort(taskList, Task.TaskCategoryThenIdComparator);
        return taskList;
    }

    public ArrayList<Task> byDueDateThenId(ArrayList<Task> taskList){
        Collections.sort(taskList, Task.TaskDueDateThenIdComparator);
        return taskList;
    }

    public ArrayList<Task> showStatusOpenOnly(ArrayList<Task> taskList){
        Collections.sort(taskList, Task.TaskStatusThenIdComparator);
        ArrayList<Task> openTasks = new ArrayList<Task>();
        for (Task task: taskList) {
            if (task.getStatus()) {
                openTasks.add(task);
            }
        }
        return openTasks;
    }

    public ArrayList<Task> showStatusClosedOnly(ArrayList<Task> taskList){
        Collections.sort(taskList, Task.TaskStatusThenIdComparator);
        ArrayList<Task> closedTasks = new ArrayList<Task>();
        for (Task task: taskList) {
            if (!task.getStatus()) {
                closedTasks.add(task);
            }
        }
        return closedTasks;
    }

    public ArrayList<Task> showNoCategory(ArrayList<Task> taskList){
        Collections.sort(taskList, Task.TaskCategoryThenIdComparator);
        ArrayList<Task> noCategoryTasks = new ArrayList<Task>();
        for (Task task: taskList) {
            if (task.getCategory() == "") {
                noCategoryTasks.add(task);
            }
        }
        return noCategoryTasks;
    }
}
