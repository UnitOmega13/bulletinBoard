package dao.impl;

import config.SecurityConfig;
import dao.UserDAO;
import model.UserAccount;
import org.apache.commons.codec.digest.DigestUtils;
import storage.CurrentUser;
import storage.DataBase;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public void saveUser(UserAccount userAccount) {
        DataBase.users.add(userAccount);
    }

    @Override
    public void updateUser(UserAccount user, UserAccount newUser) {
        DataBase.users.remove(user);
        DataBase.users.add(newUser);
    }

    @Override
    public UserAccount getUserById(Long userId) {
        return DataBase.users.stream()
                .filter(x -> userId.equals(x.getId()))
                .findAny()
                .orElse(null);
    }

    @Override
    public boolean validate(String email, String password) {
        List<UserAccount> result = new ArrayList<>();
        String encryptedPassword = DigestUtils.sha256Hex(password);
        DataBase.users.stream()
                .filter(x -> email.equals(x.getEmail()))
                .forEach(result::add);
        return result.stream()
                .anyMatch(x -> encryptedPassword.equals(x.getEmail()));
    }

    @Override
    public UserAccount getUserByEmail(String email) {
        UserAccount userAccount = new UserAccount(CurrentUser.getId(), CurrentUser.getEmail(), CurrentUser.getPassword(),
                CurrentUser.getFirstName(), CurrentUser.getLastName(), SecurityConfig.USER_ROLE);
        return DataBase.users.stream()
                .filter(x -> email.equals(x.getEmail()))
                .findAny()
                .orElse(userAccount);
    }
}
