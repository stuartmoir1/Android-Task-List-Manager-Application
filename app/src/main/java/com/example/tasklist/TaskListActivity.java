package com.example.tasklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

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

        //
        Intent intent = getIntent();
        ArrayList<Task> list = (ArrayList<Task>) getIntent().getSerializableExtra("tasklist");

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
