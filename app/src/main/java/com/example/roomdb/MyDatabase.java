package com.example.roomdb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = {UserActivity.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    public abstract UserDAO getUserDao();

    public static MyDatabase instance;

    public static MyDatabase getInstance(Context context) {


        if (instance == null) {
            instance = Room
                    .databaseBuilder(context, MyDatabase.class, "mydb_android")
                    .allowMainThreadQueries()
                    .build();

        }
        return instance;

    }

}
