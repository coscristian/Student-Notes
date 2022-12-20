package com.cristian.development.view;

import java.util.Scanner;

import com.cristian.development.controller.GradesController;
import com.cristian.development.model.Subject;
import com.cristian.development.exception.*;

public class GradesView {

    GradesController controller;

    public GradesView(GradesController controller) {
        this.controller = controller;
    }
    
    public int showMenu(Scanner sc) {

        System.out.println();
        System.out.println(".: \t        MAIN MENU \t\t :.");
        System.out.println("  \tSYSTEM FOR STUDENT GRADES\t   ");
        System.out.println("1. Manage Subjects");
        System.out.println("2. Manage Courses");
        System.out.println("3. Generate Reports");
        System.out.println("4. Create Student");
        System.out.println("0. Exit");
        System.out.println();
        
        System.out.printf("Please, select an option: ");
        int option = sc.nextInt();
        sc.nextLine();

        return option;
    }

    public int showSubMenuManageSubjects(Scanner sc) {
        System.out.println();
        System.out.println(".:\tSUBMENU -> MANAGE SUBJECTS\t:.");
        System.out.println("1. Create Subject");
        System.out.println("2. Delete Student From Subject");

        System.out.printf("Please, select an option: ");
        int option =  sc.nextInt();
        sc.nextLine();

        return option;
    }

    public void showError(Exception e, String message) {
        System.out.printf("%s: %s \n", message, e.getMessage());
    }

    public String readString(String message, Scanner sc) {
        System.out.printf(message);
        return sc.nextLine();
    }

    public float readFloat(String message, Scanner sc) {
        System.out.printf(message);
        float value = sc.nextFloat();
        sc.nextLine();

        return value;
    }

    public int readInt(String message, Scanner sc) {
        System.out.printf(message);
        int option = sc.nextInt();
        sc.nextLine();

        return option;
    }

    public int showSubMenuManageCourses(Scanner sc) {
        System.out.println();
        System.out.println(".:\tSUBMENU -> MANAGE COURSES\t:.");
        System.out.println("1. Create Course");
        System.out.println("2. Delete Course");
        System.out.println("0. Go back");

        System.out.printf("Please, select an option: ");
        int option =  sc.nextInt();
        sc.nextLine();

        return option;
    }

    public void showTitle(String title) {
        System.out.printf(title);
    }

    public void showAverage(int courseId, float average) {
        System.out.printf("\tAverage grade of Course %d -> %.2f \n", courseId, average);
    }

    public int showSubMenuSubjects(Subject[] subjects, Scanner sc) throws Exception{
        final int FIRST_OPTION = 1;
        final int TOTAL_SUBJECTS = controller.getTotalSubjects();
        int count = 1;

        if (TOTAL_SUBJECTS == 0)
            throw new NoRegisteredSubjectsException("There are no registered subjects");

        System.out.println(".:\tSUBMENU -> AVAILABLE SUBJECTS\t:.");
        for (Subject subject : subjects) {
            if (subject != null) {
                showTitle(count + ". " + subject.getName() + "\n");
                count++;                
            }
        }

        int option = readInt("\nPlease, select an option: ", sc);

        if (option < FIRST_OPTION || option > TOTAL_SUBJECTS)
            throw new Exception("Please, select a correct option!!");

        return option;
    }

    public int showSubMenuAvailableCourses(Scanner sc, Subject selectedSubject) throws Exception {
        final int FIRST_OPTION = 0;
        final int LAST_OPTION = selectedSubject.getTotalAmountCourses();

        System.out.println(".:\tSUBMENU -> AVAILABLE COURSES\t:.");
        for (int i = 0; i < selectedSubject.getTotalAmountCourses(); i++) {
            showTitle((i+1) + ". Course " + (i+1) + "\n");
        }
        showTitle("0. Go back");
        int option = readInt("\nPlease, select an option: ", sc);

        if (option < FIRST_OPTION || option > LAST_OPTION)
            throw new Exception("Please, select a correct option!!");
        return option; 
    }
}
