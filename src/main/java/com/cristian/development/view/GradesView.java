package com.cristian.development.view;

import java.util.Scanner;
import com.cristian.development.model.Subject;

public class GradesView {
    
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
        return sc.nextInt();
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

    public void showError(Exception e) {
        System.out.printf("ERROR: %s \n", e.toString());
    }

    public String readString(String message, Scanner sc) {
        System.out.printf(message);
        return sc.nextLine();
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
        System.out.printf("\tAverage grade of Course \n %.2f", courseId, average);
    }

    public int showSubMenuSubjects(Subject[] subjects, Scanner sc) {
        int option = 1;
        System.out.println(".:\tSUBMENU -> AVAILABLE SUBJECTS\t:.");
        for (Subject subject : subjects) {
            if (subject != null) {
                showTitle(option + ". " + subject.getName() + "\n");
                option++;                
            }
        }
        System.out.printf("\nPlease, select an option: ");
        option = sc.nextInt();
        sc.nextLine();

        return option;
    }

    public int showSubMenuAvailableCourses(Scanner sc, Subject selectedSubject) {
        int option = 1;
        System.out.println(".:\tSUBMENU -> AVAILABLE COURSES\t:.");
        for (int i = 0; i < selectedSubject.getTotalAmountCourses(); i++) {
            showTitle((i+1) + ". Course " + (i+1) + "\n");
        }
        System.out.printf("0. Go back");
        System.out.printf("\nPlease, select an option: ");
        option = sc.nextInt();
        sc.nextLine();

        return option; 
    }

}
