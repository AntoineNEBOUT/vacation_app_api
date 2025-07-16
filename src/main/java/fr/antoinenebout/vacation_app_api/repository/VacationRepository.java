package fr.antoinenebout.vacation_app_api.repository;

import fr.antoinenebout.vacation_app_api.model.Vacation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRepository extends CrudRepository<Vacation, Long> {

    List<Vacation> findAll();

}
