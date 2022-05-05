package com.lovecraft.evntDrop.ticket.infraestructure;

import com.lovecraft.evntDrop.ticket.application.TicketService;

import com.lovecraft.evntDrop.ticket.domain.Ticket;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController()
@RequestMapping("api/v1/tickets")
public record TicketController(TicketService ticketService) {
    static Logger log = Logger.getLogger("TicketLog");

    @Autowired
    public TicketController {
    }

    @GetMapping()
    public List<Ticket> getTickets() {
        return this.ticketService.getTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicketByCode(@PathVariable Long id) {
        return this.ticketService.getTicketByCode(String.valueOf(id));
    }

    @PostMapping()
    public String createTicket(@RequestBody @NotNull Ticket entryTicket) {
        this.log.info(entryTicket.toString());

        return this.ticketService.createTicket(
                entryTicket.getEventName(),
                entryTicket.getEventDate(),
                entryTicket.getPlace().getId()
        ).toString();
    }
}
