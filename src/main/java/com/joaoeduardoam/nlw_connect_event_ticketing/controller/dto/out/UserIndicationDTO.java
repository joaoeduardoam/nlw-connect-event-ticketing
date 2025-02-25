package com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out;

import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.Event;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.User;

public record UserIndicationDTO(Integer userId, String userName, Integer indications)  {

}
