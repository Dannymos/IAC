package Controller;

import Model.Account;
import Persistency.UserDAO;

public class UserController {

    UserDAO dao = new UserDAO();

    public Account getUserById(int id) {
        return dao.getUserById(id);
    }
}
