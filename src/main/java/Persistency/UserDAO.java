package Persistency;

import Model.Account;
import static Model.Account.AccountBuilder.anAccount;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UserDAO extends BaseDAO {

    public User findUser(String ml, String pwd) {

        try(Connection con = super.getConnection()){
            String query = "SELECT * FROM \"user\" WHERE email = ? AND password = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,ml);
            stmt.setString(2,pwd);
            ResultSet rs = stmt.executeQuery();


            while(rs.next()) {

                User user = new User(rs.getString("email"), rs.getString("password"), rs.getInt("customer_id"), rs.getString("role"));
                return user;

            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account getUserById(int id) {
        try(Connection con = super.getConnection()) {
            String query = "SELECT * FROM account WHERE customer_id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, Integer.toString(id));
            ResultSet rs = stmt.executeQuery();
            boolean a= rs.getInt("is_active") != 0;
            while(rs.next()) {
                Account account = anAccount()
                        .setAccount_id(rs.getInt("account_id"))
                        .setCustomer_id(rs.getInt("customer_id"))
                        .setBilling_address(rs.getString("billing_address"))
                        .setIs_active(a)
                        .setOpening_date(rs.getDate("opening_date"))
                        .build();
                return account;
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean registerUser(String postcode, int housenumber, String name, String email, String password, int phonenumber) {
        int custid;
        try(Connection con = super.getConnection()) {
            String query1 = "INSERT INTO customer (customer_name, email, phonenumber) VALUES (?, ?, ?)";
            PreparedStatement stmt1 = con.prepareStatement(query1);
            stmt1.setString(1, name);
            stmt1.setString(2, email);
            stmt1.setString(3, Integer.toString(phonenumber));
            if(stmt1.executeUpdate() == 1) {
                String query2 = "SELECT customer_id FROM customer WHERE email = ?";
                PreparedStatement stmt2 = con.prepareStatement(query2);
                stmt2.setString(1, email);
                ResultSet rs = stmt2.executeQuery();
                rs.next();
                custid = rs.getInt("customer_id");

                String query = "INSERT INTO \"user\"(email, password, customer_id, role) VALUES (?, ?, ?, 'user')";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, email);
                stmt.setString(2, password);
                stmt.setInt(3, custid);
                if(stmt.executeUpdate() == 1) {
                    String query3 = "INSERT INTO account (customer_id, billing_address, is_active, opening_date) VALUES (?, ?, 1, CURRENT_DATE())";
                    PreparedStatement stmt3 = con.prepareStatement(query3);
                    stmt3.setInt(1, custid);
                    stmt3.setString(2, postcode + " " + Integer.toString(housenumber));
                    if(stmt3.executeUpdate() == 1) {
                        return true;
                    }
                }
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
