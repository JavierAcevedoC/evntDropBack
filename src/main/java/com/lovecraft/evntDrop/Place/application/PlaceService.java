package com.lovecraft.evntDrop.Place.application;

import com.lovecraft.evntDrop.Place.domain.Place;
import com.lovecraft.evntDrop.Place.infraestructure.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    PlaceService(PlaceRepository placeRepository){
        this.placeRepository = placeRepository;
    }

    public List<Place> getAvailablesPlaces(){
        return this.placeRepository.findAll(
                Sort.by(Sort.Direction.ASC, "state")
        );
    }

    public Place getPlaceById(Long id){
        return this.placeRepository.findById(id).get();
    }

    public void updatePlace(Place placeToUpdate){
        this.placeRepository.save(placeToUpdate);
    }
}
