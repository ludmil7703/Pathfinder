package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.Dto.UserLoginDTO;
import bg.softuni.pathfinder.model.Dto.UserRegisterDTO;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.AuthenticationService;
import bg.softuni.pathfinder.service.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final LoggedUser loggedUser;


    public AuthenticationServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }


    @Override
    public void register(UserRegisterDTO userRegisterDTO) {

        User user = modelMapper.map(userRegisterDTO, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        userRepository.save(user);

    }

    @Override
    public boolean login(UserLoginDTO userLoginDTO) {
        User user = userRepository.findByUsername(userLoginDTO.getUsername());

        if(user == null){
            throw new IllegalArgumentException("User not found");
        }

        boolean passwordMatch =  passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword());
        if (!passwordMatch){
            throw new IllegalArgumentException("Wrong password");
        }

        loggedUser.setUsername(user.getUsername());
        loggedUser.setEmail(user.getEmail());
        loggedUser.setFullName(user.getFullName());
        loggedUser.setLogged(true);

        return true;
    }

    @Override
    public void logout() {
        loggedUser.reset();
    }
}
