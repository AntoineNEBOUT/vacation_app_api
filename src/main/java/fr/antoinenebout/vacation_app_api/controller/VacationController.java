package fr.antoinenebout.vacation_app_api.controller;

import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationCreateDTO;
import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationSummaryDTO;
import fr.antoinenebout.vacation_app_api.dto.Vacation.VacationUpdateDTO;
import fr.antoinenebout.vacation_app_api.service.VacationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacations")
public class VacationController {

    private final VacationService vacationService;

    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @GetMapping("/{id}")
    public VacationDetailDTO getVacation(@PathVariable("id") final Long id) {
        return vacationService.getVacation(id);
    }

    @PostMapping("")
    public VacationDetailDTO create(@RequestBody VacationCreateDTO vacationCreateDTO) {
        return vacationService.createVacation(vacationCreateDTO);
    }

    @PatchMapping("/{id}")
    public VacationDetailDTO patch(@PathVariable("id") final Long id, @RequestBody VacationUpdateDTO vacationUpdateDTO) {
        return vacationService.patchVacation(id, vacationUpdateDTO);
    }

    @DeleteMapping("/{id}")
    public VacationDetailDTO delete(@PathVariable("id") final Long id) {
        return vacationService.deleteVacation(id);
    }

}
