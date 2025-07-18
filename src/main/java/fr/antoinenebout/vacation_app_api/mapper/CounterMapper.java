package fr.antoinenebout.vacation_app_api.mapper;

import fr.antoinenebout.vacation_app_api.dto.CounterDTO;
import fr.antoinenebout.vacation_app_api.model.Counter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface CounterMapper {

    @Mapping(source = "user.id", target = "user_id")
    @Mapping(source = "vacationType.id", target = "vacation_type_id")
    CounterDTO toDTO(Counter counter);

    @Mapping(source = "user_id", target = "user.id")
    @Mapping(source = "vacation_type_id", target = "vacationType.id")
    Counter toEntity(CounterDTO dto);

}
