package com.example.tasklist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TaskActivity3 extends AppCompatActivity {

    // Properties
    private Button buttonSave;
    private Button buttonDelete;
    private Button buttonCancel;

    private ArrayList<Task> taskList;
    private Task task;

    private EditText descriptionForm;
    private EditText categoryForm;
    private EditText priorityForm;
    private EditText statusForm;
    private EditText dueDateForm;
    private EditText notesForm;

    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_task3);

        // Create button objects.
        this.buttonSave = (Button) findViewById(R.id.button_save);
        this.buttonDelete = (Button) findViewById(R.id.button_delete);
        this.buttonCancel = (Button) findViewById(R.id.button_cancel);

        // Get 'string of objects' from SP.
        this.sharedPref =
            getSharedPreferences(getString(R.string.preference_file_key),
                Context.MODE_PRIVATE);
        String tasksSP = sharedPref.getString("TaskList",
            new ArrayList<Task>().toString());
        Log.d("tasksSP: ", tasksSP);

        // Convert 'string of objects' to array of objects.
        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> tasksGS = new TypeToken<ArrayList<Task>>(){};
        Log.d("tasksGS: ", tasksGS.toString());
        this.taskList = gson.fromJson(tasksSP, tasksGS.getType());
        Log.d("taskList: ", this.taskList.toString());

        // Get form fields.
        this.descriptionForm = (EditText) findViewById(R.id.description);
        this.categoryForm = (EditText) findViewById(R.id.category);
        this.priorityForm = (EditText) findViewById(R.id.priority);
        this.statusForm = (EditText) findViewById(R.id.status);
        this.dueDateForm = (EditText) findViewById(R.id.due_date);
        this.notesForm = (EditText) findViewById(R.id.notes);

        // Get data from calling activity.
        Intent intent = getIntent();
        this.task = (Task) getIntent().getSerializableExtra("task");
        Log.d("task: ", this.task.toString());

        // Set form fields.
        this.descriptionForm.setText(task.getDescription());
        this.priorityForm.setText(task.getPriority().toString());
        this.categoryForm.setText(task.getCategory());
        this.statusForm.setText(String.valueOf(task.getStatus()));
        this.dueDateForm.setText(task.getDueDate());
        this.notesForm.setText(task.getNotes());
    }

    public void onButtonClicked(View button) {

        if ( button == this.buttonSave ) {
            // Save
            saveTask();
        } else if ( button == this.buttonDelete ) {
            // Delete
            deleteTask();
        } else if ( button == this.buttonCancel ) {
            // Do nothing.
        } else {
            // Exception
        }

        // Return to task list view.
        Intent intent = new Intent(this, TaskListActivity.class);
        intent.putExtra("tasklist", this.taskList);
        startActivity(intent);
        Log.d("Post button press", taskList.toString());
    }

    public void saveTask(){

        Log.d("method: ", "saveTask");

        // Get form fields.
        this.descriptionForm = (EditText) findViewById(R.id.description);
        this.categoryForm = (EditText) findViewById(R.id.category);
        this.priorityForm = (EditText) findViewById(R.id.priority);
        this.statusForm = (EditText) findViewById(R.id.status);
        this.dueDateForm = (EditText) findViewById(R.id.due_date);
        this.notesForm = (EditText) findViewById(R.id.notes);

        // Create object properties.
        String description = descriptionForm.getText().toString();
        String category = categoryForm.getText().toString();
        String priorityStr = priorityForm.getText().toString();
        Integer priority = Integer.valueOf(priorityStr);
        String statusStr = statusForm.getText().toString();
        Boolean status = Boolean.valueOf(statusStr);
        String dueDate = dueDateForm.getText().toString();
        String notes = notesForm.getText().toString();

        // Replace object in array.
        Integer id = this.task.getId();
        Task newTask = new Task(id, category, priority, description, dueDate,
                status, notes);

        Log.d("taskList pre-remove: ", this.taskList.toString());
        for ( Task t : this.taskList ) {
            if ( t.getId().equals(id) ) {
                this.taskList.remove(t);
                break;
            }
        }
        Log.d("taskList post-remove: ", this.taskList.toString());

        this.taskList.add(newTask);
        Log.d("taskList: post-add", this.taskList.toString());

        // Save task list to SP.
        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("TaskList", gson.toJson(this.taskList));
        editor.apply();
        Toast.makeText(this, "Task Saved", Toast.LENGTH_LONG).show();
    }

    public void deleteTask(){

        Log.d("method: ", "deleteTask");

        //this.taskList.clear();

        Integer id = this.task.getId();

        Log.d("taskList pre-del: ", this.taskList.toString());
        for ( Task t : this.taskList ) {
            if ( t.getId().equals(id) ) {
                this.taskList.remove(t);
                break;
            }
        }
        Log.d("taskList: post-del: ", this.taskList.toString());

        // Save task list to SP.
        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("TaskList", gson.toJson(this.taskList));
        editor.apply();
        Toast.makeText(this, "Task Deleted", Toast.LENGTH_LONG).show();
    }
}
