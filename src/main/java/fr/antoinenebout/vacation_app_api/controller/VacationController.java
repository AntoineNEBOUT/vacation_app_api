package fr.antoinenebout.vacation_app_api.controller;

import fr.antoinenebout.vacation_app_api.dto.VacationDTO;
import fr.antoinenebout.vacation_app_api.service.VacationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vacations")
public class VacationController {

    private final VacationService vacationService;

    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @GetMapping("/{id}")
    public VacationDTO getVacation(@PathVariable("id") final Long id) {
        Optional<VacationDTO> vacationDTO = vacationService.getVacation(id);
        return vacationDTO.orElse(null);
    }

    @GetMapping("")
    public List<VacationDTO> getVacations() {
        return vacationService.getVacations();
    }

    @PostMapping("")
    public VacationDTO createVacation(@RequestBody VacationDTO vacationDTO) {
        return vacationService.createVacation(vacationDTO);
    }

}
