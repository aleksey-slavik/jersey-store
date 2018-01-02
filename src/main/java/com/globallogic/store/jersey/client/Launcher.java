package com.globallogic.store.jersey.client;

import com.globallogic.store.jersey.common.*;
import com.globallogic.store.jersey.exception.*;
import com.globallogic.store.jersey.executor.*;
import com.globallogic.store.jersey.model.*;

import java.util.Scanner;

public class Launcher {

    private static boolean isAuth = false;
    private static boolean isClose = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthValidator authValidator = new AuthValidator();

        while (!isAuth) {
            System.out.println("Enter your username:");
            String username = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();

            try {
                authValidator.validate(username, password);
                isAuth = true;
            } catch (AuthException e) {
                System.out.println("Error in login data or user haven't permissions!");
            }
        }

        System.out.println("----------------------------------------");
        System.out.println("You successfully login!");
        System.out.println("Please insert your request in next form:");
        System.out.println("type command [parameter]");
        System.out.println("----------------------------------------");

        while (!isClose) {
            String request = scanner.nextLine();

            if (request.equals("exit")) {
                isClose = true;
                System.out.println("Good bye!");
            } else {
                try {
                    execute(request);
                } catch (IllegalTypeException e) {
                    System.out.println("Unknown request type!");
                } catch (IllegalCommandException e) {
                    System.out.println("Unknown request command!");
                } catch (WrongRequestException e) {
                    System.out.println("Request does not match the pattern!");
                } catch (EmptyResponseException e) {
                    System.out.println("Empty response!");
                }
            }
        }
    }

    private static void execute(String request) throws IllegalTypeException, IllegalCommandException, WrongRequestException, EmptyResponseException {
        String[] parts = request.split(" ");

        if (parts.length < 2 || parts.length > 3) {
            throw new WrongRequestException();
        }

        Type type = Type.getByKey(parts[0]);
        Command command = Command.getByKey(parts[1]);
        String key = parts.length == 3 ? parts[2] : null;

        switch (type) {
            case USERS:
                new ExecuteCommandTemplate<User>().execute(command, key, new UserExecutor());
                break;
            case PRODUCTS:
                new ExecuteCommandTemplate<Product>().execute(command, key, new ProductExecutor());
                break;
            case ORDERS:
                new ExecuteCommandTemplate<Order>().execute(command, key, new OrderExecutor());
        }
    }
}
