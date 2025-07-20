package fr.antoinenebout.vacation_app_api.mapper;

import fr.antoinenebout.vacation_app_api.dto.User.UserCreateDTO;
import fr.antoinenebout.vacation_app_api.dto.User.UserDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.User.UserUpdateDTO;
import fr.antoinenebout.vacation_app_api.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDetailDTO toDetail(User user);

    User toEntity(UserCreateDTO dto);
    User toEntity(UserUpdateDTO dto);

}
