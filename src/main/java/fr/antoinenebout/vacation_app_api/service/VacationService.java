package fr.antoinenebout.vacation_app_api.service;

import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationCreateDTO;
import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationSummaryDTO;
import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationUpdateDTO;
import fr.antoinenebout.vacation_app_api.mapper.VacationMapper;
import fr.antoinenebout.vacation_app_api.model.*;
import fr.antoinenebout.vacation_app_api.repository.*;
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
    private final VacationGroupRepository vacationGroupRepository;
    private final AuthUtil authUtil;

    public VacationService(
            VacationRepository vacationRepository,
            VacationMapper vacationMapper,
            UserRepository userRepository,
            VacationTypeRepository vacationTypeRepository,
            VacationGroupRepository vacationGroupRepository,
            AuthUtil authUtil) {
        this.vacationRepository = vacationRepository;
        this.vacationMapper = vacationMapper;
        this.userRepository = userRepository;
        this.vacationTypeRepository = vacationTypeRepository;
        this.vacationGroupRepository = vacationGroupRepository;
        this.authUtil = authUtil;
    }

    public VacationDetailDTO getVacation(final Long id) {
        Vacation vacation = vacationRepository.findById(id).orElseThrow(() -> new RuntimeException("Vacation not found"));

        if(!Objects.equals(vacation.getVacationGroup().getUser().getId(), authUtil.getCurrentUserId())) {
            throw new AccessDeniedException("You cannot access this resource");
        }

        return vacationMapper.toDetail(vacation);
    }

    public VacationDetailDTO createVacation(final VacationCreateDTO vacationCreateDTO) {
        VacationType vacationType = vacationTypeRepository.findById(vacationCreateDTO.getVacation_type_id()).orElseThrow(() -> new RuntimeException("Type not found"));
        VacationGroup vacationGroup = vacationGroupRepository.findById(vacationCreateDTO.getVacation_group_id()).orElseThrow(() -> new RuntimeException("Group not found"));

        Vacation vacation_entity = vacationMapper.toEntity(vacationCreateDTO);
        vacation_entity.setVacationType(vacationType);
        vacation_entity.setVacationGroup(vacationGroup);

        Vacation saved = vacationRepository.save(vacation_entity);

        return vacationMapper.toDetail(saved);
    }

    public VacationDetailDTO patchVacation(final Long id, VacationUpdateDTO vacationUpdateDTO) {
        Vacation vacation_entity = vacationRepository.findById(id).orElseThrow(() -> new RuntimeException("Vacation not found"));

        if(!Objects.equals(vacation_entity.getVacationGroup().getUser().getId(), authUtil.getCurrentUserId())) {
            throw new AccessDeniedException("You cannot modify this resource");
        }

        if(vacationUpdateDTO.getRequested() != null) {
            vacation_entity.setRequested(vacationUpdateDTO.getRequested());
        }

        if(vacationUpdateDTO.getVacation_type_id() != null) {
            VacationType vacationType = vacationTypeRepository.findById(vacationUpdateDTO.getVacation_type_id()).orElseThrow(() -> new RuntimeException("Type not found"));
            vacation_entity.setVacationType(vacationType);
        }

        if(vacationUpdateDTO.getVacation_group_id() != null) {
            VacationGroup vacationGroup = vacationGroupRepository.findById(vacationUpdateDTO.getVacation_group_id()).orElseThrow(() -> new RuntimeException("Group not found"));
            vacation_entity.setVacationGroup(vacationGroup);
        }

        Vacation updated = vacationRepository.save(vacation_entity);

        return vacationMapper.toDetail(updated);
    }

    public VacationDetailDTO deleteVacation(final Long id) {
        Vacation vacation = vacationRepository.findById(id).orElseThrow(() -> new RuntimeException("Vacation not found"));

        if(!Objects.equals(vacation.getVacationGroup().getUser().getId(), authUtil.getCurrentUserId())) {
            throw new AccessDeniedException("You cannot delete this resource");
        }

        vacationRepository.delete(vacation);

        return vacationMapper.toDetail(vacation);
    }

}
