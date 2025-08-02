package fr.antoinenebout.vacation_app_api.repository;

import fr.antoinenebout.vacation_app_api.model.User;
import fr.antoinenebout.vacation_app_api.model.Vacation;
import fr.antoinenebout.vacation_app_api.model.VacationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationGroupRepository extends JpaRepository<VacationGroup, Long> {

    List<VacationGroup> findAll();

    List<VacationGroup> findByUser(User user);
}