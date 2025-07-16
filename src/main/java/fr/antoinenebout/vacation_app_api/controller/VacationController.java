package fr.antoinenebout.vacation_app_api.controller;

import fr.antoinenebout.vacation_app_api.dto.VacationDTO;
import fr.antoinenebout.vacation_app_api.model.Vacation;
import fr.antoinenebout.vacation_app_api.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VacationController {

    private final VacationService vacationService;

    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @GetMapping("/dev/vacations")
    public List<VacationDTO> getVacations() {
        return vacationService.getVacations();
    }

    @PostMapping("/dev/vacation")
    public VacationDTO create(@RequestBody VacationDTO dto) {
        return vacationService.createVacation(dto);
    }

}
