package fr.antoinenebout.vacation_app_api.service;

import fr.antoinenebout.vacation_app_api.dto.VacationTypeDTO;
import fr.antoinenebout.vacation_app_api.mapper.VacationTypeMapper;
import fr.antoinenebout.vacation_app_api.repository.VacationTypeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class VacationTypeService {

    @Autowired
    private VacationTypeRepository vacationTypeRepository;
    @Autowired
    private VacationTypeMapper vacationTypeMapper;

    public List<VacationTypeDTO> getVacationTypes() {
        return vacationTypeRepository.findAll().stream().map(vacationTypeMapper::toDTO).toList();
    }

}
