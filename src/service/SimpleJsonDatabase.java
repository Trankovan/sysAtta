package service;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import model.Credentials;
import model.UserRole;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleJsonDatabase {
    private static final String FILE_PATH = "service/users.txt";

    public void writeUsers(List<Credentials> users) {
        try {
            File file = new File(FILE_PATH);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (Credentials user : users) {
                    writer.write(user.getUsername() + "," + user.getPassword() + "," + user.getUserRole());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Credentials> readUsers() {
        List<Credentials> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String username = parts[0];
                    String password = parts[1];
                    UserRole role = UserRole.valueOf(parts[2]);
                    users.add(new Credentials(username, password, role));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
