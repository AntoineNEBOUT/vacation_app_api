package fr.antoinenebout.vacation_app_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "vacationstypes")
public class VacationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String vacation_name;

    @OneToMany(mappedBy = "vacationType")
    private List<Counter> counters = new ArrayList<>();

    @OneToMany(mappedBy = "vacationType")
    private List<Vacation> vacations = new ArrayList<>();

}
