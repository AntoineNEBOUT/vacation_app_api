package fr.antoinenebout.vacation_app_api.mapper;

import fr.antoinenebout.vacation_app_api.dto.CounterDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationTypeDTO;
import fr.antoinenebout.vacation_app_api.model.VacationType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VacationTypeMapper {
    VacationTypeDTO toDTO(VacationType vacationType);
    VacationType toEntity(CounterDTO dto);
}
