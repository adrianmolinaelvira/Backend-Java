package com.bosonit.formacion.BackendFrontend161.Ticket.infrastructure.controller.output;

import com.bosonit.formacion.BackendFrontend161.Ticket.domain.Ticket;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OutputTicketDto {
    Long id;
    Long passengerId;
    String passengerName;
    String passengerLastName;
    String passengerEmail;
    String tripOrigin;
    String tripDestination;
    LocalDateTime departureDate;
    LocalDateTime arrivalDate;

    public OutputTicketDto(Ticket ticket){
        setId(ticket.getId());
        setPassengerId(ticket.getPassengerId());
        setPassengerName(ticket.getPassengerName());
        setPassengerLastName(ticket.getPassengerLastName());
        setPassengerEmail(ticket.getPassengerEmail());
        setTripOrigin(ticket.getTripOrigin());
        setTripDestination(ticket.getTripDestination());
        setDepartureDate(ticket.getDepartureDate());
        setArrivalDate(ticket.getArrivalDate());
    }
}
