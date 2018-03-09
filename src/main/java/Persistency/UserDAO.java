package Persistency;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO extends BaseDAO {

    public String findUser(String ml, String pwd) {
        try(Connection con = super.getConnection()){
            String query = "SELECT * FROM " + ml + " AND password = " + pwd;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next()) {
                return rs.getString("role");
            }
            return null;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
