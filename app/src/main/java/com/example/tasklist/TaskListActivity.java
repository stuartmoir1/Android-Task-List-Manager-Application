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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.task_list_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_task) {
            Intent intent = new Intent(this, TaskActivity3.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.sort_by_priority) {
            // TODO: do something
            return true;
        }
        if (item.getItemId() == R.id.sort_by_category) {
            // TODO: do something
            return true;
        }
        if (item.getItemId() == R.id.sort_by_due_date) {
            // TODO: do something
            return true;
        }
        if (item.getItemId() == R.id.show_open) {
            // TODO: do something
            return true;
        }
        if (item.getItemId() == R.id.show_closed) {
            // TODO: do something
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
