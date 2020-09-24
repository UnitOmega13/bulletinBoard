package factory;

import dao.UserDAO;
import dao.impl.UserDAOImpl;

public class UserDAOFactory {

    private static UserDAO instance;

    private UserDAOFactory() {
    }

    public static synchronized UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }
}
