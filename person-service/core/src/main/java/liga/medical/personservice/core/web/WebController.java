package liga.medical.personservice.core.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin-page";
    }

    @GetMapping("/user")
    public String getUserPage() {
        return "user-page";
    }
}