package user;

public class Cashier extends User {
    public Cashier(String fullName, String username, String password) {
        super(fullName, username, password, "Cashier");
    }

    @Override
    public String getAccessLevel() {
        return "Limited Access: Can only view and search inventory.";
    }
}