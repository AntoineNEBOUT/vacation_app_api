package fr.antoinenebout.vacation_app_api.mapper;

import fr.antoinenebout.vacation_app_api.dto.UserDTO;
import fr.antoinenebout.vacation_app_api.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO dto);
}
