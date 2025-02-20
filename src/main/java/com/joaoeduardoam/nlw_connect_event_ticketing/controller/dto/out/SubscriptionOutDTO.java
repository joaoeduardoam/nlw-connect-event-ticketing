package com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out;

import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.Event;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.User;

import java.time.LocalDate;
import java.time.LocalTime;

public record SubscriptionOutDTO(Integer subscriptionNumber, Event event, User subscriber, User indication, String designation)  {

}
