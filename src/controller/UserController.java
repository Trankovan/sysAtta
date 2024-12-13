package controller;

import model.Request;
import model.RequestStatus;
import model.User;
import service.RequestService;
import service.UserService;

import java.util.Date;
import java.util.Scanner;

public class UserController {
    private UserService userService = new UserService();
    private RequestService requestService = new RequestService();

    public void registerUser(User user) {
        userService.registerUser(user);
    }

    public void createRequest(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Создание нового запроса:");
        System.out.print("Введите заголовок: ");
        String title = scanner.nextLine();
        System.out.print("Введите содержание: ");
        String content = scanner.nextLine();

        Request request = new Request();
        request.setTitle(title);
        request.setContent(content);
        request.setUser(user);
        request.setCreateTime(new Date());
        request.setStatus(RequestStatus.Operating);

        requestService.createRequest(request);

        System.out.println("Запрос успешно создан и отправлен администратору.");
    }

    public void performUserOperations(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать, " + user.getFirstName() + "!");
        System.out.println("Вы можете оформить новый запрос.");

        System.out.print("Введите ваше имя: ");
        String userName = scanner.nextLine();
        user.setFirstName(userName);

        System.out.print("Опишите вашу проблему: ");
        String problemDescription = scanner.nextLine();

        Request request = new Request();
        request.setTitle("Запрос от " + userName);
        request.setContent(problemDescription);
        request.setUser(user);
        request.setCreateTime(new Date());
        request.setStatus(RequestStatus.Operating);

        requestService.createRequest(request);

        System.out.println("Ваш запрос успешно создан и отправлен администратору.");
    }
}
