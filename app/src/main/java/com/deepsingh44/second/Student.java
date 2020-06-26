package com.deepsingh44.second;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int roll;
    private float marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }


}
