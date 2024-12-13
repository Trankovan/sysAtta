package service;

import model.User;
import repository.UserRepository;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public void registerUser(User user) {
        userRepository.saveUser(user);
    }

    public void findUserByUsername(String username){

    }
}
