package com.bosonit.formacion.BackendFrontend161.Ticket.application;

import com.bosonit.formacion.BackendFrontend161.Client.Infrastructure.Controller.ClientService;
import com.bosonit.formacion.BackendFrontend161.Client.Infrastructure.Controller.Output.OutputClientDto;
import com.bosonit.formacion.BackendFrontend161.Exceptions.EntityNotFoundException;
import com.bosonit.formacion.BackendFrontend161.Exceptions.UnprocessableEntityException;
import com.bosonit.formacion.BackendFrontend161.Ticket.domain.Ticket;
import com.bosonit.formacion.BackendFrontend161.Ticket.infrastructure.controller.output.OutputTicketDto;
import com.bosonit.formacion.BackendFrontend161.Ticket.infrastructure.repository.TicketRepository;

import com.bosonit.formacion.BackendFrontend161.Travel.Infrastructure.Controller.TravelService;
import com.bosonit.formacion.BackendFrontend161.Travel.Infrastructure.Controller.Output.OutputTravelDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TickerServiceImp implements TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ClientService clientService;
    @Autowired
    TravelService travelService;

    @Override
    public OutputTicketDto generateTicket(Long userID, Long tripId) {

        OutputClientDto outputClientDto = clientService.findById(userID);
        OutputTravelDto outputTravelDto = travelService.findById(tripId);

        if(outputClientDto == null)
            throw new EntityNotFoundException("Client does not exist");
        if(outputTravelDto == null)
            throw new EntityNotFoundException("Trip does not exist");

        Ticket newTicket = new Ticket(outputClientDto.getId(), outputClientDto.getName(),
                outputClientDto.getSurname(), outputClientDto.getEmail(), outputTravelDto.getOrigin(),
                outputTravelDto.getDestination(), outputTravelDto.getDepartureDate(), outputTravelDto.getArrivalDate());

        OutputTravelDto testTravel = travelService.addPassenger(tripId, userID);

        if(testTravel == null)
            throw new UnprocessableEntityException("Passenger could not be added to the trip");

        ticketRepository.save(newTicket);

        return new OutputTicketDto(newTicket);
    }
}
