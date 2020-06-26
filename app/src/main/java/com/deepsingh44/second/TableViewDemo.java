package com.deepsingh44.second;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TableViewDemo extends AppCompatActivity {
    /*<TableRow>

            <TextView
        android:gravity="center"
        android:text="Name"
        android:id="@+id/name"/>

            <TextView
        android:gravity="center"
        android:text="Roll"
        android:id="@+id/roll"/>

            <TextView
        android:gravity="center"
        android:text="Marks"
        android:id="@+id/marks"/>
        </TableRow>*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_view_demo);
        ArrayList<Student> list = (ArrayList<Student>) getIntent().getExtras().getSerializable("students");

        TableLayout tableLayout = findViewById(R.id.mytable);

        for (Student s : list) {
            TableRow tr = new TableRow(this);
            TextView tname = new TextView(this);
            tname.setGravity(Gravity.CENTER);
            TextView troll = new TextView(this);
            troll.setGravity(Gravity.CENTER);
            TextView tmarks = new TextView(this);
            tmarks.setGravity(Gravity.CENTER);

            tname.setText(s.getName());
            troll.setText(String.valueOf(s.getRoll()));
            tmarks.setText(String.valueOf(s.getMarks()));

            tr.addView(tname);
            tr.addView(troll);
            tr.addView(tmarks);
            tableLayout.addView(tr);
        }

    }
}
