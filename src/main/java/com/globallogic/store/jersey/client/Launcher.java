package com.globallogic.store.jersey.client;

import com.globallogic.store.jersey.user.AuthValidator;

import java.util.Scanner;

public class Launcher {

    private static boolean isAuth = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthValidator authValidator = new AuthValidator();

        while (!isAuth) {
            System.out.println("Enter your username:");
            String username = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();

            if (authValidator.validate(username, password)) {
                isAuth = true;
            } else {
                System.out.println("Error in login data or user haven't permissions!");
            }
        }

        System.out.println("You successfully login!");
    }

}
