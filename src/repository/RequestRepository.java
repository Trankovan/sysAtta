package repository;

import model.Request;
import java.util.ArrayList;
import java.util.List;

public class RequestRepository {
    private List<Request> requests = new ArrayList<>();

    public void saveRequest(Request request) {
        requests.add(request);
    }

    public List<Request> getAllRequests() {
        return requests;
    }

    public void deleteRequest(int id) {
        requests.removeIf(request -> request.getId() == id);
    }
}
