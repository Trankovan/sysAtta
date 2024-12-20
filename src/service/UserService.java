package service;

import model.Credentials;
import repository.UserRepository;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public void registerUser(Credentials user) {
        userRepository.saveUser(user);
    }

    public void findUserByUsername(String username){

    }
}
