package fr.antoinenebout.vacation_app_api.mapper;

import fr.antoinenebout.vacation_app_api.dto.Counter.CounterCreateDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationType.VacationTypeCreateUpdateDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationType.VacationTypeDetailDTO;
import fr.antoinenebout.vacation_app_api.model.VacationType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VacationTypeMapper {
    VacationTypeDetailDTO toDetail(VacationType vacationType);
    VacationType toEntity(VacationTypeCreateUpdateDTO dto);
}
