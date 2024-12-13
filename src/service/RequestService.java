package service;
import model.Request;
import repository.RequestRepository;

import java.util.List;

public class RequestService {
    private RequestRepository requestRepository = new RequestRepository();

    public void createRequest(Request request) {
        requestRepository.saveRequest(request);
    }

    public List<Request> getAllRequests() {
        return requestRepository.getAllRequests();
    }

    public void deleteRequest(int id) {
        requestRepository.deleteRequest(id);
    }
}
