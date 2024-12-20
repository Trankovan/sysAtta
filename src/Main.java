import controller.WebServerController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        WebServerController adminToolController = new WebServerController();
        try {
            adminToolController.startServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
