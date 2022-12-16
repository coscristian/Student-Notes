package com.cristian.development.model;

/**
 * This class generates a subject and count the total amount of students losing and passing the subject, count the total amount of students registered by subject 
 * @Project Student Grades
 * @FileName Subject.java
 * @author Cristian Quesada Cossio
 * @version 1.0
 */
public class Subject {

    private String name;
    private Course[] courses;

    /**
     * Build a new subject with an array of 4 empty positions 
     * @param name
     * @return void
     */
    public Subject(String name) {
        this.name = name;
        this.courses = new Course[4];
    }

    /**
     * Obtain the name of the corresponding subject
     * @return Name of the subject
     * @see String
     */
    public String getName() {
        return this.name;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    /**
     * Obtain the courses of the subject
     * @return Courses of the corresponding subject
     * @see int
     */
    public Course[] getCourses() {
        return this.courses;
    }

    /**
     * Obtain the total amount of courses of the corresponding subject
     * @return Total courses
     * @see int
     */
    public int getTotalAmountCourses() {
        int cont = 0;
        for (Course course : courses) {
            if (course != null) cont++;
        }
        return cont;
    }

    /**
     * Add a course to the subject
     * @param newCourse
     * @see Course
     * @throws Exception
     */
    public void addCourse(Course course) throws Exception{
        int totalCourses = getTotalAmountCourses();
        if (totalCourses < 4)
            this.courses[totalCourses] = course;
        else
            throw new Exception("This subject is full of courses!! You can only add 4 courses to a subject");
    }

    /**
     * Obtain the total amount of students losing the subject
     * @return Amount of students losing the subject
     * @see int
     */
    public int getTotalStudentsLosing() {
        int totalStudentsLosing = 0;
        for (Course course : this.courses) {
            for (Student student : course.getStudents()) {
                if (student.getGrade() < 3.0) totalStudentsLosing++;
            }
        }
        return totalStudentsLosing;
    }

    /**
     * Obtain the total amount of students passing the subject
     * @return Amount of students passing the subject
     * @see int
     */
    public int getTotalStudentsPassing() {
        int totalStudentsPassing = 0;
        for (Course course : this.courses) {
            for (Student student : course.getStudents()) {
                if (student.getGrade() > 3.0) totalStudentsPassing++;
            }
        }
        return totalStudentsPassing;
    }

    /**
     * Obtain the total amount Amount of students registered in the subject
     * @return Amount of students registered in the subject
     * @see int
     */
    public int getTotalStudentsRegistered() {
        int totalStudents = 0;
        for (Course course : this.courses) {
            totalStudents += course.getTotalStudents();
        }
        return totalStudents;
    }

}
