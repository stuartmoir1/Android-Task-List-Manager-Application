package com.example.tasklist;

import android.content.SharedPreferences;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by stuartmoir on 11/08/2017.
 */

public class TaskListAdapter extends ArrayAdapter<Task> {

    private static SharedPreferences sharedPref;
    private CategoryList categoryList;

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

        // Get String data from SP.
        sharedPref =
                getContext().getSharedPreferences("TASKDETAILS", Context.MODE_PRIVATE);
        // HACK: new CategoryList().toString() replaced by "{}"
        String categorySP = sharedPref.getString("CategoryList", null);
        Log.d("categorySP: ", categorySP);

        // Convert SP String data.
        Gson gson = new Gson();
        TypeToken<CategoryList> categoryGS = new TypeToken<CategoryList>(){};
        Log.d("categoryGS: ", categoryGS.toString());
        this.categoryList = gson.fromJson(categorySP, categoryGS.getType());
        Log.d("categoryList: ", this.categoryList.toString());

        // Set text in view.

        TextView priority = (TextView) listItemView.findViewById(R.id.priority);
        priority.setText(currentTask.getPriority().toString());

        // Assign background colour where task has category.
        String colour = categoryList.getCategoryColour(currentTask.getCategory());
        if (colour != null) {
            priority.setBackgroundColor(Color.parseColor(colour));
        } else {
            priority.setBackgroundColor(Color.parseColor("white"));
        }

        TextView description = (TextView) listItemView.findViewById(R.id.description);
        description.setText(currentTask.getDescription());

        // Date
        TextView dueDate = (TextView) listItemView.findViewById(R.id.due_date);
        dueDate.setText(currentTask.getDueDateAsString());

        TextView status = (TextView) listItemView.findViewById(R.id.status);
        status.setText(currentTask.getStatusTask());

        TextView category = (TextView) listItemView.findViewById(R.id.category);

        if (currentTask.getCategory().equals("")) {
            category.setText("no category");
        } else {
            category.setText(currentTask.getCategory());
        }

        //
        listItemView.setTag(currentTask);
        return listItemView;
    }
}
