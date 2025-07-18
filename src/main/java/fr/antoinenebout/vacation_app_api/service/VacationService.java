package fr.antoinenebout.vacation_app_api.service;

import fr.antoinenebout.vacation_app_api.dto.VacationDTO;
import fr.antoinenebout.vacation_app_api.mapper.VacationMapper;
import fr.antoinenebout.vacation_app_api.model.State;
import fr.antoinenebout.vacation_app_api.model.User;
import fr.antoinenebout.vacation_app_api.model.Vacation;
import fr.antoinenebout.vacation_app_api.model.VacationType;
import fr.antoinenebout.vacation_app_api.repository.StateRepository;
import fr.antoinenebout.vacation_app_api.repository.UserRepository;
import fr.antoinenebout.vacation_app_api.repository.VacationRepository;
import fr.antoinenebout.vacation_app_api.repository.VacationTypeRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class VacationService {

    private final VacationRepository vacationRepository;
    private final VacationMapper vacationMapper;
    private final UserRepository userRepository;
    private final VacationTypeRepository vacationTypeRepository;
    private final StateRepository stateRepository;

    public VacationService(
            VacationRepository vacationRepository,
            VacationMapper vacationMapper,
            UserRepository userRepository,
            VacationTypeRepository vacationTypeRepository,
            StateRepository stateRepository) {
        this.vacationRepository = vacationRepository;
        this.vacationMapper = vacationMapper;
        this.userRepository = userRepository;
        this.vacationTypeRepository = vacationTypeRepository;
        this.stateRepository = stateRepository;
    }

    public List<VacationDTO> getVacations() {
        return vacationRepository.findAll().stream().map(vacationMapper::toDTO).toList();
    }

    public Optional<VacationDTO> getVacation(final Long id) {
        return vacationRepository.findById(id).map(vacationMapper::toDTO);
    }

    public VacationDTO createVacation(VacationDTO vacationDTO) {
        User user = userRepository.findById(vacationDTO.getUser_id()).orElseThrow(() -> new RuntimeException("User not found"));
        VacationType vacationType = vacationTypeRepository.findById(vacationDTO.getVacation_type_id()).orElseThrow(() -> new RuntimeException("Type not found"));
        State state = stateRepository.findById(vacationDTO.getState_id()).orElseThrow(() -> new RuntimeException("State not found"));

        Vacation vacation_entity = vacationMapper.toEntity(vacationDTO);
        vacation_entity.setUser(user);
        vacation_entity.setVacationType(vacationType);
        vacation_entity.setState(state);

        Vacation saved = vacationRepository.save(vacation_entity);

        return vacationMapper.toDTO(saved);
    }

}
