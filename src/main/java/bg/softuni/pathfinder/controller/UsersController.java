package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.model.Dto.UserLoginDTO;
import bg.softuni.pathfinder.model.Dto.UserRegisterDTO;
import bg.softuni.pathfinder.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final AuthenticationService authenticationService;

    public UsersController(AuthenticationService userService) {
        this.authenticationService = userService;
    }
    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(UserLoginDTO userLoginDTO) {
        boolean isLogged = authenticationService.login(userLoginDTO);

        if(isLogged){
            return new ModelAndView("redirect:/");
        }


        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }
    @PostMapping("/register")
    public ModelAndView register(UserRegisterDTO userRegisterDTO) {
        authenticationService.register(userRegisterDTO);
        return new ModelAndView("redirect:login");
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        authenticationService.logout();
        return new ModelAndView("redirect:/");
    }
}
