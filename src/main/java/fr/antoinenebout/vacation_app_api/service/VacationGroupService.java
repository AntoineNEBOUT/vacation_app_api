package fr.antoinenebout.vacation_app_api.service;

import fr.antoinenebout.vacation_app_api.dto.VacationGroup.VacationGroupCreateDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationGroup.VacationGroupDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationGroup.VacationGroupSummaryDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationGroup.VacationGroupUpdateDTO;
import fr.antoinenebout.vacation_app_api.mapper.VacationGroupMapper;
import fr.antoinenebout.vacation_app_api.model.State;
import fr.antoinenebout.vacation_app_api.model.User;
import fr.antoinenebout.vacation_app_api.model.VacationGroup;
import fr.antoinenebout.vacation_app_api.repository.StateRepository;
import fr.antoinenebout.vacation_app_api.repository.UserRepository;
import fr.antoinenebout.vacation_app_api.repository.VacationGroupRepository;
import fr.antoinenebout.vacation_app_api.util.AuthUtil;
import lombok.Data;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Data
@Service
public class VacationGroupService {

    private final VacationGroupRepository vacationGroupRepository;
    private final VacationGroupMapper vacationGroupMapper;
    private final UserRepository userRepository;
    private final StateRepository stateRepository;
    private final AuthUtil authUtil;

    public VacationGroupService(
            VacationGroupRepository vacationGroupRepository,
            VacationGroupMapper vacationGroupMapper,
            UserRepository userRepository,
            StateRepository stateRepository,
            AuthUtil authUtil
    ) {
        this.vacationGroupRepository = vacationGroupRepository;
        this.vacationGroupMapper = vacationGroupMapper;
        this.userRepository = userRepository;
        this.stateRepository = stateRepository;
        this.authUtil = authUtil;
    }

    public List<VacationGroupSummaryDTO> getVacationGroups() {
        User user = userRepository.findById(authUtil.getCurrentUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        return vacationGroupRepository.findByUser(user).stream().map(vacationGroupMapper::toSummary).toList();
    }

    public VacationGroupDetailDTO getVacationGroup(final Long id) {
        VacationGroup vacationGroup = vacationGroupRepository.findById(id).orElseThrow(() -> new RuntimeException("Vacation group not found"));
        return vacationGroupMapper.toDetail(vacationGroup);
    }

    public VacationGroupDetailDTO createVacationGroup(final VacationGroupCreateDTO vacationGroupCreateDTO) {
        User user = userRepository.findById(authUtil.getCurrentUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        State state = stateRepository.findById(vacationGroupCreateDTO.getState_id()).orElseThrow(() -> new RuntimeException("State not found"));

        VacationGroup vacationGroup_entity = vacationGroupMapper.toEntity(vacationGroupCreateDTO);
        vacationGroup_entity.setUser(user);
        vacationGroup_entity.setState(state);

        VacationGroup saved = vacationGroupRepository.save(vacationGroup_entity);

        return vacationGroupMapper.toDetail(saved);
    }

    public VacationGroupDetailDTO patchVacationGroup(final Long id, final VacationGroupUpdateDTO vacationGroupUpdateDTO) {
        VacationGroup vacationGroup_entity = vacationGroupRepository.findById(id).orElseThrow(() -> new RuntimeException("Vacation group not found"));

        if(!Objects.equals(vacationGroup_entity.getUser().getId(), authUtil.getCurrentUserId())) {
            throw new AccessDeniedException("You cannot modify this resource");
        }

        if(vacationGroupUpdateDTO.getName() != null) {
            vacationGroup_entity.setName(vacationGroupUpdateDTO.getName());
        }

        if(vacationGroupUpdateDTO.getStart_date() != null) {
            vacationGroup_entity.setStart_date(vacationGroupUpdateDTO.getStart_date());
        }

        if(vacationGroupUpdateDTO.getEnd_date() != null) {
            vacationGroup_entity.setEnd_date(vacationGroupUpdateDTO.getEnd_date());
        }

        if(vacationGroupUpdateDTO.getState_id() != null) {
            State state = stateRepository.findById(vacationGroupUpdateDTO.getState_id()).orElseThrow(() -> new RuntimeException("State not found"));
            vacationGroup_entity.setState(state);
        }

        VacationGroup updated = vacationGroupRepository.save(vacationGroup_entity);

        return vacationGroupMapper.toDetail(updated);
    }

    public VacationGroupDetailDTO deleteVacationGroup(final Long id) {
        VacationGroup vacationGroup = vacationGroupRepository.findById(id).orElseThrow(() -> new RuntimeException("Vacation group not found"));

        if(!Objects.equals(vacationGroup.getUser().getId(), authUtil.getCurrentUserId())) {
            throw new AccessDeniedException("You cannot modify this resource");
        }

        vacationGroupRepository.delete(vacationGroup);

        return vacationGroupMapper.toDetail(vacationGroup);
    }

}
