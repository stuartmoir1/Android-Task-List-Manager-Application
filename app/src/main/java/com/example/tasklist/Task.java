package com.example.tasklist;

import java.io.Serializable;

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
}