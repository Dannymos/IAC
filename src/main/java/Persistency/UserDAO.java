package Persistency;

import Model.Account;
import static Model.Account.AccountBuilder.anAccount;
import Model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO extends BaseDAO {

    public User findUser(String ml, String pwd) {
        try(Connection con = super.getConnection()){
            String query = "SELECT * FROM user where email =" + ml + " AND password = " + pwd;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()) {
                rs.beforeFirst();
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
            String query = "SELECT * FROM account WHERE customer_id = " + id;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            boolean a= rs.getInt("is_active") != 0;
            if(rs.next()) {
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
}
