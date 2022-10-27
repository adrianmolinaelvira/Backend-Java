package com.bosonit.formacion.BackendFrontend161.Ticket.infrastructure.repository;

import com.bosonit.formacion.BackendFrontend161.Ticket.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
