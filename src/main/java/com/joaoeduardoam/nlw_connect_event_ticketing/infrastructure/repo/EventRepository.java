package com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.repo;

import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Integer> {
    public Optional<Event> findByPrettyName(String prettyName);
}
