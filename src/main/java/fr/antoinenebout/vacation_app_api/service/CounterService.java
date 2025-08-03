package fr.antoinenebout.vacation_app_api.service;

import fr.antoinenebout.vacation_app_api.dto.Counter.CounterCreateDTO;
import fr.antoinenebout.vacation_app_api.dto.Counter.CounterDetailDTO;
import fr.antoinenebout.vacation_app_api.dto.Counter.CounterSummaryDTO;
import fr.antoinenebout.vacation_app_api.dto.Counter.CounterUpdateDTO;
import fr.antoinenebout.vacation_app_api.mapper.CounterMapper;
import fr.antoinenebout.vacation_app_api.model.Counter;
import fr.antoinenebout.vacation_app_api.model.User;
import fr.antoinenebout.vacation_app_api.model.VacationType;
import fr.antoinenebout.vacation_app_api.repository.UserRepository;
import fr.antoinenebout.vacation_app_api.repository.CounterRepository;
import fr.antoinenebout.vacation_app_api.repository.VacationTypeRepository;
import fr.antoinenebout.vacation_app_api.util.AuthUtil;
import lombok.Data;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Data
@Service
public class CounterService {

    private final CounterRepository counterRepository;
    private final UserRepository userRepository;
    private final VacationTypeRepository vacationTypeRepository;
    private final CounterMapper counterMapper;
    private final AuthUtil authUtil;

    public CounterService(
            CounterRepository counterRepository,
            UserRepository userRepository,
            VacationTypeRepository vacationTypeRepository,
            CounterMapper counterMapper,
            AuthUtil authUtil) {
        this.counterRepository = counterRepository;
        this.userRepository = userRepository;
        this.vacationTypeRepository = vacationTypeRepository;
        this.counterMapper = counterMapper;
        this.authUtil = authUtil;
    }

    public List<CounterSummaryDTO> getCounters() {
        User user = userRepository.findById(authUtil.getCurrentUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        return counterRepository.findByUser(user).stream().map(counterMapper::toSummary).toList();
    }

    public CounterDetailDTO getCounter(final Long id) {
        Counter counter = counterRepository.findById(id).orElseThrow(() -> new RuntimeException("Counter not found"));

        if(!Objects.equals(counter.getUser().getId(), authUtil.getCurrentUserId())) {
            throw new AccessDeniedException("You cannot access this resource.");
        }

        return counterMapper.toDetail(counter);
    }

    public CounterDetailDTO createCounter(CounterCreateDTO dto) {
        User user = userRepository.findById(authUtil.getCurrentUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        VacationType type = vacationTypeRepository.findById(dto.getVacation_type_id()).orElseThrow(() -> new RuntimeException("Type not found"));
        final Double requested = dto.getRequested() != null ? dto.getRequested() : 0D;
        final Double validated = dto.getValidated() != null ? dto.getValidated() : 0D;
        final Double remaining = dto.getValidated() != null ? dto.getRemaining() : dto.getYearly_total();

        Counter counter_entity = counterMapper.toEntity(dto);
        counter_entity.setUser(user);
        counter_entity.setVacationType(type);
        counter_entity.setRequested(requested);
        counter_entity.setValidated(validated);
        counter_entity.setRemaining(remaining);
        Counter saved = counterRepository.save(counter_entity);
        return counterMapper.toDetail(saved);
    }

    public CounterDetailDTO patchCounter(Long id, CounterUpdateDTO dto) {
        Counter counter = counterRepository.findById(id).orElseThrow(() -> new RuntimeException("Counter not found"));

        if(!Objects.equals(counter.getUser().getId(), authUtil.getCurrentUserId())) {
            throw new AccessDeniedException("You cannot modify this resource.");
        }

        if(dto.getYearly_total() != null) {
            counter.setYearly_total(dto.getYearly_total());
        }

        if(dto.getRequested() != null) {
            counter.setRequested(dto.getRequested());
        }

        if(dto.getValidated() != null) {
            counter.setValidated(dto.getValidated());
        }

        if(dto.getRemaining() != null) {
            counter.setRemaining(dto.getRemaining());
        }

        if(dto.getVacation_type_id() != null) {
            counter.setVacationType(vacationTypeRepository.findById(dto.getVacation_type_id()).orElseThrow(() -> new RuntimeException("VacationType not found")));
        }

        Counter updated = counterRepository.save(counter);

        return counterMapper.toDetail(updated);

    }

    public CounterDetailDTO deleteCounter(Long id) {
        Counter counter = counterRepository.findById(id).orElseThrow(() -> new RuntimeException("Counter not found"));

        if(!Objects.equals(counter.getUser().getId(), authUtil.getCurrentUserId())) {
            throw new AccessDeniedException("You cannot delete this resource");
        }

        counterRepository.delete(counter);

        return counterMapper.toDetail(counter);
    }

}
