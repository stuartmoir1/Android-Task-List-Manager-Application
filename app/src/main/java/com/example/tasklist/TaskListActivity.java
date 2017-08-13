package com.example.tasklist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_list);

        // TO BE REMOVED - Data to faciliate development.
        // Get ArrayList from model java.
        //TaskList taskList = new TaskList();
        //ArrayList<Task> list = taskList.getList();

        // Get 'string of objects' from SP.
        SharedPreferences sharedPref =
                getSharedPreferences(getString(R.string.preference_file_key),
             Context.MODE_PRIVATE);
        String tasksSP = sharedPref.getString("TaskList",
                new ArrayList<Task>().toString());

        // Convert 'string of objects' to array of objects.
        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> tasksGS = new TypeToken<ArrayList<Task>>(){};
        ArrayList<Task> list = gson.fromJson(tasksSP, tasksGS.getType());

        // Create Adapter.
        TaskListAdapter taskListAdapter = new TaskListAdapter(this, list);

        // Set ListView.
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(taskListAdapter);
    }

    public void getTask(View listItem){
        Task task = (Task) listItem.getTag();

        Intent intent = new Intent(this, TaskActivity3.class);
        intent.putExtra("task", task);
        startActivity(intent);
    }
}
