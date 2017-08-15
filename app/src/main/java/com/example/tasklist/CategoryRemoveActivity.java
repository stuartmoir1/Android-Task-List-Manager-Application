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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class CategoryRemoveActivity extends AppCompatActivity {

    // Properties
    private Button buttonRemove;
    private Button buttonCancel;

    private ArrayList<Task> taskList;
    private Task task;

    private EditText categoryForm;

    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_remove);

        this.buttonRemove = (Button) findViewById(R.id.button_remove);
        this.buttonCancel = (Button) findViewById(R.id.button_cancel);

        // Get String data from SP.
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

        this.categoryForm = (EditText) findViewById(R.id.category);

        // Get data from calling activity.
        this.task = (Task) getIntent().getSerializableExtra("task");

        this.categoryForm.setText(task.getCategory());
    }

    public void onButtonClicked(View button) {

        // REFACTOR
        if (button == this.buttonRemove) {
            RemoveCategory();
        } else if (button == this.buttonCancel) {
            // Do nothing.
        } else {
            // Exception
        }

        // Return to task list view.
        Intent intent = new Intent(this, TaskActivity3.class);
        startActivity(intent);
    }

    public void RemoveCategory(){
        
    }
}
