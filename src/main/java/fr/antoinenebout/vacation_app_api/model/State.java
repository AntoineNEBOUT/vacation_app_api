package fr.antoinenebout.vacation_app_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "states")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String state_name;

    @OneToMany(mappedBy = "state")
    private List<VacationGroup> vacationGroups = new ArrayList<>();

}
