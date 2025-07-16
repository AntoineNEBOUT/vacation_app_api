package fr.antoinenebout.vacation_app_api.service;

import fr.antoinenebout.vacation_app_api.dto.VacationDTO;
import fr.antoinenebout.vacation_app_api.mapper.VacationMapper;
import fr.antoinenebout.vacation_app_api.model.User;
import fr.antoinenebout.vacation_app_api.model.Vacation;
import fr.antoinenebout.vacation_app_api.model.VacationType;
import fr.antoinenebout.vacation_app_api.repository.UserRepository;
import fr.antoinenebout.vacation_app_api.repository.VacationRepository;
import fr.antoinenebout.vacation_app_api.repository.VacationTypeRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class VacationService {

    private final VacationRepository vacationRepository;
    private final UserRepository userRepository;
    private final VacationTypeRepository vacationTypeRepository;
    private final VacationMapper vacationMapper;

    public VacationService(VacationRepository vacationRepository, UserRepository userRepository, VacationTypeRepository vacationTypeRepository, VacationMapper vacationMapper) {
        this.vacationRepository = vacationRepository;
        this.userRepository = userRepository;
        this.vacationTypeRepository = vacationTypeRepository;
        this.vacationMapper = vacationMapper;
    }

    public List<VacationDTO> getVacations() {
        return vacationRepository.findAll().stream().map(vacationMapper::toDTO).collect(Collectors.toList());
    }

    public VacationDTO createVacation(VacationDTO dto) {
        User user = userRepository.findById(dto.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
        VacationType type = vacationTypeRepository.findById(dto.getVacation_type().getId()).orElseThrow(() -> new RuntimeException("Type not found"));

        Vacation vacation_entity = vacationMapper.toEntity(dto);
        vacation_entity.setUser(user);
        vacation_entity.setVacationType(type);
        Vacation saved = vacationRepository.save(vacation_entity);
        return vacationMapper.toDTO(saved);
    }

}
