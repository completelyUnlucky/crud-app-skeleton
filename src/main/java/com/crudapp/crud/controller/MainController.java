package com.crudapp.crud.controller;

import com.crudapp.crud.model.User;
import com.crudapp.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String root(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "root";
    }
    @GetMapping("/user-create")
    public String createUserPage(User user) {
        return "user-create";
    }
    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/user-update/{id}")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }
    @PostMapping("/user-update")
    public String editUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
}
