package com.gfa.foxbook.foxbook.loaders;

import com.gfa.foxbook.foxbook.models.nonusermodels.ColorPersonality;
import com.gfa.foxbook.foxbook.repositories.ColorPersonalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ColorPersonalityDataLoader implements CommandLineRunner {

    private final ColorPersonalityRepository colorPersonalityRepository;

    @Autowired
    public ColorPersonalityDataLoader(ColorPersonalityRepository colorPersonalityRepository) {
        this.colorPersonalityRepository = colorPersonalityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (colorPersonalityRepository.findAll().isEmpty()) {
            loadInitialColorPersonalities();
        }
    }

    private void loadInitialColorPersonalities() {

        ColorPersonality red = createColorPersonality("Red", "Energetic and passionate.");
        ColorPersonality blue = createColorPersonality("Blue", "Calm and introspective.");
        ColorPersonality green = createColorPersonality("Green", "Harmonious and nature-loving.");
        ColorPersonality yellow = createColorPersonality("Yellow", "Optimistic and joyful.");

        ColorPersonality[] colorPersonalities = {red, blue, green, yellow};
        colorPersonalityRepository.saveAll(Arrays.asList(colorPersonalities));
    }

    private ColorPersonality createColorPersonality(String name, String description) {
        ColorPersonality colorPersonality = new ColorPersonality();
        colorPersonality.setName(name);
        colorPersonality.setDescription(description);
        return colorPersonality;
    }
}
