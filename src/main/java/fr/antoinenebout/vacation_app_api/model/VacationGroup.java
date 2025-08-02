package fr.antoinenebout.vacation_app_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "vacationsgroup")
public class VacationGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    @Column
    private String name;

    @Column
    private Date start_date;

    @Column
    private Date end_date;

    @OneToMany(mappedBy = "vacationGroup")
    private List<Vacation> vacations = new ArrayList<>();

}
