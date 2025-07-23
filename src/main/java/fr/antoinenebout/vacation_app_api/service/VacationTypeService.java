package fr.antoinenebout.vacation_app_api.service;

import fr.antoinenebout.vacation_app_api.dto.VacationType.VacationTypeCreateUpdateDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationType.VacationTypeDetailDTO;
import fr.antoinenebout.vacation_app_api.mapper.VacationTypeMapper;
import fr.antoinenebout.vacation_app_api.model.Vacation;
import fr.antoinenebout.vacation_app_api.model.VacationType;
import fr.antoinenebout.vacation_app_api.repository.VacationTypeRepository;
import fr.antoinenebout.vacation_app_api.util.AuthUtil;
import lombok.Data;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Data
@Service
public class VacationTypeService {

    private final VacationTypeRepository vacationTypeRepository;
    private final VacationTypeMapper vacationTypeMapper;
    private final AuthUtil authUtil;

    public VacationTypeService(
            VacationTypeRepository vacationTypeRepository,
            VacationTypeMapper vacationTypeMapper,
            AuthUtil authUtil) {
        this.vacationTypeRepository = vacationTypeRepository;
        this.vacationTypeMapper = vacationTypeMapper;
        this.authUtil = authUtil;
    }

    public List<VacationTypeDetailDTO> getVacationTypes() {
        return vacationTypeRepository.findAll().stream().map(vacationTypeMapper::toDetail).toList();
    }

    public VacationTypeDetailDTO getVacationType(Long id) {
        VacationType vacationType = vacationTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("VacationType not found"));
        return vacationTypeMapper.toDetail(vacationType);
    }
    
    public VacationTypeDetailDTO createVacationType(VacationTypeCreateUpdateDTO dto) {
        VacationType vacationType = vacationTypeMapper.toEntity(dto);
        
        VacationType saved = vacationTypeRepository.save(vacationType);
        
        return vacationTypeMapper.toDetail(saved);
    }
    
    public VacationTypeDetailDTO patchVacationType(Long id, VacationTypeCreateUpdateDTO dto) {
        VacationType vacationType = vacationTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("VacationType not found"));
        
        if(dto.getVacation_name() != null) {
            vacationType.setVacation_name(dto.getVacation_name());
        }
        
        VacationType updated = vacationTypeRepository.save(vacationType);
        
        return vacationTypeMapper.toDetail(updated);
    }
    
    public VacationTypeDetailDTO deleteVacationType(Long id) {
        VacationType vacationType = vacationTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("VacationType not found"));
        
        List<Vacation> vacations = vacationType.getVacations();

        if(!vacations.isEmpty()) {
            throw new AccessDeniedException("You cannot delete this resource");
        }

        vacationTypeRepository.delete(vacationType);

        return vacationTypeMapper.toDetail(vacationType);
    }

}
