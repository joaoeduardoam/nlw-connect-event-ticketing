package com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotNull
    @Column(name = "user_name", length = 255, nullable = false)
    private String name;

    @NotNull
    @Column(name = "user_email",unique = true)
    private String email;

}
