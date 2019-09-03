package com.example.user.notepad;

/**
 * Created by USER-PC on 8/15/2018.
 */

public class TempData {

    private int id;
    private String title;
    private String description;

    public TempData(String t,String des){
        title = t;
        description = des;
    }

    //empty constructor
    public TempData(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





}
