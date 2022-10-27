package com.bosonit.formacion.BackendFrontend161.Ticket.application;

import com.bosonit.formacion.BackendFrontend161.Ticket.infrastructure.controller.output.OutputTicketDto;
import org.springframework.stereotype.Service;

@Service
public class TickerServiceImp implements TicketService {
    @Override
    public OutputTicketDto createTicket(Long userID, Long tripId) {
        return null;
    }

    @Override
    public OutputTicketDto findTicketById(Long ticketId) {
        return null;
    }

    @Override
    public String deleteTicketById(Long ticketId) {
        return null;
    }
}
