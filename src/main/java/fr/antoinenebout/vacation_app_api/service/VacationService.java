package fr.antoinenebout.vacation_app_api.service;

import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationCreateDTO;
import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationSummaryDTO;
import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationUpdateDTO;
import fr.antoinenebout.vacation_app_api.mapper.VacationMapper;
import fr.antoinenebout.vacation_app_api.model.State;
import fr.antoinenebout.vacation_app_api.model.User;
import fr.antoinenebout.vacation_app_api.model.Vacation;
import fr.antoinenebout.vacation_app_api.model.VacationType;
import fr.antoinenebout.vacation_app_api.repository.StateRepository;
import fr.antoinenebout.vacation_app_api.repository.UserRepository;
import fr.antoinenebout.vacation_app_api.repository.VacationRepository;
import fr.antoinenebout.vacation_app_api.repository.VacationTypeRepository;
import fr.antoinenebout.vacation_app_api.util.AuthUtil;
import lombok.Data;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Data
@Service
public class VacationService {

    private final VacationRepository vacationRepository;
    private final VacationMapper vacationMapper;
    private final UserRepository userRepository;
    private final VacationTypeRepository vacationTypeRepository;
    private final StateRepository stateRepository;
    private final AuthUtil authUtil;

    public VacationService(
            VacationRepository vacationRepository,
            VacationMapper vacationMapper,
            UserRepository userRepository,
            VacationTypeRepository vacationTypeRepository,
            StateRepository stateRepository,
            AuthUtil authUtil) {
        this.vacationRepository = vacationRepository;
        this.vacationMapper = vacationMapper;
        this.userRepository = userRepository;
        this.vacationTypeRepository = vacationTypeRepository;
        this.stateRepository = stateRepository;
        this.authUtil = authUtil;
    }

    public List<VacationSummaryDTO> getVacations() {
        User user = userRepository.findById(authUtil.getCurrentUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        return vacationRepository.findByUser(user).stream().map(vacationMapper::toSummary).toList();
    }

    public VacationDetailDTO getVacation(final Long id) {
        Vacation vacation = vacationRepository.findById(id).orElseThrow(() -> new RuntimeException("Vacation not found"));

        if(!Objects.equals(vacation.getUser().getId(), authUtil.getCurrentUserId())) {
            throw new AccessDeniedException("You cannot access this resource");
        }

        return vacationMapper.toDetail(vacation);
    }

    public VacationDetailDTO createVacation(VacationCreateDTO vacationCreateDTO) {
        User user = userRepository.findById(authUtil.getCurrentUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        VacationType vacationType = vacationTypeRepository.findById(vacationCreateDTO.getVacation_type_id()).orElseThrow(() -> new RuntimeException("Type not found"));
        State state = stateRepository.findById(vacationCreateDTO.getState_id()).orElseThrow(() -> new RuntimeException("State not found"));

        Vacation vacation_entity = vacationMapper.toEntity(vacationCreateDTO);
        vacation_entity.setUser(user);
        vacation_entity.setVacationType(vacationType);
        vacation_entity.setState(state);

        Vacation saved = vacationRepository.save(vacation_entity);

        return vacationMapper.toDetail(saved);
    }

    public VacationDetailDTO patchVacation(Long id, VacationUpdateDTO vacationUpdateDTO) {
        Vacation vacation_entity = vacationRepository.findById(id).orElseThrow(() -> new RuntimeException("Vacation not found"));

        if(!Objects.equals(vacation_entity.getUser().getId(), authUtil.getCurrentUserId())) {
            throw new AccessDeniedException("You cannot modify this resource");
        }

        if(vacationUpdateDTO.getRequested() != null) {
            vacation_entity.setRequested(vacationUpdateDTO.getRequested());
        }

        if(vacationUpdateDTO.getStart_date() != null) {
            vacation_entity.setStart_date(vacationUpdateDTO.getStart_date());
        }

        if(vacationUpdateDTO.getEnd_date() != null) {
            vacation_entity.setEnd_date(vacationUpdateDTO.getEnd_date());
        }

        if(vacationUpdateDTO.getVacation_type_id() != null) {
            VacationType vacationType = vacationTypeRepository.findById(vacationUpdateDTO.getVacation_type_id()).orElseThrow(() -> new RuntimeException("Type not found"));
            vacation_entity.setVacationType(vacationType);
        }

        if(vacationUpdateDTO.getState_id() != null) {
            State state = stateRepository.findById(vacationUpdateDTO.getState_id()).orElseThrow(() -> new RuntimeException("State not found"));
            vacation_entity.setState(state);
        }

        Vacation updated = vacationRepository.save(vacation_entity);

        return vacationMapper.toDetail(updated);
    }

    public VacationDetailDTO deleteVacation(Long id) {
        Vacation vacation = vacationRepository.findById(id).orElseThrow(() -> new RuntimeException("Vacation not found"));

        if(!Objects.equals(vacation.getUser().getId(), authUtil.getCurrentUserId())) {
            throw new AccessDeniedException("You cannot delete this resource");
        }

        vacationRepository.delete(vacation);

        return vacationMapper.toDetail(vacation);
    }

}
