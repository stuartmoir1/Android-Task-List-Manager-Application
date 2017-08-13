package com.example.tasklist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TaskActivity2 extends AppCompatActivity {

    private Button saveButton;
    private Button deleteButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_task2);

        // Buttons
        this.saveButton = (Button)findViewById(R.id.button_save);
        this.deleteButton = (Button)findViewById(R.id.button_delete);
        this.cancelButton = (Button)findViewById(R.id.button_cancel);

        // Get value from SP.
        SharedPreferences sharedPref =
                getSharedPreferences(getString(R.string.preference_file_key),
                        Context.MODE_PRIVATE);
        String taskDetailsStr = sharedPref.getString("TaskDetails",
                new ArrayList<Task>().toString());

        // Extract ArrayList of objects from value.
        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>(){};
        ArrayList<Task> taskDetailsArr = gson.fromJson(taskDetailsStr, taskArrayList.getType());

        Log.d("ArrayList from SP: ", taskDetailsArr.toString());

        // Get IDs from form.
        EditText description = (EditText) findViewById(R.id.description);
        EditText category = (EditText) findViewById(R.id.category);
        EditText priority = (EditText) findViewById(R.id.priority);
        //EditText status = (EditText) findViewById(R.id.status);
        EditText dueDate = (EditText) findViewById(R.id.due_date);
        EditText notes = (EditText) findViewById(R.id.notes);

        //
        Intent intent = getIntent();
        Task task = (Task) getIntent().getSerializableExtra("task");

        // Set text views.
        description.setText(task.getDescription());
        priority.setText(task.getPriority().toString());
        category.setText(task.getCategory());
        //status.setText(String.valueOf(task.getStatus()));
        dueDate.setText(task.getDueDate());
        notes.setText(task.getNotes());
    }

    //public void onButtonClicked(View button) {
    //}

//    public void doSomething(){
//
//        // Get data from form.
//        EditText descriptionEditText = (EditText) findViewById(R.id.description);
//        EditText categoryEditText = (EditText) findViewById(R.id.category);
//        EditText priorityEditText = (EditText) findViewById(R.id.priority);
//        //EditText statusEditText = (EditText) findViewById(R.id.status);
//        EditText dueDateEditText = (EditText) findViewById(R.id.due_date);
//        EditText notesEditText = (EditText) findViewById(R.id.notes);
//
//        //
//        String description = descriptionEditText.getText().toString();
//        String category = categoryEditText.getText().toString();
//        String priorityStr = priorityEditText.getText().toString();
//        Integer priority = Integer.valueOf(priorityStr);
//        //String statusStr = statusEditText().getText().toString();
//        //Boolean status = Boolean.valueOf(statusStr);
//        String dueDate = dueDateEditText.getText().toString();
//        String notes = notesEditText.getText().toString();
//
//        Task task = new Task(1, category, priority, description, dueDate, false, notes);
//
//        // Add or update task in array based on ID
//        //taskDetailsArr.add(task);
//
//        SharedPreferences.Editor editor = sharedPref.edit();
//
//        editor.putString("MyFavourites", gson.toJson(taskDetailsStr));
//        editor.apply();
//
//        Toast.makeText(this, "Detailed Saved", Toast.LENGTH_LONG).show();
//    }
}
