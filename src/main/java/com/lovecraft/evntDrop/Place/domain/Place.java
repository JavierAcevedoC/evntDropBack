package com.lovecraft.evntDrop.Place.domain;

import javax.persistence.*;

@Entity
@Table(name = "place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id", nullable = false)
    private Long id;

    @Column(name = "seat")
    private Integer seat;

    @Column(name = "sector", length = 2)
    private String sector;


    @Column(name = "state")
    private Integer state;

    @Column(name = "\"row\"")
    private Integer row;

    public Place() {
    }

    public Place(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String
    toString() {
        return "Place{" +
                ", seat=" + seat +
                ", sector='" + sector + '\'' +
                ", state=" + state +
                ", row=" + row +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


}