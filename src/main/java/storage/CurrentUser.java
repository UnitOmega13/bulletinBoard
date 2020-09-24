package storage;

import lombok.Getter;
import lombok.Setter;

public class CurrentUser {

    @Getter
    @Setter
    private static Integer id;

    @Getter
    @Setter
    private static String email;

    @Getter
    @Setter
    private static String password;

    @Getter
    @Setter
    private static String firstName;

    @Getter
    @Setter
    private static String lastName;

    @Getter
    @Setter
    private static boolean exist;
}