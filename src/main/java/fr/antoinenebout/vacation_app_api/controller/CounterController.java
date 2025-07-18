package fr.antoinenebout.vacation_app_api.controller;

import fr.antoinenebout.vacation_app_api.dto.CounterDTO;
import fr.antoinenebout.vacation_app_api.service.CounterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/counters")
public class CounterController {

    private final CounterService counterService;

    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping("")
    public List<CounterDTO> getVacations() {
        return counterService.getVacations();
    }

    @PostMapping("")
    public CounterDTO create(@RequestBody CounterDTO dto) {
        return counterService.createVacation(dto);
    }

}
