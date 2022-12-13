package com.cristian.development;

import java.util.Scanner;

public class AppGrades {

    private Subject[] subjects;
    private Scanner sc;
    private final static int MAIN_MENU_FIRST_LIMIT = 1;
    private final static int MAIN_MENU_SECOND_LIMIT = 4;

    public AppGrades() {
        this.subjects = new Subject[30];
        this.sc = new Scanner(System.in);
    }

    public int showMenu() {

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

    public static void main(String[] args) {
        AppGrades gradeSystem = new AppGrades();
        int option = 0;

        try {
            do {
                option = gradeSystem.showMenu();
                switch (option) {
                    case 1:
                        
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    default:
                        break;
                }
            } while (option >= MAIN_MENU_FIRST_LIMIT && option <= MAIN_MENU_SECOND_LIMIT);            
        } catch (Exception e) {
            System.out.printf("ERROR: %s \n" + e.toString());
        }
    }

}
