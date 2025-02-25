package com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out;

import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.Event;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.model.User;

import java.util.List;

public record RankingPrettyNameOutDTO(List<UserIndicationDTO> ranking)  {

}
