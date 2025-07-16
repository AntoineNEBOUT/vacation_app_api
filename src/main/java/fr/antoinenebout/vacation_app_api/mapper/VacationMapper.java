package fr.antoinenebout.vacation_app_api.mapper;

import fr.antoinenebout.vacation_app_api.dto.VacationDTO;
import fr.antoinenebout.vacation_app_api.model.Vacation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface VacationMapper {

    @Mapping(source = "user", target = "user")
    @Mapping(source = "vacationType", target = "vacation_type")
    VacationDTO toDTO(Vacation vacation);

    @Mapping(source = "user.id", target = "user.id")
    @Mapping(source = "vacation_type", target = "vacationType")
    Vacation toEntity(VacationDTO dto);

}
