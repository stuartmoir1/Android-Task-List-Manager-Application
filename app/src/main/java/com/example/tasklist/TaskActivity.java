package com.example.tasklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_task);

        // Get IDs from form.
        TextView description = (TextView) findViewById(R.id.description);
        TextView category = (TextView) findViewById(R.id.category);
        TextView priority = (TextView) findViewById(R.id.priority);
        TextView status = (TextView) findViewById(R.id.status);
        TextView dueDate = (TextView) findViewById(R.id.due_date);
        TextView notes = (TextView) findViewById(R.id.notes);

        //
        Intent intent = getIntent();
        Task task = (Task) getIntent().getSerializableExtra("task");

        // Set text views.
        description.setText(task.getDescription());
        priority.setText(task.getPriority().toString());
        category.setText(task.getCategory());
        // BUG - The causes nullpointer exception.
        //status.setText(task.getStatus().toString());
        dueDate.setText(task.getDueDate());
        notes.setText(task.getNotes());
    }
}
