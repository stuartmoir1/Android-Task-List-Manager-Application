package com.example.tasklist;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by stuartmoir on 11/08/2017.
 */

public class TaskListAdapter extends ArrayAdapter<Task> {

    public TaskListAdapter(Context context, ArrayList<Task> taskList) {
        super(context, 0, taskList);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent){

        //
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.task_item, parent, false);
        }

        //
        Task currentTask = getItem(position);

        // Set text in view.

        TextView priority = (TextView) listItemView.findViewById(R.id.priority);
        priority.setText(currentTask.getPriority().toString());

        //CategoryList categoryList = new CategoryList();
        String colour = categoryList.getCategoryColour(currentTask.getCategory());
        Log.d("", "");
        //priority.setBackgroundColor(Color.parseColor(colour));

        TextView description = (TextView) listItemView.findViewById(R.id.description);
        description.setText(currentTask.getDescription());

        TextView dueDate = (TextView) listItemView.findViewById(R.id.due_date);
        dueDate.setText(currentTask.getDueDate());

        TextView status = (TextView) listItemView.findViewById(R.id.status);
        status.setText(currentTask.getStatus().toString());

        TextView category = (TextView) listItemView.findViewById(R.id.category);
        category.setText(currentTask.getCategory());

        //
        listItemView.setTag(currentTask);
        return listItemView;
    }
}
