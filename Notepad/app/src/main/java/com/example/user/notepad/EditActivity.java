package com.example.user.notepad;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity implements View.OnClickListener{

    FloatingActionButton faCancel;
    private EditText titleET,descriptionET;
    private Button btnSave;

    DatabaseHelper dh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        titleET = (EditText) findViewById(R.id.titleET);
        descriptionET = (EditText) findViewById(R.id.descriptionET);

        faCancel = findViewById(R.id.idCancel);
        btnSave = (Button) findViewById(R.id.btnSave);

        //create object of database class
        dh = new DatabaseHelper(this);
        SQLiteDatabase sqd = dh.getWritableDatabase();


        btnSave.setOnClickListener(this);
        faCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String title = titleET.getText().toString();
        String description = descriptionET.getText().toString();

        //button save
        if(v.getId() == R.id.btnSave){

           TempData td = new TempData(title,description);
            dh.insert_data(td); //call insert method

            Toast.makeText(getApplicationContext(),"Data addded Successfully !",Toast.LENGTH_SHORT).show();
        }



        //button cancel
        if(v.getId() == R.id.idCancel){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }

    }






}
