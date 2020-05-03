package com.erzhan.taskapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.erzhan.taskapp.models.Task;

public class FormActivity extends AppCompatActivity {

    EditText editTitle;
    EditText editDesk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        if (getSupportActionBar() != null){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Новая задача");
        }
        editTitle=findViewById(R.id.editTitle);
        editDesk=findViewById(R.id.editDesc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    public void onClick(View view) {
        String title= editTitle.getText().toString().trim();
        String desc= editDesk.getText().toString().trim();
        Task task = new Task(title,desc);
        Intent intent=new Intent();
        intent.putExtra("task",task);
        setResult(RESULT_OK,intent);
        finish();
    }
}
