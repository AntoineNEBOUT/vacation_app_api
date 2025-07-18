package fr.antoinenebout.vacation_app_api.service;

import fr.antoinenebout.vacation_app_api.dto.CounterDTO;
import fr.antoinenebout.vacation_app_api.mapper.CounterMapper;
import fr.antoinenebout.vacation_app_api.model.Counter;
import fr.antoinenebout.vacation_app_api.model.User;
import fr.antoinenebout.vacation_app_api.model.VacationType;
import fr.antoinenebout.vacation_app_api.repository.UserRepository;
import fr.antoinenebout.vacation_app_api.repository.CounterRepository;
import fr.antoinenebout.vacation_app_api.repository.VacationTypeRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class CounterService {

    private final CounterRepository counterRepository;
    private final UserRepository userRepository;
    private final VacationTypeRepository vacationTypeRepository;
    private final CounterMapper counterMapper;

    public CounterService(
            CounterRepository counterRepository,
            UserRepository userRepository,
            VacationTypeRepository vacationTypeRepository,
            CounterMapper counterMapper) {
        this.counterRepository = counterRepository;
        this.userRepository = userRepository;
        this.vacationTypeRepository = vacationTypeRepository;
        this.counterMapper = counterMapper;
    }

    public List<CounterDTO> getVacations() {
        return counterRepository.findAll().stream().map(counterMapper::toDTO).toList();
    }

    public CounterDTO createVacation(CounterDTO dto) {
//        User user = userRepository.findById(dto.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
//        VacationType type = vacationTypeRepository.findById(dto.getVacation_type().getId()).orElseThrow(() -> new RuntimeException("Type not found"));
        User user = userRepository.findById(dto.getUser_id()).orElseThrow(() -> new RuntimeException("User not found"));
        VacationType type = vacationTypeRepository.findById(dto.getVacation_type_id()).orElseThrow(() -> new RuntimeException("Type not found"));

        Counter counter_entity = counterMapper.toEntity(dto);
        counter_entity.setUser(user);
        counter_entity.setVacationType(type);
        Counter saved = counterRepository.save(counter_entity);
        return counterMapper.toDTO(saved);
    }

}
