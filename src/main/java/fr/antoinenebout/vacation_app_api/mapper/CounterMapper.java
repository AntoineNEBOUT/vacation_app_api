package fr.antoinenebout.vacation_app_api.mapper;

import fr.antoinenebout.vacation_app_api.dto.Counter.CounterCreateDTO;
import fr.antoinenebout.vacation_app_api.dto.Counter.CounterDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.Counter.CounterSummaryDTO;
import fr.antoinenebout.vacation_app_api.dto.Counter.CounterUpdateDTO;
import fr.antoinenebout.vacation_app_api.model.Counter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, VacationMapper.class})
public interface CounterMapper {

    @Mapping(source = "user.email", target = "username")
    @Mapping(source = "vacationType.vacation_name", target = "type")
    CounterSummaryDTO toSummary(Counter counter);

    CounterDetailDTO toDetail(Counter counter);

    @Mapping(source = "vacation_type_id", target = "vacationType.id")
    Counter toEntity(CounterCreateDTO dto);
    Counter toEntity(CounterUpdateDTO dto);

}
