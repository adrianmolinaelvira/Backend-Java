package com.bosonit.formacion.BackendFrontend161.Ticket.infrastructure.controller;

import com.bosonit.formacion.BackendFrontend161.Ticket.application.TicketService;
import com.bosonit.formacion.BackendFrontend161.Ticket.infrastructure.controller.output.OutputTicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateTicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/generateTicket/{userId}/{tripId}")
    public OutputTicketDto generateTicket(@PathVariable("userId") Long userID, @PathVariable("tripId") Long tripId){
        return ticketService.generateTicket(userID, tripId);
    }
}
