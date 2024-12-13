package service;

import model.UserMachine;
import repository.UserMachineRepository;

public class UserMachineService {
    private UserMachineRepository userMachineRepository = new UserMachineRepository();

    public void registerUserMachine(UserMachine userMachine) {
        userMachineRepository.saveUserMachine(userMachine);
    }
}