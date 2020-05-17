package com.erzhan.taskapp.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.erzhan.taskapp.models.Task;

@Database(entities = {Task.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();

}
