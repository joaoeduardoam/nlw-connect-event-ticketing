package com.joaoeduardoam.nlw_connect_event_ticketing.business.mapper;


import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.in.EventInDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out.EventOutDTO;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.Event;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IEventMapper {

    Event toEntity(EventInDTO inDTO);

    EventOutDTO toEventOutDTO (Event event);

}
