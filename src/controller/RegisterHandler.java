package controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

public class RegisterHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())) {
            // Обработка данных регистрации
            // Сохранение пользователя в базе данных
        } else {
            // Возвращаем HTML-страницу регистрации
            String response = "<html><body><form method='POST' action='/register'>" +
                    "Username: <input type='text' name='username'><br>" +
                    "Password: <input type='password' name='password'><br>" +
                    "Role: <select name='role'><option value='Guest'>Guest</option><option value='Admin'>Admin</option></select><br>" +
                    "<input type='submit' value='Register'></form></body></html>";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
