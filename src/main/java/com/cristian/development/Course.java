package com.cristian.development;

/**
 * This class generates all the courses which are part of the corresponding subject and it has the average grade of every course
 * @Project Student Grades
 * @FileName Course.java
 * @author Cristian Quesada Cossio
 * @version 1.0
 */
public class Course {
    private Student[] students;
    private Subject subject;

    /**
     * Build a new Course with an array of 25 empty positions 
     */
    public Course() {
        this.students = new Student[25];
    }

    /**
     * This method obtains the subject of the corresponding course 
     * @return Subject of the course
     * @see String
     */
    public Subject getSubject() {
        return this.subject;
    }

    /**
     * Add a new student to the course
     * @param newStudent
     * @return void
     * @throws Exception You can't assign more students to this course.
     */
    public void addStudent(Student newStudent) throws Exception{
        
        int totalStudents = 0;
        for (Student student : students) {
            if (student != null) totalStudents++;
        }

        if (totalStudents < 25)
            students[totalStudents] = newStudent;
        else 
            throw new Exception("You can't assign more students to this course.");
    }

    /**
     * Obtain the average grade of the students from the course
     * @return Average grade of the course
     * @see float
     */
    public float getCourseGradeAverage() {
        // TODO: Obtain total of students to get the average of notes


        return 1f;
    }
}
