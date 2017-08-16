package com.example.tasklist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

        this.buttonSave = (Button) findViewById(R.id.button_save);
        this.buttonDelete = (Button) findViewById(R.id.button_delete);
        this.buttonCancel = (Button) findViewById(R.id.button_cancel);

        // Get String data from SP.
        // TO DO. Change "TASKDETAILS" to R.string.preference_file_key1.
        this.sharedPref =
            getSharedPreferences(getString(R.string.preference_file_key),
                Context.MODE_PRIVATE);
        String tasksSP = sharedPref.getString("TaskList",
            new ArrayList<Task>().toString());
        Log.d("tasksSP: ", tasksSP);

        // Convert SP String data.
        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> tasksGS = new TypeToken<ArrayList<Task>>(){};
        Log.d("tasksGS: ", tasksGS.toString());
        this.taskList = gson.fromJson(tasksSP, tasksGS.getType());
        Log.d("taskList: ", this.taskList.toString());

        this.descriptionForm = (EditText) findViewById(R.id.description);
        this.categoryForm = (EditText) findViewById(R.id.category);
        this.priorityForm = (EditText) findViewById(R.id.priority);
        this.statusForm = (EditText) findViewById(R.id.status);
        this.dueDateForm = (EditText) findViewById(R.id.due_date);
        this.notesForm = (EditText) findViewById(R.id.notes);

        // Get data from calling activity.
        this.task = (Task) getIntent().getSerializableExtra("task");

        if (this.task != null) {
            this.descriptionForm.setText(task.getDescription());
            this.priorityForm.setText(task.getPriority().toString());
            this.categoryForm.setText(task.getCategory());
            this.statusForm.setText(String.valueOf(task.getStatus()));
            this.dueDateForm.setText(task.getDueDateAsString());
            this.notesForm.setText(task.getNotes());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.task_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.add_category) {
            Intent intent = new Intent(this, CategoryAddActivity.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.remove_category) {
            Intent intent = new Intent(this, CategoryRemoveActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onButtonClicked(View button) {

        // REFACTOR
        if (button == this.buttonSave) {
            saveTask();
        } else if (button == this.buttonDelete) {
            deleteTask();
        } else if (button == this.buttonCancel) {
            // Do nothing.
        } else {
            // Exception
        }

        // Return to task list view.
        Intent intent = new Intent(this, TaskListActivity.class);
        startActivity(intent);
    }

    public void saveTask(){

        this.descriptionForm = (EditText) findViewById(R.id.description);
        this.categoryForm = (EditText) findViewById(R.id.category);
        this.priorityForm = (EditText) findViewById(R.id.priority);
        this.statusForm = (EditText) findViewById(R.id.status);
        this.dueDateForm = (EditText) findViewById(R.id.due_date);
        this.notesForm = (EditText) findViewById(R.id.notes);

        String description = descriptionForm.getText().toString();
        String category = categoryForm.getText().toString();
        String priorityStr = priorityForm.getText().toString();
        Integer priority = Integer.valueOf(priorityStr);
        String statusStr = statusForm.getText().toString();
        Boolean status = Boolean.valueOf(statusStr);
        // Date
        String dueDate = dueDateForm.getText().toString();
        String notes = notesForm.getText().toString();

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        try {
            date = formatter.parse(dueDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Log.d("taskList pre-save: ", taskList.toString());

        Integer id;;
        if (this.task != null) {
            // Remove existing task from SP.
            id = this.task.getId();
            for ( Task t : this.taskList ) {
                if ( t.getId().equals(id) ) {
                    this.taskList.remove(t);
                    break;
                }
            }
            Log.d("tasktoberemoved id: ", id.toString());
        } else {
            // Create new task.
            int lastId = 0;
            for (Task task : taskList) {
                if (task.getId() > lastId) {
                    lastId = task.getId();
                }
            }
            id = lastId + 1;
            Log.d("tasktobeadded id: ", id.toString());
        }
        Task newTask = new Task(id, category, priority, description, date, status, notes);
        this.taskList.add(newTask);

        Log.d("taskList pre-save: ", taskList.toString());

        // Save task list to SP.
        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("TaskList", gson.toJson(this.taskList));
        editor.apply();
    }

    public void deleteTask(){

        if (this.task == null) {
            return;
        }

        Integer id = this.task.getId();

        Log.d("taskList pre-del: ", this.taskList.toString());
        for (Task t : this.taskList) {
            if (t.getId().equals(id)) {
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
    }
}
