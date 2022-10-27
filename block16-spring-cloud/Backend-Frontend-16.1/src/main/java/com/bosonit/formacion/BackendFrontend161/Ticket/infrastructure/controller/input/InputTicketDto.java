package com.bosonit.formacion.BackendFrontend161.Ticket.infrastructure.controller.input;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class InputTicketDto {
    Long passengerId;
    String passengerName;
    String passengerLastName;
    String passengerEmail;
    String tripOrigin;
    String tripDestination;
    LocalDateTime departureDate;
    LocalDateTime arrivalDate;
}
