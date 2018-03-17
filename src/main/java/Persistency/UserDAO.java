package Persistency;

import Model.Account;
import Model.Account.AccountBuilder.anAccount;
import Model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO extends BaseDAO {

    public User findUser(String ml, String pwd) {
        try(Connection con = super.getConnection()){
            String query = "SELECT * FROM user" + ml + " AND password = " + pwd;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()) {
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

            if(rs.next()) {
                Account account = anAccount()
                        .setAccount_id(rs.getInt("account_id"))
                        .setCustomer_id(rs.getInt("account_id"))
                        .setBilling_address()
                        .setIs_active(rs.getInt("account_id"))
                        .setOpeningDate(rs.getDate("account_id"))
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
