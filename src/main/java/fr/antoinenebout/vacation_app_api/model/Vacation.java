package fr.antoinenebout.vacation_app_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vacations")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "vacation_type")
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
