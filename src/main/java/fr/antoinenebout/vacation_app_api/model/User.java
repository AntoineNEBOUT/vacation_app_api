package fr.antoinenebout.vacation_app_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String company_name;

    @OneToMany(mappedBy = "user")
    private List<Counter> counters = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Vacation> vacations = new ArrayList<>();
}
