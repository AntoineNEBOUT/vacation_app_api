package fr.antoinenebout.vacation_app_api.controller;

import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationCreateDTO;
import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationSummaryDTO;
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
    public VacationDetailDTO getVacation(@PathVariable("id") final Long id) {
        Optional<VacationDetailDTO> vacationDTO = vacationService.getVacation(id);
        return vacationDTO.orElse(null);
    }

    @GetMapping("")
    public List<VacationSummaryDTO> getVacations() {
        return vacationService.getVacations();
    }

    @PostMapping("")
    public VacationDetailDTO createVacation(@RequestBody VacationCreateDTO vacationCreateDTO) {
        return vacationService.createVacation(vacationCreateDTO);
    }

}
