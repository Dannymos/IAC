package Model;

public class User {

    private String email;
    private String password;
    private int customer_id;
    private String role;

    public User(String ml, String pwd, int cust_id, String rl) {
        this.email = ml;
        this.password = pwd;
        this.customer_id = cust_id;
        this.role = rl;
    }

    public User() {
        this.email = "";
        this.password = "";
        this.role = "none";
    }

    public String getRole() {
        return role;
    }

    public int getCustomerId() {
        return customer_id;
    }
}
