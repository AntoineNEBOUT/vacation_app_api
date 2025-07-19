package fr.antoinenebout.vacation_app_api.mapper;

import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationCreateDTO;
import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationSummaryDTO;
import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationUpdateDTO;
import fr.antoinenebout.vacation_app_api.model.Vacation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, VacationMapper.class})
public interface VacationMapper {

    @Mapping(source = "user.email", target = "username")
    @Mapping(source = "vacationType.vacation_name", target = "type")
    @Mapping(source = "state.state_name", target = "state_name")
    VacationSummaryDTO toSummary(Vacation vacation);

    VacationDetailDTO toDetail(Vacation vacation);

    @Mapping(source = "user_id", target = "user.id")
    @Mapping(source = "vacation_type_id", target = "vacationType.id")
    @Mapping(source = "state_id", target = "state.id")
    Vacation toEntity(VacationCreateDTO dto);
    Vacation toEntity(VacationUpdateDTO dto);

}
