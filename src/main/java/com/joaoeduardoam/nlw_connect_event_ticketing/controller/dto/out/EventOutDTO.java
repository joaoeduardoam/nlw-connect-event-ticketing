package com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.out;

import java.time.LocalDate;
import java.time.LocalTime;

public record EventOutDTO(Integer eventId, String title, String prettyName, String location, Double price,
                          LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime)  {

}
