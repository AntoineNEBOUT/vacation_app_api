package fr.antoinenebout.vacation_app_api.controller;

import fr.antoinenebout.vacation_app_api.dto.Counter.CounterCreateDTO;
import fr.antoinenebout.vacation_app_api.dto.Counter.CounterDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.Counter.CounterSummaryDTO;
import fr.antoinenebout.vacation_app_api.dto.Counter.CounterUpdateDTO;
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
    public List<CounterSummaryDTO> getCounters() {
        return counterService.getCounters();
    }

    @GetMapping("/{id}")
    public CounterDetailDTO getCounter(@PathVariable("id") final Long id) {
        return counterService.getCounter(id);
    }

    @PostMapping("")
    public CounterDetailDTO create(@RequestBody CounterCreateDTO dto) {
        return counterService.createCounter(dto);
    }

    @PatchMapping("/{id}")
    public CounterDetailDTO patch(@PathVariable("id") final Long id, @RequestBody CounterUpdateDTO dto) {
        return counterService.patchCounter(id, dto);
    }

}
