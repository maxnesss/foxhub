package com.gfa.foxbook.foxbook.services;

import com.gfa.foxbook.foxbook.models.nonusermodels.SpiritAnimal;
import com.gfa.foxbook.foxbook.repositories.SpiritAnimalRepository;
import com.gfa.foxbook.foxbook.services.interfaces.SpiritAnimalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpiritAnimalServiceImpl implements SpiritAnimalService {

    private final SpiritAnimalRepository spiritAnimalRepository;

    public SpiritAnimalServiceImpl(SpiritAnimalRepository spiritAnimalRepository) {
        this.spiritAnimalRepository = spiritAnimalRepository;
    }

    @Override
    public List<SpiritAnimal> getAllSpiritAnimals() {
        return spiritAnimalRepository.findAll();
    }
}
