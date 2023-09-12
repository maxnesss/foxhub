package com.gfa.foxbook.foxbook.services;

import com.gfa.foxbook.foxbook.models.nonusermodels.Location;
import com.gfa.foxbook.foxbook.repositories.LocationRepository;
import com.gfa.foxbook.foxbook.services.interfaces.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }


    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
