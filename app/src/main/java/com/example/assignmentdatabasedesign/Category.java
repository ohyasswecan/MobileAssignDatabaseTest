package com.example.assignmentdatabasedesign;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Category")
public class Category {
    @PrimaryKey(autoGenerate = true)
    private int category_id;
    private String name;
    private int category_resID;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory_resID() {
        return category_resID;
    }

    public void setCategory_resID(int category_resID) {
        this.category_resID = category_resID;
    }


}
