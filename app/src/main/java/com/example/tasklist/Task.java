package com.example.tasklist;

/**
 * Created by stuartmoir on 11/08/2017.
 */

public class Task {

    // Properties
    private int id;
    private String category;
    private int priority;
    private String description;
    private String dueDate;
    private boolean status;
    private String notes;

    // Constructor
    public Task(int id, String category, int priority, String description, String
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

    public int getId(){
        return this.id;
    }

    public void setId(int id){
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

    public int getPriority(){
        return this.priority;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    //

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    // Due date.

    public String getDueDate(){
        return this.dueDate;
    }

    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }

    // Status

    public boolean getStatus(){
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
}
