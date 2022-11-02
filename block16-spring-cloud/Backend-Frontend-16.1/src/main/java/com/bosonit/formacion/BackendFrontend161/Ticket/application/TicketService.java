package com.bosonit.formacion.BackendFrontend161.Ticket.application;

import com.bosonit.formacion.BackendFrontend161.Ticket.infrastructure.controller.output.OutputTicketDto;

public interface TicketService {
    public OutputTicketDto generateTicket(Long userID, Long tripId);

}
