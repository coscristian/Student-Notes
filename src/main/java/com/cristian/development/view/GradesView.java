package com.cristian.development.view;

import java.util.Scanner;

public class GradesView {
    
    public int showMenu(Scanner sc) {

        System.out.println();
        System.out.println(".: \t        MAIN MENU \t\t :.");
        System.out.println("  \tSYSTEM FOR STUDENT GRADES\t   ");
        System.out.println("1. Manage Students");
        System.out.println("2. Manage Subjects");
        System.out.println("3. Manage Courses");
        System.out.println("4. Generate Reports");
        System.out.println("0. Exit");
        System.out.println();
        
        System.out.printf("Please, select an option: ");
        return sc.nextInt();
    }

    public int showSubMenuManageStudents(Scanner sc) {
        System.out.println();
        System.out.println(".:\tSUBMENU -> MANAGE STUDENTS\t:.");
        System.out.println("1. Create Student");
        System.out.println("2. ");
        System.out.println("3. ");

        System.out.printf("Please, select an option: ");
        return sc.nextInt();
    }

    public void showError(Exception e) {
        System.out.printf("ERROR: %s \n" + e.toString());
    }

}
