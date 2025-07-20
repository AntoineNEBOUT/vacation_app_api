package fr.antoinenebout.vacation_app_api.service;

import fr.antoinenebout.vacation_app_api.dto.User.UserCreateDTO;
import fr.antoinenebout.vacation_app_api.dto.User.UserDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.User.UserUpdateDTO;
import fr.antoinenebout.vacation_app_api.mapper.UserMapper;
import fr.antoinenebout.vacation_app_api.model.User;
import fr.antoinenebout.vacation_app_api.repository.UserRepository;
import fr.antoinenebout.vacation_app_api.util.AuthUtil;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Data
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthUtil authUtil;

    public UserService(
            UserRepository userRepository,
            UserMapper userMapper,
            PasswordEncoder passwordEncoder,
            AuthUtil authUtil) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.authUtil = authUtil;
    }

    public Optional<UserDetailDTO> getUser(final Long id) {
        return userRepository.findById(id).map(userMapper::toDetail);
    }

    public List<UserDetailDTO> getUsers() {
        return userRepository.findAll().stream().map(userMapper::toDetail).toList();
    }

    public UserDetailDTO createUser(UserCreateDTO dto) {
        if(userRepository.existsByEmail(dto.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already used");
        }

        User user_entity = userMapper.toEntity(dto);
        user_entity.setPassword(passwordEncoder.encode(dto.getPassword()));

        User saved = userRepository.save(user_entity);

        return userMapper.toDetail(saved);
    }

    public UserDetailDTO patchUser(final Long id, UserUpdateDTO dto) {
        User user_entity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        if(!Objects.equals(user_entity.getId(), authUtil.getCurrentUserId())) {
            throw new AccessDeniedException("You cannot modify this resource.");
        }

        if(dto.getFirst_name() != null) {
            user_entity.setFirst_name(dto.getFirst_name());
        }

        if(dto.getLast_name() != null) {
            user_entity.setLast_name(dto.getLast_name());
        }

        if(dto.getEmail() != null) {
            user_entity.setEmail(dto.getEmail());
        }

        if(dto.getCompany_name() != null) {
            user_entity.setEmail(dto.getEmail());
        }

        User updated = userRepository.save(user_entity);

        return userMapper.toDetail(updated);
    }

}
