package com.example.assignmentdatabasedesign;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Order.class, User.class, Category.class, Content.class},version = 1)
public abstract class LocalDatabase extends RoomDatabase {
    public abstract OrderDAO orderDAO();
    public abstract UserDAO userDAO();
    public abstract CategoryDAO categoryDAO();
    public abstract ContentDAO contentDAO();

    private static LocalDatabase instance;

    public static synchronized LocalDatabase getInstance(Context context)
    {
        if(instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            LocalDatabase.class, "localDatabase")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}