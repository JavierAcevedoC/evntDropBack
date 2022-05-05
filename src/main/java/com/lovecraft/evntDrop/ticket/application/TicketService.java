package com.lovecraft.evntDrop.ticket.application;

import com.lovecraft.evntDrop.Place.application.PlaceService;
import com.lovecraft.evntDrop.Place.domain.Place;
import com.lovecraft.evntDrop.ticket.domain.Ticket;
import com.lovecraft.evntDrop.ticket.infraestructure.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private PlaceService placeService;

    TicketService(
            TicketRepository ticketRepository,
            PlaceService placeService
    ){
        this.placeService = placeService;
        this.ticketRepository = ticketRepository;
    }
    public List<Ticket> getTickets() {
        return this.ticketRepository.findAll();
    }

    public Ticket getTicketByCode(String code) {
        return this.ticketRepository.findByCode(code);
    }

    public Ticket createTicket(String name, LocalDate localDate, Long placeId) {
        Ticket ticketToCreate = new Ticket(name, localDate, placeId);

        // Space to update table place //
        Place placeToUpdate = this.placeService.getPlaceById(placeId);
        placeToUpdate.setState(1);

        ticketToCreate.setPlace(placeToUpdate);
        this.ticketRepository.save(ticketToCreate);
        this.placeService.updatePlace(placeToUpdate);

        return ticketToCreate;
    }
}
