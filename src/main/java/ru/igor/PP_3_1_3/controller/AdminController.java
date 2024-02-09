package ru.igor.PP_3_1_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.igor.PP_3_1_3.model.User;
import ru.igor.PP_3_1_3.services.RoleServices;
import ru.igor.PP_3_1_3.services.UserServices;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserServices userServices;
    private final RoleServices roleServices;

    @Autowired
    public AdminController(UserServices userServices, RoleServices roleServices) {
        this.userServices = userServices;
        this.roleServices = roleServices;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> userList = userServices.findAll();
        model.addAttribute("users", userList);
        return "admin/all-users";
    }

    //ТУТ ДОЛЖНА БЫТЬ ВАЛИДАЦИЯ
    @GetMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        User user = userServices.findOne(id);
        model.addAttribute("user", user);
        return "admin/update-user";
    }

    @PostMapping("/update")
    public String updateNewUser(@ModelAttribute("user") User user) {
        userServices.save(user);
        return "redirect:/admin";
    }


    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userServices.delete(id);
        return "redirect:/admin";
    }
}
