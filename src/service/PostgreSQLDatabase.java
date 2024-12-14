package service;

import model.Credentials;
import model.UserRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLDatabase {
    private static final String URL = "jdbc:postgresql://localhost:5432/yourdatabase";
    private static final String USER = "yourusername";
    private static final String PASSWORD = "yourpassword";

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

    public void writeUsers(List<Credentials> users) {
        // Implement logic to write users to PostgreSQL
    }
}
