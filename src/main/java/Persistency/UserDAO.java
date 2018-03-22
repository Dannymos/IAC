package Persistency;

import Model.Account;
import static Model.Account.AccountBuilder.anAccount;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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

    public boolean registerUser(String email, String password) {
        try(Connection con = super.getConnection()) {
            String query = "INSERT INTO \"user\"(email, password, role) VALUES (?, ?, \"user\")";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            if(stmt.executeUpdate(query) == 1) {
                return true;
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
