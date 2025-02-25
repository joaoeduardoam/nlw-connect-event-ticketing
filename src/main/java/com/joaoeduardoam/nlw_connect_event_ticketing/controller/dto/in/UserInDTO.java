package com.joaoeduardoam.nlw_connect_event_ticketing.controller.dto.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserInDTO(@NotNull String name, @NotNull @Email String email)  {

}
