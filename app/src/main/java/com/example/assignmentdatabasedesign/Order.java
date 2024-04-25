package com.example.assignmentdatabasedesign;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "Order",
        primaryKeys = {"user_id", "content_id"},
        foreignKeys = {
                @ForeignKey(entity = User.class,
                        parentColumns = "user_id",
                        childColumns = "user_id",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Content.class,
                        parentColumns = "content_id",
                        childColumns = "content_id",
                        onDelete = ForeignKey.CASCADE)
        })
public class Order {

    private int user_id;//User table foreign key
    private int content_id;//Content table foreign key
    private String order_brief;
    private int order_quantity;
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public String getOrder_brief() {
        return order_brief;
    }

    public void setOrder_brief(String order_brief) {
        this.order_brief = order_brief;
    }

    public int getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }

    //Abandoned primary key, current primary key id= #userid_&content_id&quantity
    //private int order_id;  //order number in view context, start with #

}
