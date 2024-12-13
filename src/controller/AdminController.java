package controller;

import model.Request;
import service.RequestService;

import java.util.List;

public class AdminController {
    private RequestService requestService = new RequestService();

    public void viewAllRequests() {
        List<Request> requests = requestService.getAllRequests();
        System.out.println("Все запросы:");
        for (Request request : requests) {
            System.out.println("ID: " + request.getId() + ", Заголовок: " + request.getTitle() + ", Статус: " + request.getStatus());
        }
    }

    public void deleteRequest(int id) {
        requestService.deleteRequest(id);
        System.out.println("Запрос с ID " + id + " был удален.");
    }

    public void performAdminOperations() {
        System.out.printf("Admin");
    }
}
