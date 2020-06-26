package com.deepsingh44.second;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomStudentItem extends BaseAdapter {
    private List<Student> list;

    public CustomStudentItem(List<Student> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,null);
        TextView tname=v.findViewById(R.id.name);
        TextView troll=v.findViewById(R.id.roll);
        TextView tmarks=v.findViewById(R.id.marks);

        Student student=list.get(i);
        tname.setText(student.getName());
        troll.setText(String.valueOf(student.getRoll()));
        tmarks.setText(String.valueOf(student.getMarks()));

        return v;
    }
}
