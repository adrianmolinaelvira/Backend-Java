package com.bosonit.formacion.BackendFrontend161.Ticket.domain;

import com.bosonit.formacion.BackendFrontend161.Ticket.infrastructure.controller.input.InputTicketDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue
    Long id;
    Long passengerId;
    String passengerName;
    String passengerLastName;
    String passengerEmail;
    String tripOrigin;
    String tripDestination;
    LocalDateTime departureDate;
    LocalDateTime arrivalDate;

    public Ticket(InputTicketDto inputTicketDto){
        setPassengerId(inputTicketDto.getPassengerId());
        setPassengerName(inputTicketDto.getPassengerName());
        setPassengerLastName(inputTicketDto.getPassengerLastName());
        setPassengerEmail(inputTicketDto.getPassengerEmail());
        setTripOrigin(inputTicketDto.getTripOrigin());
        setTripDestination(inputTicketDto.getTripDestination());
        setDepartureDate(inputTicketDto.getDepartureDate());
        setArrivalDate(inputTicketDto.getArrivalDate());
    }
}
