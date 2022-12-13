package com.cristian.development;

public class Course {
    private Student[] students;
    private Subject subject;

    public Course() {
        this.students = new Student[25];
    }

    public Subject getSubject() {
        return this.subject;
    }
}
