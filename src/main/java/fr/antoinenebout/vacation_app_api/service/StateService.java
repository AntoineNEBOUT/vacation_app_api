package fr.antoinenebout.vacation_app_api.service;

import fr.antoinenebout.vacation_app_api.dto.StateDTO;
import fr.antoinenebout.vacation_app_api.mapper.StateMapper;
import fr.antoinenebout.vacation_app_api.repository.StateRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class StateService {

    private final StateRepository stateRepository;
    private final StateMapper stateMapper;

    public StateService(StateRepository stateRepository, StateMapper stateMapper) {
        this.stateRepository = stateRepository;
        this.stateMapper = stateMapper;
    }

    public Optional<StateDTO> getState(final Long id) {
        return stateRepository.findById(id).map(stateMapper::toDTO);
    }

    public List<StateDTO> getStates() {
        return stateRepository.findAll().stream().map(stateMapper::toDTO).toList();
    }

}
