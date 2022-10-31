package liga.medical.personservice.core.web;

import liga.medical.personservice.core.web.api.UserService;
import liga.medical.personservice.core.web.api.UserValidator;
import liga.medical.personservice.core.model.User;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final UserValidator userValidator;

    private final UserService userService;

    public RegistrationController(UserValidator userValidator, UserService userService) {
        this.userValidator = userValidator;
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

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
}