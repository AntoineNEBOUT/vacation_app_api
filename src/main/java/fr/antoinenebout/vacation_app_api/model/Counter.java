package fr.antoinenebout.vacation_app_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "counters")
public class Counter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "vacation_type_id")
    private VacationType vacationType;

    @Column
    private Long yearly_total;

    @Column
    private Long requested;

    @Column
    private Long validated;

    @Column
    private Long remaining;

}
