package controller;

import model.Credentials;
import model.User;
import model.UserRole;
import service.AuthService;
import service.UserService;

import java.util.Scanner;

import static model.UserRole.Guest;

public class ConsoleController {
    private AuthService authService = new AuthService();
    private UserController userController = new UserController();
    private AdminController adminController = new AdminController();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать!");
        System.out.println("1: Войти");
        System.out.println("2: Регистрация");
        System.out.println("3: Войти как гость");
        String ch = scanner.nextLine();


        switch (ch){
            case ("1"):{
                System.out.print("Введите логин: ");
                String username = scanner.nextLine();
                System.out.print("Введите пароль: ");
                String password = scanner.nextLine();

                UserRole userRole = authService.authenticate(username, password);

                if (userRole != null) {
                    System.out.println("Авторизация успешна! Ваша роль: " + userRole);
                    if (userRole == UserRole.Admin) {
                        System.out.println("Добро пожаловать, администратор!");
                        adminController.performAdminOperations();
                        break;
                    } else {
                        System.out.println("Добро пожаловать, пользователь!");
                        User user = new User();
                        user.setFirstName(username);
                        userController.performUserOperations(user);
                        break;
                    }
                } else {
                    System.out.println("Ошибка авторизации. Неверный логин или пароль.");
                }

            }
            case ("2"):{
                System.out.println("Введите имя пользователя: ");
                String newUserName = scanner.nextLine();
                System.out.println("Введите пароль: ");
                String newPass = scanner.nextLine();
                Credentials newUserCredentials = new Credentials(newUserName,newPass,Guest);
                authService.registerUser(newUserCredentials);
                System.out.println("Добро пожаловать!");
                User user = new User();
                user.setFirstName(newUserName);
                userController.performUserOperations(user);

                break;
            }

            case  ("3"):{
                System.out.println("Вы вошли как гость");
                User user = new User();
                user.setFirstName("Гость");
                userController.performUserOperations(user);
                break;
            }
        }


    }
}
