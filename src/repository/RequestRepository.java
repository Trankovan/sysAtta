package repository;

import model.Request;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/admindatabase";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    public void saveRequest(Request request) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO requests (title, content) VALUES (?, ?)");) {
            statement.setString(1, request.getTitle());
            statement.setString(2, request.getContent());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Request> getAllRequests() {
        List<Request> requests = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT id, title, content FROM requests")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                requests.add(new Request(id, title, content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    public void updateRequestStatus(int id, String status) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("UPDATE requests SET status = ? WHERE id = ?")) {
            statement.setString(1, status);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
