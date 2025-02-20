package com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.in;

import jakarta.validation.constraints.Email;

public record UserInDTO(String name, @Email String email)  {

}
