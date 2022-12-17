package com.cristian.development.controller;

import java.util.Scanner;

import com.cristian.development.model.Course;
import com.cristian.development.model.Student;
import com.cristian.development.model.Subject;
import com.cristian.development.view.GradesView;
import com.cristian.development.exception.*;

public class GradesController {
    private final int EXIT = 0;

    private GradesView view;

    private Subject[] subjects;

    public GradesController() {
        this.subjects = new Subject[30];
        this.view = new GradesView(this);
    }

    private void validateName(String name) throws Exception {
        name = name.replaceAll(" ", "");
        for (int i = 0; i < name.length(); i++) {
            char letter = name.charAt(i);
            if (!Character.isLetter(letter))
                throw new Exception("Invalid name");
        }
    }

    public int getTotalSubjects() {
        int totalsubjects = 0;
        for (Subject subject : subjects) if (subject != null) totalsubjects++;
        return totalsubjects;
    }

    public int getTotalCourses() {
        int totalsubjects = 0;
        for (Subject subject : subjects) {
            if (subject != null)
                totalsubjects++;
        }
        return totalsubjects;
    }

    public void createSubject(Scanner sc) {
        boolean invalidName = true;
        do {
            try {

                String name = view.readString("Please, enter the name of the subject: ", sc);
                validateName(name);
                invalidName = false;

                subjects[getTotalSubjects()] = new Subject(name);

            } catch (Exception e) {
                view.showError(e);
            }
        } while (invalidName);
    }

    public void manageSubjects(Scanner sc) {

        final int FIRST_OPTION = 0;
        final int LAST_OPTION = 2;
        int option = 0;

        do {
            try {
                option = view.showSubMenuManageSubjects(sc);
                switch (option) {
                    case 0:
                        view.showTitle("Going back to the Main Menu"); break;
                    case 1:
                        createSubject(sc);
                        break;
                    case 2:
                        // TODO: Delete student from subject
                        break;
                    case 3:
                        break;
                    default:
                        view.showTitle("Please, select a correct option."); break;
                }
            } catch (Exception e) {
                view.showError(e);
            }
        } while (option < FIRST_OPTION || option > LAST_OPTION);
    }

    private void createCourse(Scanner sc) {
        int option = 0;
        final int FIRST_OPTION = 1;
        final int LAST_OPTION = getTotalSubjects();
        final int EXIT = 0;
        do {
            try {
                if (getTotalSubjects() == 0)
                    throw new Exception("There are no registered subjects");
        
                option = view.showSubMenuSubjects(subjects, sc);
                if (option < FIRST_OPTION || option > LAST_OPTION)
                    throw new Exception("Please, select a correct option!!");

                Subject selectedSubject = subjects[option - 1];
                selectedSubject.addCourse(new Course());
                option = 0;

            } catch (Exception e) {
                option = 0;
                view.showError(e);
            }
        } while (option != EXIT);
    }

    private int selectCourse(Scanner sc, Subject selectedSubject) {
        int idCourse = 0;
        int option = 0;
        do {
            try {
                option = view.showSubMenuAvailableCourses(sc, selectedSubject);

                idCourse = option;
                option = 0;
            } catch (Exception e) {
                option = 0;
                view.showError(e);
            }    
        } while (option != EXIT);
        return idCourse - 1;
    }

    private void deleteCourse(Scanner sc) {
        int option = 0;
        
        do {
            try {        
                option = view.showSubMenuSubjects(subjects, sc);

                Subject selectedSubject = subjects[option - 1];
                if (selectedSubject.getTotalAmountCourses() == 0)
                    throw new Exception("This subject doesn't have courses!!");

                int courseIdToDelete = selectCourse(sc, selectedSubject);
                
                Course[] updatedCourses = new Course[4];
                for (int i = 0, k = 0; i < selectedSubject.getTotalAmountCourses(); i++) {
                    if(i != courseIdToDelete) {
                        updatedCourses[k] = selectedSubject.getCourses()[i];
                        k++;
                    }   
                }
                selectedSubject.setCourses(updatedCourses);
                option = 0;
            } catch (Exception e) {
                option = 0;
                view.showError(e);
            }
        } while (option != EXIT);
    }

    private void manageCourses(Scanner sc) {
        final int FIRST_OPTION = 0;
        final int LAST_OPTION = 2;
        int option = 0;

        do {
            try {
                option = view.showSubMenuManageCourses(sc);
                switch (option) {
                    case 0:
                        view.showTitle("Going to the Main Menu."); break;                      
                    case 1:
                        createCourse(sc); break;                        
                    case 2:
                        deleteCourse(sc); break;
                    default:
                        view.showTitle("Please, select a correct option."); break;
                }
            } catch (Exception e) {
                view.showError(e);
            }
        } while (option < FIRST_OPTION || option > LAST_OPTION);
    }

    private void generateAverageEveryCourse() throws Exception {

        if (getTotalSubjects() == 0)
            throw new Exception("There are no registered subjects");

        for (Subject subject : subjects) {
            if (subject.getCourses()[0] == null)
                throw new Exception("In this subject there are no courses");

            view.showTitle("Subject ->" + subject.getName() + "\n");
            for (Course course : subject.getCourses()) {
                int totalStudents = course.getTotalStudents();
                if (totalStudents == 0)
                    throw new Exception("In this course there are no students");
                float acum = 0;
                int courseId = 1;
                for (int i = 0; i < course.getTotalStudents(); i++)
                    acum += course.getStudents()[i].getGrade();

                view.showAverage(courseId, acum / course.getTotalStudents());
                courseId++;
            }
        }
    }

    private void generateReports(Scanner sc) throws Exception {
        generateAverageEveryCourse();
    }

    private void createStudent(Scanner sc) throws Exception{
        
        String name = view.readString("Please, enter the name of the student: ", sc);
        validateName(name);
        float studentGrade = view.readFloat("Plase, enter the grade of the student: ", sc);
        
        if (studentGrade >= 0.0 && studentGrade <= 5.0) {
            Student student = new Student(name, studentGrade);
            int option = 0;
            do {
                try {
                    int subjectId = view.showSubMenuSubjects(subjects, sc); 
                    Subject selectedSubject = subjects[subjectId - 1];
    
                    int courseId = selectCourse(sc, selectedSubject);
                    selectedSubject.getCourses()[courseId].addStudent(student);   
                    option = 0;                 
                }catch (NoRegisteredSubjectsException e) {
                    view.showError(e);
                }
                catch (Exception e) {
                    option = 1;
                    view.showError(e);
                }
            }while(option != EXIT);
        }else {
            throw new Exception("Invalid Grade !!");
        }
    }

    public void startSystem(Scanner sc) {

        int option = 0;

        do {
            try {
                option = view.showMenu(sc);
                switch (option) {
                    case 1:
                        manageSubjects(sc);
                        break;
                    case 2:
                        manageCourses(sc);
                        break;
                    case 3:
                        generateReports(sc);
                        break;
                    case 4:
                        createStudent(sc);
                        break;
                    default:
                        view.showError(new Exception("Please select a valid option"));
                        break;
                }
            } catch (Exception e) {
                view.showError(e);
            }
        } while (option != 0);
    }
}
