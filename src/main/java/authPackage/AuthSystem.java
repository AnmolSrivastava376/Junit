package authPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class AuthSystem {
    private Map<String, User> users = new HashMap<>();

    public int registerUser(User user) {
        if (!isEmailExists(user.getUserEmail())) {
            if (isValidEmail(user.getUserEmail())) {
                if (user.getUserPassword().length() < 5) {
                    System.out.println("Password should be at least 5 characters long");
                    return 3;
                } else {
                    users.put(user.getUserEmail(), new User(user.getUsername(), user.getUserEmail(), user.getUserPassword()));
                    System.out.println("User created successfully");
                    return 0;
                }
            } else {
                System.out.println("Invalid email format. Email should be of type <something>@<something>.com");
                return 1;
            }
        } else {
            System.out.println("Account with this email already exists");
            return 2;
        }
    }


    public int ForgotPassword(String email, String newPass) {
        if (users.containsKey(email) && newPass.length()>=5) {
            users.get(email).setUserPassword(newPass);
            System.out.println("Password reset successful");
            return 0;
        }else if (users.containsKey(email)) {
        	System.out.println("New password is too short");
        	return 1;
        }	
        else {
            System.out.println("No such user found");
            return 2;
        }
    }

    public void printAllUsers() {
        System.out.println("List of all registered users:");
        for (Map.Entry<String, User> entry : users.entrySet()) {
            String email = entry.getKey();
            User user = entry.getValue();
            System.out.println("Email: " + email + ", Username: " + user.getUsername() + ", Password: " + user.getUserPassword());
        }
    }

    public int Login(String email, String password) {
        if (users.containsKey(email) && users.get(email).getUserPassword().equals(password)) {
            System.out.println("Login Successful for user : " + users.get(email).getUsername());
            return 0;
        } else if (users.containsKey(email)) {
            System.out.println("Incorrect Password");
            return 1;
        } else {
            System.out.println("No such user");
            return 2;
        }
    }

    public boolean isEmailExists(String email) {
        return users.containsKey(email);
    }

    public boolean isValidEmail(String email) {
    	String regex = "^[^@]+@[^@]+\\.com$";
        return Pattern.matches(regex, email);
    }
}
