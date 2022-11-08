package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.model.User;
import liga.medical.personservice.core.api.UserService;
import liga.medical.personservice.core.api.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Api(value = "API user auth")
public class UserController {

    private final UserValidator userValidator;

    private final UserService userService;

    public UserController(UserValidator userValidator, UserService userService) {
        this.userValidator = userValidator;
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @ApiOperation(value = "get registration page")
    @PostMapping("/registration")
    public String processRegistrationForm(@ModelAttribute User user, Model model) {
        if (!userValidator.isUserValid(user)) {
            model.addAttribute("error", "Логин и пароль должны быть больше 8 символов");
            return "registration";
        }
        if (userValidator.isUserExist(user)) {
            model.addAttribute("error", "Пользователь с таким логином уже существует!");
            return "registration";
        }
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginForm(Model model) {
        return "login";
    }

    @ApiOperation(value = "get login page")
    @PostMapping("/login")
    public String processLoginForm(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }

        //System.out.println("login get mapping " + userService.findByUsername("username").getPassword());
        return "login";
    }

    @ApiOperation(value = "get main page")
    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    @ApiOperation(value = "get admin page")
    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin-page";
    }

    @ApiOperation(value = "get user page")
    @GetMapping("/user")
    public String getUserPage() {
        return "user-page";
    }
}