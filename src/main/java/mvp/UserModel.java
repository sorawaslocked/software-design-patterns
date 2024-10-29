package mvp;

import java.util.HashMap;
import java.util.Map;

public class UserModel {
    private final Map<String, String> users;

    public UserModel() {
        users = new HashMap<>();
        initUserData();
    }

    private void initUserData() {
        users.put("admin", "s3cur3p4ssw0rd");
        users.put("user", "12345678");
    }

    public boolean authenticate(String username, String password) {
        if (!users.containsKey(username)) {
            return false;
        }

        if (!users.get(username).equals(password)) {
            return false;
        }

        return true;
    }
}
