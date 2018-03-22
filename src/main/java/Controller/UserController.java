package Controller;

import Model.Account;
import Persistency.UserDAO;

public class UserController {

    UserDAO dao = new UserDAO();

    public Account getUserById(int id) {
        return dao.getUserById(id);
    }

    public boolean registerUser(String name, String email, String password, int phonenumber) { return dao.registerUser(name, email, password, phonenumber); }
}
