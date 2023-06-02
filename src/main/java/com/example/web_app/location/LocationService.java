package com.example.web_app.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public Location insert(Location location) {
        location.setDone_time(LocalDateTime.now());
        return locationRepository.save(location);
    }

    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    public Location getById(int id) {
        return locationRepository.findById(id).get();
    }

    public void deleteById(int id) {
        locationRepository.deleteById(id);
    }

    public void delete(Location location) {
        locationRepository.delete(location);
    }
}
