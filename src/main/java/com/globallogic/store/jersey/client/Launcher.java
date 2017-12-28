package com.globallogic.store.jersey.client;

import com.globallogic.store.jersey.common.Command;
import com.globallogic.store.jersey.common.Executor;
import com.globallogic.store.jersey.common.Type;
import com.globallogic.store.jersey.model.User;
import com.globallogic.store.jersey.common.AuthValidator;

import java.util.Scanner;

public class Launcher {

    private static boolean isAuth = false;
    private static boolean isClose = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthValidator authValidator = new AuthValidator();

        /*while (!isAuth) {
            System.out.println("Enter your username:");
            String username = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();

            if (authValidator.validate(username, password)) {
                isAuth = true;
            } else {
                System.out.println("Error in login data or user haven't permissions!");
            }
        }*/

        System.out.println("----------------------------------------");
        System.out.println("You successfully login!");
        System.out.println("Please insert your request in next form:");
        System.out.println("[type] [command]");
        System.out.println("----------------------------------------");

        while (!isClose) {
            String request = scanner.nextLine();

            if (request.equals("exit")) {
                isClose = true;
                System.out.println("Good bye!");
            } else {
                execute(request);
            }
        }
    }

    private static void execute(String request) {
        String[] parts = request.split(" ");
        Type type = Type.getByKey(parts[0]);
        Command command = Command.getByKey(parts[1]);
        String key = parts.length == 3 ? parts[2] : null;

        switch (type) {
            case USERS:
                Executor<User> executor = new Executor<>(User.class, User[].class, Type.USERS);
                System.out.println(User.header());
                System.out.println(User.separator());
                for (User user : executor.execute(command, key)) {
                    System.out.println(user);
                    System.out.println(User.separator());
                }
                break;
            default:
                System.out.println("Unknown request");
        }
    }
}
