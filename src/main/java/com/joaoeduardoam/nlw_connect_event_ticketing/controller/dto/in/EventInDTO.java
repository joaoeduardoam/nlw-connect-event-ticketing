package com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.in;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record EventInDTO(String title, String location, Double price,
                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
                              LocalDate startDate,
                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
                              LocalDate endDate,
                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
                              LocalTime startTime,
                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
                              LocalTime endTime)  {

}
