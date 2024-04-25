package com.example.assignmentdatabasedesign;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Content")
public class Content {
    @PrimaryKey(autoGenerate = true)
    private int content_id;
    private String name;
    private int category_id;//foreign key
    private int content_resID;
    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getContent_resID() {
        return content_resID;
    }

    public void setContent_resID(int content_resID) {
        this.content_resID = content_resID;
    }


}
