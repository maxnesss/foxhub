package com.gfa.foxbook.foxbook.services;

import com.gfa.foxbook.foxbook.models.nonusermodels.ColorPersonality;
import com.gfa.foxbook.foxbook.repositories.ColorPersonalityRepository;
import com.gfa.foxbook.foxbook.services.interfaces.ColorPersonalityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorPersonalityServiceImpl implements ColorPersonalityService {

    private final ColorPersonalityRepository colorPersonalityRepository;

    public ColorPersonalityServiceImpl(ColorPersonalityRepository colorPersonalityRepository) {
        this.colorPersonalityRepository = colorPersonalityRepository;
    }

    @Override
    public List<ColorPersonality> getAllColorPersonalities() {
        return colorPersonalityRepository.findAll();
    }
}
