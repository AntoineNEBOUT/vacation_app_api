package fr.antoinenebout.vacation_app_api.mapper;

import fr.antoinenebout.vacation_app_api.dto.VacationGroup.VacationGroupCreateDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationGroup.VacationGroupDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationGroup.VacationGroupSummaryDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationGroup.VacationGroupUpdateDTO;
import fr.antoinenebout.vacation_app_api.model.VacationGroup;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {VacationMapper.class, UserMapper.class})
public interface VacationGroupMapper {

    @Mapping(source = "user.email", target = "username")
    @Mapping(source = "state.state_name", target = "state_name")
    VacationGroupSummaryDTO toSummary(VacationGroup vacationGroup);

    VacationGroupDetailDTO toDetail(VacationGroup vacationGroup);

    @Mapping(source = "state_id", target = "state.id")
    VacationGroup toEntity(VacationGroupCreateDTO dto);
    VacationGroup toEntity(VacationGroupUpdateDTO dto);

}