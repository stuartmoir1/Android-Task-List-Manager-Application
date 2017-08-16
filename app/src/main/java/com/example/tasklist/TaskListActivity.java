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

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class TaskListActivity extends AppCompatActivity {

    // Properties
    private ArrayList<Task> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_list);

        // Seed data.
        //TaskList taskList = new TaskList();
        //ArrayList<Task> list = taskList.getList();

        // Get String data from SP.
        SharedPreferences sharedPref =
            getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        //SharedPreferences.Editor editorDebug = sharedPref.edit();
        //editorDebug.clear();
        //editorDebug.commit();
        String tasksSP = sharedPref.getString("TaskList",
            new ArrayList<Task>().toString());

        // Convert SP String data.
        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> tasksGS = new TypeToken<ArrayList<Task>>(){};
        list = gson.fromJson(tasksSP, tasksGS.getType());

        // Filter/ sort by menu selection or by id by default.
        ArrayList<Task> sortedArr;
        sortedArr = (ArrayList<Task>) getIntent().getSerializableExtra("sortedArr");
        if (sortedArr == null) {
            ArrayListSort sort = new ArrayListSort();
            sortedArr = sort.byId(list);
        }

        // Save category list to SP if it does not exist.

        // Get String data from SP.
        Type categoryListType = new TypeToken<CategoryList>(){}.getType();
        // HACK: new CategoryList().toString() replaced by "{}"
        String categorySP = sharedPref.getString("CategoryList", null);
        CategoryList categoryList = gson.fromJson(categorySP, categoryListType);

        //if(categoryList == null){
        //    categoryList = new CategoryList();
        //}

        if (categoryList == null){
            Log.d("Added default ", "categories to SP...");
            CategoryList categoriesDefault = new CategoryList();
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("CategoryList", gson.toJson(categoriesDefault));
            editor.apply();
        }

        // Create Adapter and set ListView
        TaskListAdapter taskListAdapter = new TaskListAdapter(this, sortedArr);
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

        // REFACTOR
        if (item.getItemId() == R.id.add_task) {
            Intent intent = new Intent(this, TaskActivity3.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.show_all_tasks) {

            ArrayListSort sort = new ArrayListSort();
            ArrayList<Task> sortedArr = sort.byId(list);

            Intent intent = new Intent(this, TaskListActivity.class);
            intent.putExtra("sortedArr", sortedArr);
            startActivity(intent);

            return true;
        }
        if (item.getItemId() == R.id.sort_by_priority) {

            ArrayListSort sort = new ArrayListSort();
            ArrayList<Task> sortedArr = sort.byPriorityThenId(list);

            Intent intent = new Intent(this, TaskListActivity.class);
            intent.putExtra("sortedArr", sortedArr);
            startActivity(intent);

            return true;
        }
        if (item.getItemId() == R.id.sort_by_category) {

            ArrayListSort sort = new ArrayListSort();
            ArrayList<Task> sortedArr = sort.byCategoryThenId(list);

            Intent intent = new Intent(this, TaskListActivity.class);
            intent.putExtra("sortedArr", sortedArr);
            startActivity(intent);

            return true;
        }
        if (item.getItemId() == R.id.sort_by_due_date) {

            ArrayListSort sort = new ArrayListSort();
            ArrayList<Task> sortedArr = sort.byDueDateThenId(list);

            Intent intent = new Intent(this, TaskListActivity.class);
            intent.putExtra("sortedArr", sortedArr);
            startActivity(intent);

            return true;
        }
        if (item.getItemId() == R.id.show_open) {

            ArrayListSort sort = new ArrayListSort();
            ArrayList<Task> sortedArr = sort.showStatusOpenOnly(list);

            Intent intent = new Intent(this, TaskListActivity.class);
            intent.putExtra("sortedArr", sortedArr);
            startActivity(intent);

            return true;
        }
        if (item.getItemId() == R.id.show_closed) {

            ArrayListSort sort = new ArrayListSort();
            ArrayList<Task> sortedArr = sort.showStatusClosedOnly(list);

            Intent intent = new Intent(this, TaskListActivity.class);
            intent.putExtra("sortedArr", sortedArr);
            startActivity(intent);

            return true;
        }
        if (item.getItemId() == R.id.show_no_category) {

            ArrayListSort sort = new ArrayListSort();
            ArrayList<Task> sortedArr = sort.showNoCategory(list);

            Intent intent = new Intent(this, TaskListActivity.class);
            intent.putExtra("sortedArr", sortedArr);
            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}