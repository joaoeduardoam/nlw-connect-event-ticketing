package com.joaoeduardoam.nlw_connect_event_ticketing.business.mapper;


import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.in.EventInDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.in.UserInDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out.EventOutDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out.SubscriptionOutDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.Event;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.Subscription;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.User;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IMapper {

    Event toEvent(EventInDTO inDTO);

    EventOutDTO toEventOutDTO (Event event);

    SubscriptionOutDTO toSubscriptionOutDTO (Subscription subscription);

    User toUser (UserInDTO userInDTO);



}
