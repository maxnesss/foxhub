package com.gfa.foxbook.foxbook.services;

import com.gfa.foxbook.foxbook.models.nonusermodels.Technology;
import com.gfa.foxbook.foxbook.repositories.TechnologyRepository;
import com.gfa.foxbook.foxbook.services.interfaces.TechnologyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public List<Technology> getAllTechnologies() {
        return technologyRepository.findAll();
    }
}
