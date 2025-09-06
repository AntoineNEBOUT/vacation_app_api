package fr.antoinenebout.vacation_app_api.controller;

import fr.antoinenebout.vacation_app_api.dto.User.UserCreateDTO;
import fr.antoinenebout.vacation_app_api.dto.User.UserDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.User.UserUpdateDTO;
import fr.antoinenebout.vacation_app_api.service.UserService;
import fr.antoinenebout.vacation_app_api.util.AuthUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final AuthUtil authUtil;

    public UserController(
            UserService userService,
            AuthUtil authUtil) {
        this.userService = userService;
        this.authUtil = authUtil;
    }

    @GetMapping("")
    public UserDetailDTO getUser() {
        Optional<UserDetailDTO> user = userService.getUser(authUtil.getCurrentUserId());
        return user.orElse(null);
    }

    @PostMapping("/register")
    public UserDetailDTO register(@RequestBody UserCreateDTO dto) {
        return userService.createUser(dto);
    }

    @PatchMapping("")
    public UserDetailDTO patch(@RequestBody UserUpdateDTO dto) {
        return userService.patchUser(authUtil.getCurrentUserId(), dto);
    }

}
