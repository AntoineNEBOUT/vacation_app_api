package fr.antoinenebout.vacation_app_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "vacations")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vacation_type_id")
    private VacationType vacationType;

    @ManyToOne
    @JoinColumn(name = "vacation_group_id")
    private VacationGroup vacationGroup;

    @Column
    private Double requested;

}
