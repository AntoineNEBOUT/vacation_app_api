package fr.antoinenebout.vacation_app_api.mapper;

import fr.antoinenebout.vacation_app_api.dto.VacationDTO;
import fr.antoinenebout.vacation_app_api.model.Vacation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VacationMapper {

    @Mapping(source = "user.id", target = "user_id")
    @Mapping(source = "vacationType.id", target = "vacation_type_id")
    @Mapping(source = "state.id", target = "state_id")
    VacationDTO toDTO(Vacation vacation);


    @Mapping(source = "user_id", target = "user.id")
    @Mapping(source = "vacation_type_id", target = "vacationType.id")
    @Mapping(source = "state_id", target = "state.id")
    Vacation toEntity(VacationDTO dto);

}
