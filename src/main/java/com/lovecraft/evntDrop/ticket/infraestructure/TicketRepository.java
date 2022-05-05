package com.lovecraft.evntDrop.ticket.infraestructure;

import com.lovecraft.evntDrop.ticket.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository
        extends JpaRepository<Ticket, Long> {
    Ticket findByCode(String code);
}
