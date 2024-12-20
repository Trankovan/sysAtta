package controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

public class AdminHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Проверка роли пользователя
        // Если админ, то отображаем таблицу с запросами
        String response = "<html><body><h1>Admin Page</h1><table border='1'><tr><th>ID</th><th>Title</th><th>Content</th></tr>";
        // Добавить строки таблицы с данными из базы
        response += "</table></body></html>";
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
