package com.bosonit.formacion.BackendFrontend161.Travel.Infrastructure.Controller.Input;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InputTravelDto {
    String origin;
    String destination;
    LocalDateTime departureDate;
    LocalDateTime arrivalDate;
    Boolean status;
}
