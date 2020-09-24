package config;

import java.util.*;

public class SecurityConfig {

    public static final String USER_ROLE = "USER";

    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

    static {
        init();
    }

    private static void init() {
        List<String> urlPatternsForUser = new ArrayList<String>();

        urlPatternsForUser.add("/*");

        mapConfig.put(USER_ROLE, urlPatternsForUser);

    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
}
