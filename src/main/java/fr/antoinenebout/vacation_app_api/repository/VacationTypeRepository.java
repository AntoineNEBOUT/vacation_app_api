package fr.antoinenebout.vacation_app_api.repository;

import fr.antoinenebout.vacation_app_api.model.User;
import fr.antoinenebout.vacation_app_api.model.VacationType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationTypeRepository extends CrudRepository<VacationType, Long> {

    List<VacationType> findAll();

}
