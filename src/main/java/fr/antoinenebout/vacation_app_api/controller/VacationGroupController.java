package fr.antoinenebout.vacation_app_api.controller;

import fr.antoinenebout.vacation_app_api.dto.VacationGroup.VacationGroupCreateDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationGroup.VacationGroupDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationGroup.VacationGroupSummaryDTO;
import fr.antoinenebout.vacation_app_api.dto.VacationGroup.VacationGroupUpdateDTO;
import fr.antoinenebout.vacation_app_api.service.VacationGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacation_groups")
public class VacationGroupController {

    private final VacationGroupService vacationGroupService;

    public VacationGroupController(VacationGroupService vacationGroupService) {
        this.vacationGroupService = vacationGroupService;
    }

    @GetMapping("/{id}")
    public VacationGroupDetailDTO getVacationGroup(@PathVariable("id") final Long id) {
        return vacationGroupService.getVacationGroup(id);
    }

    @GetMapping("")
    public List<VacationGroupSummaryDTO> getVacationGroups() {
        return vacationGroupService.getVacationGroups();
    }

    @PostMapping("")
    public VacationGroupDetailDTO create(@RequestBody VacationGroupCreateDTO vacationGroupCreateDTO) {
        return vacationGroupService.createVacationGroup(vacationGroupCreateDTO);
    }

    @PatchMapping("/{id}")
    public VacationGroupDetailDTO patch(@PathVariable("id") final Long id, @RequestBody VacationGroupUpdateDTO vacationGroupUpdateDTO) {
        return vacationGroupService.patchVacationGroup(id, vacationGroupUpdateDTO);
    }

    @DeleteMapping("/{id}")
    public VacationGroupDetailDTO delete(@PathVariable("id") final Long id) {
        return vacationGroupService.deleteVacationGroup(id);
    }

}
