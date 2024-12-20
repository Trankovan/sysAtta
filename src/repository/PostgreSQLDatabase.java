package repository;

import model.Credentials;
import model.UserRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLDatabase {
    private static final String URL = "jdbc:postgresql://localhost:5433/admindatabase";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Avito-2020";

    public List<Credentials> readUsers() {
        List<Credentials> users = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT username, password, role FROM users")) {

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                UserRole role = UserRole.valueOf(resultSet.getString("role"));
                users.add(new Credentials(username, password, role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void saveUser(Credentials credentials) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, password, role) VALUES (?, ?, ?)");) {
            statement.setString(1, credentials.getUsername());
            statement.setString(2, credentials.getPassword());
            statement.setString(3, credentials.getUserRole().name());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
