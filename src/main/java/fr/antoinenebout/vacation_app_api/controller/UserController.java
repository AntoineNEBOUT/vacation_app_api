package fr.antoinenebout.vacation_app_api.controller;

import fr.antoinenebout.vacation_app_api.dto.UserDTO;
import fr.antoinenebout.vacation_app_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") final Long id) {
        Optional<UserDTO> user = userService.getUser(id);
        return user.orElse(null);
    }

    @GetMapping("/")
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

}
