package com.example.todoappexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/*
    Compile time -> handled while the code is buffering
    Runtime -> handled while the computer is running

    OOP -> Object Orientated Programming
       Polymorphism -> taking many forms
                       overloading -> compile time
                                   -> two or more of the same name, but different parameters
                       overriding -> runtime
                                  -> pulling methods from the parent class/interface
       Abstraction -> only showing the needed functionality
       Inheritance -> one class derives from another class
       Encapsulation -> hiding the data, variables are private, methods are public
                           getters and setters

    Visibility Modifiers
    - public -> everyone can see
    - private -> only visible within the class
    - protected -> only visible to its children
*/
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //global variables
    EditText etInput;
    Button btnSubmit;
    ListView lvTodo;
    ImageButton ibtnPlus;
    TextView tvMiddleText;
    //adaptor -> layout
    ArrayAdapter<String> lvAdaptor;
    String displayText;
    final String KEY = "keykeykey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_layout);
        etInput = findViewById(R.id.et_input);
        btnSubmit = findViewById(R.id.btn_submit);
        lvTodo = findViewById(R.id.lv_todos);
        ibtnPlus = findViewById(R.id.idtn_plus);
        tvMiddleText = findViewById(R.id.tv_middle_text);

        if (savedInstanceState != null){
            displayText = savedInstanceState.getString(KEY);
            tvMiddleText.setText(displayText);
        }

        //context and the ID of the layout
        //context -> current state of the application
        lvAdaptor = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lvTodo.setAdapter(lvAdaptor);
        btnSubmit.setOnClickListener(this);

        ibtnPlus.setOnClickListener(view -> {
            tvMiddleText.setText(etInput.getText().toString());
            etInput.getText().clear();
        });
    }

    @Override
    public void onClick(View view) {

        String input = etInput.getText().toString();
        //== vs ===
        //== -> checks value
        //=== -> checks references
        if (input.equals("")){
            Toast.makeText(this, "Input cannot be empty!!", Toast.LENGTH_LONG).show();
        }else {
            addNewTodo(input);
        }

    }

    public void addNewTodo(String input){
        lvAdaptor.add(input);
        etInput.getText().clear();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY, tvMiddleText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        displayText = savedInstanceState.getString(KEY);
    }
}
/*
POJO -> Plain Old Java Object
    needs:
        Getters
        Setters
        equals
        hashCode
        toString
   a lot of
 */