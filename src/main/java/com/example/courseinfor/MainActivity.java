package com.example.courseinfor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View v){
        CourseView courseV = new CourseView();
        ((TextView) findViewById(R.id.answer2)).setText(courseV.listAllCourses());
    }

    public void buttonClicked2(View v){
        try{
        EditText weightView = (EditText) findViewById(R.id.weightbox2);
        String S = weightView.getText().toString();
        CourseView courseV = new CourseView();
        ((TextView) findViewById(R.id.answer2)).setText(courseV.listCourse(S));
    }

        catch (Exception e)
        {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }



}