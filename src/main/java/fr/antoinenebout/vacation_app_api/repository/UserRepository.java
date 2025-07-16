package fr.antoinenebout.vacation_app_api.repository;

import fr.antoinenebout.vacation_app_api.model.User;

import fr.antoinenebout.vacation_app_api.model.Vacation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

}
