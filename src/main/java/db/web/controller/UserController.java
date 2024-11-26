package db.web.controller;


import db.config.DBConfig;
import db.model.User;
import db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    public UserService getUserService() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
        return context.getBean(UserService.class);
    }

    @GetMapping(value = "/")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("allUsers", getUserService().getUsers());
        return "index";
    }

    @GetMapping(value = "/get_user/{id}")
    public String getUserById(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", getUserService().getUser(id));
        return "updateUser";
    }

    @GetMapping(value = "/get_user_form")
    public String getUserForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @GetMapping(value = "/delete_user/{id}")
    public String deleteUser(@PathVariable int id) {
        getUserService().deleteUser(id);
        return "redirect:/";
    }

    @PostMapping(value = "/add_user")
    public String addUser(@ModelAttribute("user") User user) {
        getUserService().addUser(user);
        return "redirect:/";
    }

    @PostMapping(value = "/update_user")
    public String updateUser(@ModelAttribute("user") User user) {
        getUserService().updateUser(user);
        return "redirect:/";
    }
}