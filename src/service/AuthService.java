package service;
import model.Credentials;
import model.UserRole;

import java.util.List;

public class AuthService {
    private SimpleJsonDatabase jsonDatabase = new SimpleJsonDatabase();

    public UserRole authenticate(String username, String password) {
        List<Credentials> credentialsList = jsonDatabase.readUsers();
        for (Credentials credentials : credentialsList) {
            if (credentials.getUsername().equals(username) && credentials.getPassword().equals(password)) {
                return credentials.getUserRole();
            }
        }
        return null;
    }

    public void registerUser(Credentials credentials) {
        List<Credentials> credentialsList = jsonDatabase.readUsers();
        credentialsList.add(credentials);
        jsonDatabase.writeUsers(credentialsList);
    }
}
