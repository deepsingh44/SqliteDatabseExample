package com.deepsingh44.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText troll, tname, tmarks;
    private Database database;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        troll = findViewById(R.id.roll);
        tname = findViewById(R.id.name);
        tmarks = findViewById(R.id.marks);
        listView = findViewById(R.id.listdemo);
        database = new Database(this);

    }


    public void submit(View view) {
        String roll = troll.getText().toString();
        String name = tname.getText().toString();
        String mark = tmarks.getText().toString();

        Student student = new Student();
        student.setRoll(Integer.parseInt(roll));
        student.setName(name);
        student.setMarks(Float.parseFloat(mark));

        long t = database.insert(student);
        if (t > 0) {
            Toast.makeText(this, "Successfully Store", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Store Failed", Toast.LENGTH_SHORT).show();
        }

    }

    public void fetch(View view) {
        ArrayList<Student> list = database.getAllStudents();
        /*if (list.size() > 0) {
            //listView.setAdapter(new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, list));
            listView.setAdapter(new CustomStudentItem(list));

        } else {
            Toast.makeText(this, "sorry there is no student", Toast.LENGTH_SHORT).show();
        }*/

        Intent in = new Intent(this, TableViewDemo.class);
        in.putExtra("students", list);
        startActivity(in);

    }

    public void update(View view) {
        String roll = troll.getText().toString();
        Student student = database.getStudent(Integer.parseInt(roll));
        if (student != null) {
            student.setName(tname.getText().toString());
            student.setMarks(Float.parseFloat(tmarks.getText().toString()));
            long t = database.update(student);
            if (t > 0) {
                Toast.makeText(this, "Successfully Update", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Updation Failed", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "This roll number does not exist", Toast.LENGTH_SHORT).show();
        }
    }

    public void delete(View view) {
        String roll = troll.getText().toString();
        Student student = database.getStudent(Integer.parseInt(roll));
        if (student != null) {
            long t = database.delete(Integer.parseInt(roll));
            if (t > 0) {
                Toast.makeText(this, "Successfully Delete", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "This roll does not exist", Toast.LENGTH_SHORT).show();
        }
    }
}
