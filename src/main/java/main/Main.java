package main;

import java.util.Scanner;
import authPackage.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        AuthSystem authSystem = new AuthSystem();

        while(true) {
            authSystem.printAllUsers();
            System.out.println("Choose:\n1. Login\n2. Register\n3. Forgot Password\n4. Exit");
            String choice = sc.nextLine();

            if(choice.equals("1")) {
                System.out.println("Enter email:");
                String email = sc.nextLine();
                System.out.println("Enter password:");
                String pass = sc.nextLine();
                authSystem.Login(email, pass);
            }
            else if(choice.equals("2")) {
                System.out.println("Enter username:");
                String username = sc.nextLine();
                System.out.println("Enter email:");
                String email = sc.nextLine();
                System.out.println("Enter password:");
                String pass = sc.nextLine();
                User newUser = new User(username, email, pass);
                authSystem.registerUser(newUser);
            }
            else if(choice.equals("3")) {
                System.out.println("Enter email:");
                String email = sc.nextLine();
                System.out.println("Enter new password:");
                String newPass = sc.nextLine();
                authSystem.ForgotPassword(email, newPass);
            }
            else if(choice.equals("4")) {
                System.out.println("Exit Successful");
                break;
            }
            else {
                System.out.println("Invalid Input");
            }
        }
        sc.close();
    }
}
