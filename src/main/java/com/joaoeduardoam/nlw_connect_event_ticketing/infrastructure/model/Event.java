package com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model;


import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer eventId;

    @NotNull
    private String title;

    @NotNull
    @Column(unique = true)
    private String prettyName;

    @NotNull
    private String location;

    @NotNull
    private Double price;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalTime startTime;

    private LocalTime endTime;

    @PrePersist
    private void prePersist(){
        this.prettyName = title.toLowerCase().replace(" ", "-");
    }



}

