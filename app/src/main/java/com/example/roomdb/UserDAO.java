package com.example.roomdb;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UserDAO {// allow database access

    //Define functions to access the db

    @Insert
     void insertUser(UserActivity x);

    @Query("select * from UserActivity")
    List<UserActivity> getAllUsers();

    @Delete
    void deleteUser(UserActivity x);

    @Update
    void updateUser(UserActivity x);

    @Query("select * from UserActivity where id=:id")
    UserActivity getUser(int id);

    @Query("select count(id) from UserActivity")
    int getCount();


}
