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
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;

@Service
public class TicketServiceImp implements TicketService {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ClientService clientService;
    @Autowired
    TravelService travelService;

    @Override
    public OutputTicketDto generateTicket(Long userID, Long tripId) {

        Optional<ServiceInstance> serviceInstance = discoveryClient.getInstances("backend").stream().findFirst();
        URI baseUrl = serviceInstance.orElseThrow(() -> new EntityNotFoundException("No services avaiable")).getUri(); //To get the actual URI, and use it instead of the default defined.

        OutputClientDto outputClientDto = clientService.findById(baseUrl, userID);
        OutputTravelDto outputTravelDto = travelService.findById(baseUrl, tripId);

        if(outputClientDto == null)
            throw new EntityNotFoundException("Client does not exist");
        if(outputTravelDto == null)
            throw new EntityNotFoundException("Trip does not exist");

        Ticket newTicket = new Ticket(outputClientDto.getId(), outputClientDto.getName(),
                outputClientDto.getSurname(), outputClientDto.getEmail(), outputTravelDto.getOrigin(),
                outputTravelDto.getDestination(), outputTravelDto.getDepartureDate(), outputTravelDto.getArrivalDate());

        OutputTravelDto testTravel = travelService.addPassenger(baseUrl, tripId, userID);

        if(testTravel == null)
            throw new UnprocessableEntityException("Passenger could not be added to the trip");

        ticketRepository.save(newTicket);

        return new OutputTicketDto(newTicket);
    }
}
