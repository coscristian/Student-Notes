package com.cristian.development;

import java.util.Scanner;

import com.cristian.development.controller.GradesController;

public class App {
    public static void main(String[] args) {
        GradesController gradeSystem = new GradesController();
        Scanner sc = new Scanner(System.in);

        gradeSystem.startSystem(sc);
        sc.close();
    }
}
