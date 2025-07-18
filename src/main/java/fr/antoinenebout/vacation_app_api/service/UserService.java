package fr.antoinenebout.vacation_app_api.service;

import fr.antoinenebout.vacation_app_api.dto.UserDTO;
import fr.antoinenebout.vacation_app_api.mapper.UserMapper;
import fr.antoinenebout.vacation_app_api.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Optional<UserDTO> getUser(final Long id) {
        return userRepository.findById(id).map(userMapper::toDTO);
    }

    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream().map(userMapper::toDTO).toList();
    }

}
