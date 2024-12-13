package controller;

import model.Credentials;
import model.UserRole;
import service.SimpleJsonDatabase;

import java.util.ArrayList;
import java.util.List;

public class UserSetup {
    public static void main(String[] args) {
        SimpleJsonDatabase database = new SimpleJsonDatabase();

        List<Credentials> users = new ArrayList<>();
        users.add(new Credentials("admin", "admin123", UserRole.Admin));
        users.add(new Credentials("user1", "password1", UserRole.Guest));
        users.add(new Credentials("user2", "password2", UserRole.Guest));

        database.writeUsers(users);

        System.out.println("Users have been written to users.txt");
    }
}
