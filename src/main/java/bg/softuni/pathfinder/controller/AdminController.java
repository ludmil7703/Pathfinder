package bg.softuni.pathfinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    private static final String ADMIN = "admin";

    @GetMapping("/admin")
    public ModelAndView admin(){
        return new ModelAndView("admin");
    }
}
