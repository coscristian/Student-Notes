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
     * This method obtains the students of the corresponding course 
     * @return Students of the course
     * @see Student[]
     */
    public Student[] getStudents() {
        return this.students;
    }

    /**
     * This method obtains the total amount of students of the course 
     * @return Total amount of students of the course
     * @see int
     */
    public int getTotalStudents() {
        int totalStudents = 0;
        for (Student student : students) {
            if (student != null) totalStudents++;
        }
        return totalStudents;
    }

    /**
     * Add a new student to the course
     * @param newStudent
     * @return void
     * @throws Exception You can't assign more students to this course.
     */
    public void addStudent(Student newStudent) throws Exception{
        int totalStudents = getTotalStudents();

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
        int totalStudents = 0;
        float gradeSum = 0f;

        for (Student student : students) {
            if (student != null){
                gradeSum += student.getGrade();
                totalStudents++;
            }                    
        }
        return gradeSum / totalStudents;
    }
}
