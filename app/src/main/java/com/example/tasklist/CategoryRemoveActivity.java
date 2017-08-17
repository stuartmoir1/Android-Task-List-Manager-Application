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

    private EditText categoryForm;

    private SharedPreferences sharedPref;

    private CategoryList categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_remove);

        this.buttonRemove = (Button) findViewById(R.id.button_remove);
        this.buttonCancel = (Button) findViewById(R.id.button_cancel);

        // Get String data from SP.
        this.sharedPref =
                getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String categorySP = sharedPref.getString("CategoryList", null);

        // Convert SP String data.
        Gson gson = new Gson();
        TypeToken<CategoryList> categoryGS = new TypeToken<CategoryList>(){};
        this.categoryList = gson.fromJson(categorySP, categoryGS.getType());

        this.categoryForm = (EditText) findViewById(R.id.category);
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

        this.categoryForm = (EditText) findViewById(R.id.category);

        String category = categoryForm.getText().toString();

        this.categoryList.removeCategory(category);

        // Save category list to SP.
        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("CategoryList", gson.toJson(this.categoryList));
        editor.apply();

        // Get String data from SP.
        SharedPreferences sharedPref =
                getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String tasksSP = sharedPref.getString("TaskList",
                new ArrayList<Task>().toString());
        // Convert SP String data.
        TypeToken<ArrayList<Task>> tasksGS = new TypeToken<ArrayList<Task>>(){};
        ArrayList<Task> taskList = gson.fromJson(tasksSP, tasksGS.getType());

        for (Task task : taskList) {
            Log.d("task category: ", task.getCategory());
            if (task.getCategory().equals(category)) {
                task.setCategory("");
            }
        }

        // Save task list to SP.
        editor.putString("TaskList", gson.toJson(taskList));
        editor.apply();

        //
    }
}
