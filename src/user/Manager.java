package user;

public class Manager extends User {
    public Manager(String fullName, String username, String password) {
        // Calls the parent (User) constructor
        super(fullName, username, password, "Manager");
    }

    @Override
    public String getAccessLevel() {
        return "Full Access: Can Add Books, Categories, and Accounts.";
    }
}