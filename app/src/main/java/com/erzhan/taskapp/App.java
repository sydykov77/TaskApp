package com.erzhan.taskapp;

import android.app.Application;

import androidx.room.Room;

import com.erzhan.taskapp.room.AppDatabase;

public class App extends Application {
    private AppDatabase database;
    public static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();

    }

    public AppDatabase getDatabase() {
        return database;
    }

    public static App getInstance() {
        return instance;
    }
}
