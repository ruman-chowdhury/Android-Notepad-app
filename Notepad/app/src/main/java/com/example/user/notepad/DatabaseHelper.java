package com.example.user.notepad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by USER-PC on 7/28/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME ="Information.db";
    private static String TABLE_NAME ="info_tbl";
    private static int VERSION_NUMBER =1;

    private static String ID ="_id";
    private static String TITLE ="Title";
    private static String DESCRIPTION ="Description";

    private static String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+TITLE+" text,"+DESCRIPTION+" text)";
    private static String DROP_TABLE = "DROP TABLE IF EXISTS"+TABLE_NAME;
    private static String SELECT_ALL = "SELECT * FROM " +TABLE_NAME;



    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE);
        onCreate(db);
    }



    //insert data
    public void insert_data(TempData td){

        SQLiteDatabase sqd = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TITLE,td.getTitle());
        cv.put(DESCRIPTION,td.getDescription());

        sqd.insert(TABLE_NAME,null,cv);
        sqd.close();

    }


//    //get data from db
//    String[] get_data(){
//
//        SQLiteDatabase sqd = this.getReadableDatabase();
//        Cursor cursor = sqd.rawQuery(SELECT_ALL,null);
//
//        String[] receive_data = new String[cursor.getCount()];
//        int counter=0;
//        while (cursor.moveToNext()){
//
//            receive_data[counter] = cursor.getString(cursor.getColumnIndex(TITLE +"")) +"\n"+
//                                    cursor.getString(cursor.getColumnIndex(DESCRIPTION +""));
//            counter = counter+1;
//        }
//
//        return  receive_data;
//
//    }

    //Fetch data from db
    ArrayList<TempData> get_data(){

        SQLiteDatabase sqd = this.getReadableDatabase();
        Cursor cursor = sqd.rawQuery(SELECT_ALL,null);

        ArrayList<TempData> listData = new ArrayList<>();


        if(cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {

                TempData td = new TempData();
                td.setTitle(cursor.getString(cursor.getColumnIndex(TITLE + "")));
                td.setDescription(cursor.getString(cursor.getColumnIndex(DESCRIPTION + "")));

                listData.add(td);

                cursor.moveToNext();
            }

        }
        close();
        return  listData;

    }



    //Update data
    TempData edit_data(int id){

        SQLiteDatabase sqd = this.getReadableDatabase();

        String UPDATE_ALL = "SELECT "+TITLE+" AND "+DESCRIPTION+" FROM "+TABLE_NAME+" WHERE "+ID+" = "+id;
        Cursor cursor = sqd.rawQuery(UPDATE_ALL,null);

       // ArrayList<TempData> listData = new ArrayList<>();
        TempData td = new TempData();
        if(cursor.moveToFirst()){

            td.setTitle(cursor.getString(cursor.getColumnIndex(TITLE +"")));
            td.setDescription(cursor.getString(cursor.getColumnIndex(DESCRIPTION +"")));


        }

        return td;
    }


}
