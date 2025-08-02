package fr.antoinenebout.vacation_app_api.mapper;

import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationCreateDTO;
import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationSummaryDTO;
import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationUpdateDTO;
import fr.antoinenebout.vacation_app_api.model.Vacation;
import fr.antoinenebout.vacation_app_api.model.VacationGroup;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {VacationGroupMapper.class, VacationMapper.class})
public interface VacationMapper {

    @Mapping(source = "vacationType.vacation_name", target = "type")
    @Mapping(source = "vacationGroup.name", target = "group")
    VacationSummaryDTO toSummary(Vacation vacation);

    VacationDetailDTO toDetail(Vacation vacation);

    @Mapping(source = "vacation_type_id", target = "vacationType.id")
    @Mapping(source = "vacation_group_id", target = "vacationGroup.id")
    Vacation toEntity(VacationCreateDTO dto);
    Vacation toEntity(VacationUpdateDTO dto);

}
