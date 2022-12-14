package com.cristian.development.view;

import java.util.Scanner;

public class GradesView {
    
    public int showMenu(Scanner sc) {

        System.out.println();
        System.out.println(".: \t        MAIN MENU \t\t :.");
        System.out.println("  \tSYSTEM FOR STUDENT GRADES\t   ");
        System.out.println("1. Manage Subjects");
        System.out.println("2. Manage Courses");
        System.out.println("3. Generate Reports");
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
        System.out.println("3. ");

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

        System.out.printf("Please, select an option: ");
        int option =  sc.nextInt();
        sc.nextLine();

        return option;
    }

}
