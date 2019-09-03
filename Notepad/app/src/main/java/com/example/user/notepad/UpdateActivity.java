package com.example.user.notepad;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener{

    FloatingActionButton updateFaCancel;
    private EditText updateTitleET,updateDescriptionET;
    private Button updateButtonSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        updateFaCancel = findViewById(R.id.updateFaCancel);
        updateTitleET = findViewById(R.id.updateTitleET);
        updateDescriptionET = findViewById(R.id.updateDescriptionET);
        updateButtonSave = findViewById(R.id.updateButtonSave);


        int receive_pos = getIntent().getIntExtra("KEY",999);

        DatabaseHelper dh = new DatabaseHelper(this);

        TempData td = dh.edit_data(receive_pos+1);

        updateTitleET.setText(td.getTitle());
        updateDescriptionET.setText(td.getDescription());

        //updateDescriptionET.setText(listdata.get(receive_pos+1).getDescription());

    }


    @Override
    public void onClick(View v) {



        //cancel
        if(v.getId() == R.id.updateFaCancel){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }


    }
}
