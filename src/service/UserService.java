package service;

import user.Cashier;
import user.Manager;
import user.User;
import java.util.List;

public class UserService {
    private static final String FILE_NAME = "users.txt";

    // Save a user object to the file
    public static void saveUser(User user) {
        FileHandler.writeLineToFile(FILE_NAME, user.toFileString());
    }

    // Authenticate user for LoginForm.java
    public static User authenticate(String username, String password) {
        List<String> lines = FileHandler.readLinesFromFile(FILE_NAME);
        
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 4) {
                String fileRole = parts[0];
                String fileName = parts[1];
                String fileUser = parts[2];
                String filePass = parts[3];

                if (fileUser.equals(username) && filePass.equals(password)) {
                    // POLYMORPHISM: Return the specific type based on the file data
                    if (fileRole.equals("Manager")) {
                        return new Manager(fileName, fileUser, filePass);
                    } else if (fileRole.equals("Cashier")) {
                        return new Cashier(fileName, fileUser, filePass);
                    }
                }
            }
        }
        return null; // Login failed
    }

    public static boolean usernameExists(String username) {
        List<String> lines = FileHandler.readLinesFromFile(FILE_NAME);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 4) {
                String fileUser = parts[2];
                if (fileUser.equalsIgnoreCase(username)) {
                    return true;
                }
            }
        }
        return false;
    }
}