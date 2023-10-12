package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.Dto.UserLoginDTO;
import bg.softuni.pathfinder.model.Dto.UserRegisterDTO;

public interface AuthenticationService {

    void register(UserRegisterDTO userRegisterDTO);


    boolean login(UserLoginDTO userLoginDTO);

    void logout();
}
