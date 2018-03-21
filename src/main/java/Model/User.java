package Model;

public class User {

    private String email;
    private String password;
    private int customer_id;
    private String role;

    public User(String email, String password, int customer_id, String role) {
        this.email = email;
        this.password = password;
        this.customer_id = customer_id;
        this.role = role;
    }

    public User() {
        this.email = null;
        this.password = null;
        this.role = null;
    }

    public String getRole() {
        return this.role;
    }

    public int getCustomerId() {
        return this.customer_id;
    }
}
