package fr.antoinenebout.vacation_app_api.controller;

import fr.antoinenebout.vacation_app_api.dto.VacationTypeDTO;
import fr.antoinenebout.vacation_app_api.service.VacationTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vacation_types")
public class VacationTypeController {

    private final VacationTypeService vacationTypeService;

    public VacationTypeController(VacationTypeService vacationTypeService) {
        this.vacationTypeService = vacationTypeService;
    }

    @GetMapping("")
    public List<VacationTypeDTO> getVacationTypes() {
        return vacationTypeService.getVacationTypes();
    }

}
