package service;

import model.Credentials;
import model.UserRole;
import repository.PostgreSQLDatabase;

public class AuthService {
    private PostgreSQLDatabase database = new PostgreSQLDatabase();

    public UserRole authenticate(String username, String password) {
        return database.readUsers().stream()
                .filter(credentials -> credentials.getUsername().equals(username) && credentials.getPassword().equals(password))
                .map(Credentials::getUserRole)
                .findFirst()
                .orElse(null);
    }


    public boolean authenticateAdmin(String password) {
        // Получаем всех пользователей из базы данных
        return database.readUsers().stream()
                // Фильтруем только пользователей с ролью ADMIN
                .filter(credentials -> credentials.getUserRole() == UserRole.Admin)
                // Проверяем, совпадает ли переданный пароль с паролем администратора
                .anyMatch(credentials -> credentials.getPassword().equals(password));
    }
    public void registerUser(Credentials credentials) {
        database.saveUser(credentials);
    }


}