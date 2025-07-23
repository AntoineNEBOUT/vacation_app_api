package fr.antoinenebout.vacation_app_api.controller;

import fr.antoinenebout.vacation_app_api.dto.VacationType.VacationTypeCreateUpdateDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationType.VacationTypeDetailDTO;
import fr.antoinenebout.vacation_app_api.service.VacationTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacation_types")
public class VacationTypeController {

    private final VacationTypeService vacationTypeService;

    public VacationTypeController(VacationTypeService vacationTypeService) {
        this.vacationTypeService = vacationTypeService;
    }

    @GetMapping("")
    public List<VacationTypeDetailDTO> getVacationTypes() {
        return vacationTypeService.getVacationTypes();
    }

    @GetMapping("/{id}")
    public VacationTypeDetailDTO getVacationType(@PathVariable("id") final Long id) {
        return vacationTypeService.getVacationType(id);
    }

    @PostMapping("")
    public VacationTypeDetailDTO create(@RequestBody VacationTypeCreateUpdateDTO dto) {
        return vacationTypeService.createVacationType(dto);
    }

    @PatchMapping("/{id}")
    public VacationTypeDetailDTO patch(@PathVariable("id") final Long id, @RequestBody VacationTypeCreateUpdateDTO dto) {
        return vacationTypeService.patchVacationType(id, dto);
    }

    @DeleteMapping("/{id}")
    public VacationTypeDetailDTO delete(@PathVariable("id") final Long id) {
        return vacationTypeService.deleteVacationType(id);
    }

}
