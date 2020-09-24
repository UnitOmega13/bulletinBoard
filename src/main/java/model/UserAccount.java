package model;

import lombok.Getter;
import lombok.Setter;

public class UserAccount {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String roles;

    public UserAccount(Integer id, String email, String password, String FirstName, String LastName, String roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = FirstName;
        this.lastName = LastName;
        this.roles = roles;
    }

}
