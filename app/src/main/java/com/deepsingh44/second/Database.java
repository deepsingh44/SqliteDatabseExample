package com.deepsingh44.second;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "college";
    private static final String TABLE_NAME = "student";
    private static final String NAME = "name";
    private static final String ROLL = "roll";
    private static final String MARKS = "marks";
    private static final int VERSION = 1;

    private static final String CREATE_QUERY = "create table " + TABLE_NAME + " (" + ROLL + " int primary key," + NAME + " varchar(30)," + MARKS + " float);";

    Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_NAME + "");
        onCreate(sqLiteDatabase);
    }

    public long insert(Student lifafa) {
        ContentValues cv = new ContentValues();
        cv.put(ROLL, lifafa.getRoll());
        cv.put(NAME, lifafa.getName());
        cv.put(MARKS, lifafa.getMarks());
        return getWritableDatabase().insert(TABLE_NAME, null, cv);
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> list = new ArrayList<>();
        Cursor cr = getReadableDatabase().query(TABLE_NAME, null, null, null, null, null, null);
        while (cr.moveToNext()) {
            Student student = new Student();
            student.setRoll(cr.getInt(0));
            student.setName(cr.getString(1));
            student.setMarks(cr.getFloat(2));
            list.add(student);
        }
        return list;
    }

    public long delete(int roll) {
        return getWritableDatabase().delete(TABLE_NAME, "" + ROLL + "=?", new String[]{String.valueOf(roll)});
    }

    public long update(Student student) {
        ContentValues cv = new ContentValues();
        cv.put(ROLL, student.getRoll());
        cv.put(NAME, student.getName());
        cv.put(MARKS, student.getMarks());
        return getWritableDatabase().update(TABLE_NAME, cv, "" + ROLL + "=?", new String[]{String.valueOf(student.getRoll())});
    }

    public Student getStudent(int roll) {
        Student student = null;
        Cursor c = getReadableDatabase().query(TABLE_NAME, null, "" + ROLL + "=?", new String[]{String.valueOf(roll)}, null, null, null, null);
        if (c.moveToNext()) {
            student = new Student();
            student.setRoll(c.getInt(0));
            student.setName(c.getString(1));
            student.setMarks(c.getFloat(2));
        }
        return student;
    }
}
