package dao;

import model.UserAccount;

public interface UserDAO {

    void saveUser(UserAccount userAccount);

    void updateUser(UserAccount user, UserAccount newUser);

    UserAccount getUserById(Long userId);

    boolean validate(String email, String password);

    UserAccount getUserByEmail(String email);

}
