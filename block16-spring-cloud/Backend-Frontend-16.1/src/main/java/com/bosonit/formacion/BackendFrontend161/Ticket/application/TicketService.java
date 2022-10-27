package com.bosonit.formacion.BackendFrontend161.Ticket.application;

import com.bosonit.formacion.BackendFrontend161.Ticket.infrastructure.controller.output.OutputTicketDto;

public interface TicketService {
    public OutputTicketDto createTicket(Long userID, Long tripId);
    public OutputTicketDto findTicketById(Long ticketId);
    public String deleteTicketById(Long ticketId);
}
