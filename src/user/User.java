package user;

// ABSTRACTION: This class is abstract. You can't instantiate a 'User', only specific types.
public abstract class User {
    // ENCAPSULATION: Variables are private. Accessed via public getters/setters.
    private String fullName;
    private String username;
    private String password;
    private String role;

    public User(String fullName, String username, String password, String role) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    // Abstract method to demonstrate Polymorphism (Optional but good for marks)
    public abstract String getAccessLevel(); 
    
    // Convert object to a comma-separated string for file saving
    public String toFileString() {
        return role + "," + fullName + "," + username + "," + password;
    }
}