package com.gfa.foxbook.foxbook.loaders;

import com.gfa.foxbook.foxbook.models.nonusermodels.Location;
import com.gfa.foxbook.foxbook.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class LocationDataLoader implements CommandLineRunner {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationDataLoader(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (locationRepository.findAll().isEmpty()) {
            loadInitialCities();
        }
    }

    private void loadInitialCities() {
        List<String> locationsList = Arrays.asList(
                "Praha",
                "Brno",
                "Ostrava",
                "Plzen",
                "Liberec",
                "Olomouc",
                "Usti nad Labem",
                "Hradec Kralove",
                "Pardubice",
                "Zlin",
                "Ceske Budejovice",
                "Havirov",
                "Kladno",
                "Most",
                "Opava",
                "Frydek-Mistek",
                "Karvina",
                "Jihlava",
                "Teplice",
                "Decin",
                "Chomutov",
                "Jablonec nad Nisou",
                "Mlada Boleslav",
                "Prostejov",
                "Trebic",
                "Prerov",
                "Karlovy Vary",
                "Kolin",
                "Havirov",
                "Tabor"
        );

        for (String city : locationsList) {
            Location location = new Location();
            location.setName(city);
            locationRepository.save(location);
        }
    }
}
