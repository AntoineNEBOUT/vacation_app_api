package fr.antoinenebout.vacation_app_api.service;

import fr.antoinenebout.vacation_app_api.dto.UserDTO;
import fr.antoinenebout.vacation_app_api.mapper.UserMapper;
import fr.antoinenebout.vacation_app_api.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public Optional<UserDTO> getUser(final Long id) {
        return userRepository.findById(id).map(userMapper::toDTO);
    }

    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

}
