package com.gfa.foxbook.foxbook.services;

import com.gfa.foxbook.foxbook.models.nonusermodels.Personality;
import com.gfa.foxbook.foxbook.repositories.PersonalityRepository;
import com.gfa.foxbook.foxbook.services.interfaces.PersonalityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalityServiceImpl implements PersonalityService {

    private final PersonalityRepository personalityRepository;

    public PersonalityServiceImpl(PersonalityRepository personalityRepository) {
        this.personalityRepository = personalityRepository;
    }

   @Override
    public List<Personality> getAllPersonalities() {
        return personalityRepository.findAll();
    }
}
