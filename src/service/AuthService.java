package service;

import model.Credentials;
import model.UserRole;

import java.util.List;

public class AuthService {
    private PostgreSQLDatabase database = new PostgreSQLDatabase();

    public UserRole authenticate(String username, String password) {
        List<Credentials> credentialsList = database.readUsers();
        for (Credentials credentials : credentialsList) {
            if (credentials.getUsername().equals(username) && credentials.getPassword().equals(password)) {
                return credentials.getUserRole();
            }
        }
        return null;
    }

    public void registerUser(Credentials credentials) {
        List<Credentials> credentialsList = database.readUsers();
        credentialsList.add(credentials);
        database.writeUsers(credentialsList);
    }
}
