package controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

public class LoginHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())) {
            // Обработка данных входа
            // Аутентификация пользователя
        } else {
            // Возвращаем HTML-страницу входа
            String response = "<html><body><form method='POST' action='/login'>" +
                    "Username: <input type='text' name='username'><br>" +
                    "Password: <input type='password' name='password'><br>" +
                    "<input type='submit' value='Login'></form></body></html>";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
