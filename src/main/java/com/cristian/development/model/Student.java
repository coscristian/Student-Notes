package com.cristian.development.model;

/**
 * This class generates a student who will matriculate a course
 * @Project Student Grades
 * @FileName Student.java
 * @author Cristian Quesada Cossio
 * @version 1.0
 */
public class Student {

    private String id;
    private float grade;

    /**
     * Build a new Student
     * @param id
     * @param grade
     */
    public Student(String id, float grade) {
        this.id = id;
        this.grade = grade;
    }

    /**
     * This method returns the identification of the student
     * @return Id of the student
     * @see String
     */
    public String getId() {
        return this.id;
    }

    /**
     * This method sets the new grade for a student
     * @param newGrade
     * @return void
     */
    public void setGrade(float newGrade) {
        this.grade = newGrade;
    }

    /**
     * This method returns the grade of the student
     * @return Grade of the student
     * @see float
     */
    public float getGrade() {
        return this.grade;
    }
}
