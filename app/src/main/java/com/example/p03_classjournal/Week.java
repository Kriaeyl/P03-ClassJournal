package com.example.p03_classjournal;

import java.io.Serializable;

public class Week implements Serializable {
    private int number;
    private String grade;

    public Week(int number, String grade) {
        this.number = number;
        this.grade = grade;
    }

    public int getNumber() {
        return number;
    }

    public String getGrade() {
        return grade;
    }
}
