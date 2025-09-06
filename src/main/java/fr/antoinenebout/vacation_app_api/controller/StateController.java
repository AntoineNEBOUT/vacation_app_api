package fr.antoinenebout.vacation_app_api.controller;

import fr.antoinenebout.vacation_app_api.dto.StateDTO;
import fr.antoinenebout.vacation_app_api.service.StateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/{id}")
    public StateDTO getState(@PathVariable("id") final Long id) {
        Optional<StateDTO> state = stateService.getState(id);
        return state.orElse(null);
    }

    @GetMapping("")
    public List<StateDTO> getStates() {
        return stateService.getStates();
    }

}
