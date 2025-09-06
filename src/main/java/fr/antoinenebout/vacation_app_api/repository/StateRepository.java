package fr.antoinenebout.vacation_app_api.repository;

import fr.antoinenebout.vacation_app_api.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findAll();

    @Query("SELECT s FROM State s WHERE s.state_name = :name")
    State findByStateName(@Param("name") String name);

}
