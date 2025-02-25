package com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.repo;

import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out.UserIndicationDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.Event;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Integer> {
    public Optional<Event> findByPrettyName(String prettyName);


}
