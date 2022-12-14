package com.cristian.development.controller;

import java.util.Scanner;

import com.cristian.development.model.Subject;
import com.cristian.development.view.GradesView;

public class GradesController {

    private GradesView view;

    private Subject[] subjects;
    
    private final static int MAIN_MENU_FIRST_LIMIT = 1;
    private final static int MAIN_MENU_SECOND_LIMIT = 3;

    public GradesController() {
        this.subjects = new Subject[30];
        this.view = new GradesView();
    }

    private void validateName(String name) throws Exception{
        name = name.replaceAll(" ", "");
        for(int i = 0; i < name.length(); i++) {
            char letter = name.charAt(i);
            if(!Character.isLetter(letter))
                throw new Exception("Invalid name");
        }
    }

    public int getTotalSubjects() {
        int totalsubjects = 0;
        for (Subject subject : subjects) {
            if (subject != null) totalsubjects++;
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
        }while(invalidName);
    }

    public void manageSubjects(Scanner sc)  {

        final int FIRST_OPTION = 0;
        final int LAST_OPTION = 2;
        int option = 0;

        do {
            try {
                option = view.showSubMenuManageSubjects(sc);
                switch (option) {
                    case 1:
                        createSubject(sc);
                        break;
                    case 2:
                        // TODO: Delete student from subject
                        break;
                    case 3:
                        break;
                    default:

                        break;
                }
            } catch (Exception e) {
                view.showError(e);
            }
        } while (option < FIRST_OPTION || option > LAST_OPTION);
    }

    public void startSystem(Scanner sc) {

        int option = 0;

        try {
            do {
                option = view.showMenu(sc);
                switch (option) {
                    case 1:
                        manageSubjects(sc);
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
            } while (option < MAIN_MENU_FIRST_LIMIT || option > MAIN_MENU_SECOND_LIMIT);            
        } catch (Exception e) {
            view.showError(e);
        }
    }

}
