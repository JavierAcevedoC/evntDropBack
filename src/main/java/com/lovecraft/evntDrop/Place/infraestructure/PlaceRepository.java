package com.lovecraft.evntDrop.Place.infraestructure;

import com.lovecraft.evntDrop.Place.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository
        extends JpaRepository<Place, Long> {
}
