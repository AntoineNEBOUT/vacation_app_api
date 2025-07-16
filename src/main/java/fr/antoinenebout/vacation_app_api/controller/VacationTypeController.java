package fr.antoinenebout.vacation_app_api.controller;

import fr.antoinenebout.vacation_app_api.dto.VacationTypeDTO;
import fr.antoinenebout.vacation_app_api.service.VacationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VacationTypeController {

    @Autowired
    private VacationTypeService vacationTypeService;

    @GetMapping("/dev/vacation_types")
    public List<VacationTypeDTO> getVacationTypes() {
        return vacationTypeService.getVacationTypes();
    }

}
