package com.bosonit.formacion.Backend161.Travel.Infrastructure.Controller.Input;

import com.bosonit.formacion.Backend161.Client.Domain.Client;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class InputTravelDto {
    String origin;
    String destination;
    LocalDateTime departureDate;
    LocalDateTime arrivalDate;
    Boolean status;
}
