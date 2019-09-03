package com.example.user.notepad;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    FloatingActionButton faButton;

    DatabaseHelper dh;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        faButton = findViewById(R.id.idFloatingActionButton);
        lv = findViewById(R.id.idListView);


        faButton.setOnClickListener(this);

        populate_data(); //call the method


        // set listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {


                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                dialog.setTitle("Choose an action: ");
                CharSequence[] items = {"Update","Delete"};
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {

                        if(item == 0){

                            Intent intent = new Intent(getApplicationContext(),UpdateActivity.class);
                            intent.putExtra("KEY",position);
                            startActivity(intent);

                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Delete",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                dialog.show();


            }
        });



    }



    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,EditActivity.class);
        startActivity(intent);
    }



    //show data in listview
    public void populate_data(){

        //read data
        dh = new DatabaseHelper(this);

        ArrayList<TempData> itemList ;
        itemList = dh.get_data();

//        ArrayList<TempData> listdata = new ArrayList<>();
//        while (cursor.moveToNext()){
//            listdata.add(cursor.getString(cursor.getColumnIndex()));
//            listdata.add(cursor.getString(cursor.getColumnIndex()));
//        }

        CustomAdapter adp = new CustomAdapter(MainActivity.this,itemList);
        lv.setAdapter(adp);

    } //end of show_method






}
