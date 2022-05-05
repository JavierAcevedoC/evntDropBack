package com.lovecraft.evntDrop.ticket.domain;

import com.lovecraft.evntDrop.Place.domain.Place;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ticket", indexes = {
        @Index(name = "ticket_place_id_key", columnList = "place_id", unique = true)
})
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id", nullable = false)
    private Integer id;

    public Ticket() {
    }

    public Ticket(String eventName, LocalDate eventDate, Long placeId) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.place = new Place(placeId);

        this.code = String.valueOf(this.hashCode());
        this.description = this.eventName + " will play " + this.eventDate;
        this.lastUpdate = LocalDate.now();
    }

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Column(name = "description")
    private String description;

    @Column(name = "code")
    private String code;

    @Column(name = "last_update")
    private LocalDate lastUpdate;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                ", eventName='" + eventName + '\'' +
                ", eventDate=" + eventDate +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", place=" + place.toString() +
                '}';
    }
}