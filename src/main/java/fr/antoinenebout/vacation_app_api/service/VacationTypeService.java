package fr.antoinenebout.vacation_app_api.service;

import fr.antoinenebout.vacation_app_api.dto.VacationTypeDTO;
import fr.antoinenebout.vacation_app_api.mapper.VacationTypeMapper;
import fr.antoinenebout.vacation_app_api.repository.VacationTypeRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class VacationTypeService {

    private final VacationTypeRepository vacationTypeRepository;
    private final VacationTypeMapper vacationTypeMapper;

    public VacationTypeService(VacationTypeRepository vacationTypeRepository, VacationTypeMapper vacationTypeMapper) {
        this.vacationTypeRepository = vacationTypeRepository;
        this.vacationTypeMapper = vacationTypeMapper;
    }

    public List<VacationTypeDTO> getVacationTypes() {
        return vacationTypeRepository.findAll().stream().map(vacationTypeMapper::toDTO).toList();
    }

}
