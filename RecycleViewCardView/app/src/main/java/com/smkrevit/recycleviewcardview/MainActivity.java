package com.smkrevit.recycleviewcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    StudentAdapter adapter;
    List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
        fillData();
    }

    public void load(){
        recyclerView = findViewById(R.id.rcvStudent);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void fillData(){
        studentList = new ArrayList<Student>();
        studentList.add(new Student("Galang", "Earth"));
        studentList.add(new Student("Galang2", "Earth"));
        studentList.add(new Student("Galang3", "Earth"));
        studentList.add(new Student("Galang4", "Earth"));
        studentList.add(new Student("Galang5", "Earth"));
        studentList.add(new Student("Galang6", "Earth"));
        studentList.add(new Student("Galang7", "Earth"));
        studentList.add(new Student("Galang8", "Earth"));
        studentList.add(new Student("Galang9", "Earth"));
        studentList.add(new Student("Galang10", "Earth"));
        studentList.add(new Student("Galang11", "Earth"));
        studentList.add(new Student("Galang12", "Earth"));
        studentList.add(new Student("Galang13", "Earth"));
        studentList.add(new Student("Galang14", "Earth"));
        studentList.add(new Student("Galang15", "Earth"));

        adapter = new StudentAdapter(this, studentList);
        recyclerView.setAdapter(adapter);
    }

    public void btnAdd(View view){
        studentList.add(new Student("NewGalang", "Earth"));
        adapter.notifyDataSetChanged();
    }
}