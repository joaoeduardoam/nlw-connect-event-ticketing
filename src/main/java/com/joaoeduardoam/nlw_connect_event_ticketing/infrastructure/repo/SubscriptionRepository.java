package com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.repo;

import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.Event;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.Subscription;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    public Optional<Subscription> findByEventAndSubscriber(Event event, User user);
}
