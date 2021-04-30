package main.model.security;

import java.util.HashMap;
import java.util.Map;

public class Authenticate {
    private static final Map<String, String> USERS = new HashMap<String, String>();
    static {
        USERS.put("conner-s", "password");
        USERS.put("jason-n", "pass");
        USERS.put("damian-p", "hello");
        USERS.put("varalika-a", "bro");
        USERS.put("hunter-d", "theguy");
    }

    public static boolean validate(String usr, String password) {
        String validUser = USERS.get(usr);
        return validUser != null && validUser.equals(password);
    }
}
