package com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.repo;

import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.Event;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.Subscription;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

    public Optional<Subscription> findByEventAndSubscriber(Event event, User subscriber);

    public List<Subscription> findByEventAndIndication(Event event, User indication);

    public List<Subscription> findByEvent(Event event);

    @Query("""
                SELECT u.userId AS userId, u.name AS userName, COUNT(s) AS indicationCount
                FROM Subscription s
                JOIN s.event e
                JOIN s.indication u
                WHERE e.prettyName = :prettyName
                GROUP BY u.userId, u.name
                ORDER BY indicationCount desc
            """)
    List<UserIndicationProjection> findIndicationsByPrettyName(@Param("prettyName") String prettyName);
}
