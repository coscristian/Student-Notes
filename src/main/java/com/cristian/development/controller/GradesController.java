package com.cristian.development.controller;

import java.util.Scanner;

import com.cristian.development.model.Subject;
import com.cristian.development.view.GradesView;

public class GradesController {

    private GradesView view;

    private Subject[] subjects;
    
    private final static int MAIN_MENU_FIRST_LIMIT = 1;
    private final static int MAIN_MENU_SECOND_LIMIT = 4;

    public GradesController() {
        this.subjects = new Subject[30];
        this.view = new GradesView();
    }

    public void manageStudents(Scanner sc)  {

        final int FIRST_OPTION = 0;
        final int LAST_OPTION = 2;
        int option = 0;

        do {
            try {
                option = view.showSubMenuManageStudents(sc);
                switch (option) {
                    case 0:
                        
                        break;
                    case 1:
                        
                        break;
                    case 2:
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
                        manageStudents(sc);
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
