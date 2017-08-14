package com.example.tasklist;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by stuartmoir on 11/08/2017.
 */

public class Task implements Serializable{

    // Properties
    private Integer id;
    private String category;
    private Integer priority;
    private String description;
    private String dueDate; // TO DO - Date to be changed from type String to type Date.
    private Boolean status;
    private String notes;

    // Constructor
    // TO DO - Date to be changed from type String to type Date.
    public Task(Integer id, String category, Integer priority, String description, String
            dueDate, boolean status, String notes){
        this.id = id;
        this.category = category;
        this.priority = priority;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.notes = notes;
    }

    // Methods

    // Id

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    // Category

    public String getCategory(){
        return this.category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    // Priority

    public Integer getPriority(){
        return this.priority;
    }

    public void setPriority(Integer priority){
        this.priority = priority;
    }

    // Description

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    // TO DO - Date to be changed from type String to type Date.
    // Due date.

    public String getDueDate(){
        return this.dueDate;
    }

    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }

    // Status

    public Boolean getStatus(){
        return this.status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    // Notes

    public String getNotes(){
        return this.notes;
    }

    public void setNotes(String notes){
        this.notes = notes;
    }

    // Comparator for sorting ArrayList by priority.
    public static Comparator<Task> TaskPriorityComparator = new Comparator<Task>() {
        public int compare (Task task1, Task task2) {
            Integer taskPriority1 = task1.getPriority();
            Integer taskPriority2 = task2.getPriority();
            // Ascending order.
            return taskPriority1.compareTo(taskPriority2);
        }
    };

    // Comparator for sorting ArrayList by category.
    public static Comparator<Task> TaskCategoryComparator = new Comparator<Task>() {
        public int compare (Task task1, Task task2) {
            String taskCategory1 = task1.getCategory().toLowerCase();
            String taskCategory2 = task2.getCategory().toLowerCase();
            // Ascending order.
            return taskCategory1.compareTo(taskCategory2);
        }
    };

    // Comparator for sorting ArrayList by due date.
    public static Comparator<Task> TaskDueDateComparator = new Comparator<Task>() {
        public int compare (Task task1, Task task2) {
            String taskDueDate1 = task1.getDueDate().toLowerCase();
            String taskDueDate2 = task2.getDueDate().toLowerCase();
            // Ascending order.
            return taskDueDate1.compareTo(taskDueDate2);
        }
    };

    // Comparator for sorting ArrayList by id.
    public static Comparator<Task> TaskIdComparator = new Comparator<Task>() {
        public int compare (Task task1, Task task2) {
            Integer taskId1 = task1.getId();
            Integer taskId2 = task2.getId();
            // Ascending order.
            return taskId1.compareTo(taskId2);
        }
    };

    // Comparator for sorting ArrayList by priority then id.
    public static Comparator<Task> TaskPriorityThenIdComparator = new Comparator<Task>() {
        public int compare (Task task1, Task task2) {
            Integer taskPriority1 = task1.getPriority();
            Integer taskPriority2 = task2.getPriority();
            // Ascending order.
            int compareResult = taskPriority1.compareTo(taskPriority2);
            if (compareResult != 0) {
                return compareResult;
            } else {
                Integer taskId1 = task1.getId();
                Integer taskId2 = task2.getId();
                return taskId1.compareTo(taskId2);
            }
        }
    };

    // Comparator for sorting ArrayList by category then id.
    public static Comparator<Task> TaskCategoryThenIdComparator = new Comparator<Task>() {
        public int compare (Task task1, Task task2) {
            String taskCategory1 = task1.getCategory();
            String taskCategory2 = task2.getCategory();
            // Ascending order.
            int compareResult = taskCategory1.compareTo(taskCategory2);
            if (compareResult != 0) {
                return compareResult;
            } else {
                Integer taskId1 = task1.getId();
                Integer taskId2 = task2.getId();
                return taskId1.compareTo(taskId2);
            }
        }
    };

    // Comparator for sorting ArrayList by due date then id.
    public static Comparator<Task> TaskDueDateThenIdComparator = new Comparator<Task>() {
        public int compare (Task task1, Task task2) {
            String taskDueDate1 = task1.getDueDate();
            String taskDueDate2 = task2.getDueDate();
            // Ascending order.
            int compareResult = taskDueDate1.compareTo(taskDueDate2);
            if (compareResult != 0) {
                return compareResult;
            } else {
                Integer taskId1 = task1.getId();
                Integer taskId2 = task2.getId();
                return taskId1.compareTo(taskId2);
            }
        }
    };

    // Comparator for sorting ArrayList by status then id.
    public static Comparator<Task> TaskStatusThenIdComparator = new Comparator<Task>() {
        public int compare (Task task1, Task task2) {
            Boolean taskStatus1 = task1.getStatus();
            Boolean taskStatus2 = task2.getStatus();
            // Ascending order.
            int compareResult = taskStatus1.compareTo(taskStatus2);
            if (compareResult != 0) {
                return compareResult;
            } else {
                Integer taskId1 = task1.getId();
                Integer taskId2 = task2.getId();
                return taskId1.compareTo(taskId2);
            }
        }
    };
}