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
import java.util.HashMap;

public class CategoryAddActivity extends AppCompatActivity {

    // Properties
    private Button buttonAdd;
    private Button buttonCancel;

    private EditText categoryForm;
    private EditText categoryColourForm;

    private SharedPreferences sharedPref;

    private CategoryList categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_add);

        this.buttonAdd = (Button) findViewById(R.id.button_add);
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
        this.categoryColourForm = (EditText) findViewById(R.id.category_colour);
    }

    // TO DO. Should this method (and similar methods elsewhere) by private?
    public void onButtonClicked(View button) {

        // REFACTOR
        if (button == this.buttonAdd) {
            AddCategory();
        } else if (button == this.buttonCancel) {
            // Do nothing.
        } else {
            // Exception
        }

        // Return to task list view.
        Intent intent = new Intent(this, TaskActivity3.class);
        startActivity(intent);
    }

    public void AddCategory(){

        this.categoryForm = (EditText) findViewById(R.id.category);
        this.categoryColourForm = (EditText) findViewById(R.id.category_colour);

        String category = categoryForm.getText().toString();
        String categoryColour = categoryColourForm.getText().toString();

        this.categoryList.addCategory(category, categoryColour);

        // Save task list to SP.
        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("CategoryList", gson.toJson(this.categoryList));
        editor.apply();
    }
}
