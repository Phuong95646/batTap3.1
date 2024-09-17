package com.example.batTap31;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NguoidungController {

    @Autowired
    UserService userService;

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new UserDemo());
        return "addUser";
    }

    @PostMapping("/addUser")
    public void saveUser(@ModelAttribute("user") UserDemo user) {
        System.out.println("FirstName: " + user.getFirstName());
        System.out.println("LastName: " + user.getLastName());

        userService.saveOrUpdateUser(user);

    }

    @GetMapping("/home")
    public String home(Model model) {
        Iterable<UserDemo> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "home";
    }
}
