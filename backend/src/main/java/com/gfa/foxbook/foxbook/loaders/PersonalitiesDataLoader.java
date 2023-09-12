package com.gfa.foxbook.foxbook.loaders;

import com.gfa.foxbook.foxbook.models.nonusermodels.Personality;
import com.gfa.foxbook.foxbook.repositories.PersonalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PersonalitiesDataLoader implements CommandLineRunner {

    private final PersonalityRepository personalityRepository;

    @Autowired
    public PersonalitiesDataLoader(PersonalityRepository personalityRepository) {
        this.personalityRepository = personalityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (personalityRepository.findAll().isEmpty()) {
            loadInitialPersonalities();
        }
    }

    private void loadInitialPersonalities() {
        Personality architect = createPersonality("Architect", "INTJ",
                "Imaginative and strategic thinkers, with a plan for everything.",
                "Elon Musk, Mark Zuckerberg, Stephen Hawking, Isaac Newton, Nikola Tesla");
        Personality logician = createPersonality("Logician", "INTP",
                "Innovative inventors with an unquenchable thirst for knowledge.",
                "Albert Einstein, Bill Gates, Carl Jung, Marie Curie, Charles Darwin");
        Personality commander = createPersonality("Commander", "ENTJ",
                "Bold, imaginative, and strong-willed leaders, always finding a way - or making one.",
                "Steve Jobs, Margaret Thatcher, Julius Caesar, Franklin D. Roosevelt");
        Personality debater = createPersonality("Debater", "ENTP",
                "Smart and curious thinkers who cannot resist an intellectual challenge.",
                "Thomas Edison, Alexander the Great, Leonardo da Vinci, Richard Feynman");
        Personality advocate = createPersonality("Advocate", "INFJ",
                "Quiet and mystical, yet very inspiring and tireless idealists.",
                "Martin Luther King Jr., Mahatma Gandhi, Mother Teresa, Nelson Mandela");
        Personality mediator = createPersonality("Mediator", "INFP",
                "Poetic, kind, and altruistic people, always eager to help a good cause.",
                "William Shakespeare, J.R.R. Tolkien, Johnny Depp, Alicia Keys, Kurt Cobain");
        Personality protagonist = createPersonality("Protagonist", "ENFJ",
                "Charismatic and inspiring leaders, able to mesmerize their listeners.",
                "Barack Obama, Oprah Winfrey, John F. Kennedy, Benito Mussolini");
        Personality campaigner = createPersonality("Campaigner", "ENFP",
                "Enthusiastic, creative, and sociable free spirits who can always find a reason to smile.",
                "Robert Downey Jr., Walt Disney, Mark Twain, Robin Williams, Quentin Tarantino");
        Personality logistician = createPersonality("Logistician", "ISTJ",
                "Practical and fact-minded individuals, whose reliability cannot be doubted.",
                "George Washington, Angela Merkel, Warren Buffett, George H.W. Bush");
        Personality defender = createPersonality("Defender", "ISFJ",
                "Very dedicated and warm protectors, always ready to defend their loved ones.",
                "Desmond Doss, Mother Teresa, Queen Elizabeth II, Rosa Parks");
        Personality executive = createPersonality("Executive", "ESTJ",
                "Excellent administrators, unsurpassed at managing things or people.",
                "Franklin D. Roosevelt, Julius Caesar, Al Capone, Steve Ballmer");
        Personality consul = createPersonality("Consul", "ESFJ",
                "Extraordinarily caring, social, and popular people, always eager to help.",
                "Taylor Swift, Jennifer Garner, Jennifer Lopez, Hugh Jackman");
        Personality virtuoso = createPersonality("Virtuoso", "ISTP",
                "Bold and practical experimenters, masters of all kinds of tools.",
                "Bruce Lee, Amelia Earhart, Michael Jordan, Bear Grylls");
        Personality adventurer = createPersonality("Adventurer", "ISFP",
                "Flexible and charming artists, always ready to explore and experience something new.",
                "Bob Dylan, Lady Gaga, Britney Spears, Kevin Costner");
        Personality entrepreneur = createPersonality("Entrepreneur", "ESTP",
                "Smart, energetic, and very perceptive people, who truly enjoy living on the edge.",
                "Theodore Roosevelt, Donald Trump, Madonna, P.T. Barnum");
        Personality entertainer = createPersonality("Entertainer", "ESFP",
                "Spontaneous, energetic, and enthusiastic entertainers, who love the spotlight.",
                "Marilyn Monroe, Elvis Presley, Freddie Mercury, Jamie Oliver");

        // Save each personality to the repository
        Personality[] personalities = {architect, logician, commander, debater, advocate,
                mediator, protagonist, campaigner, logistician, defender, executive, consul,
                virtuoso, adventurer, entrepreneur, entertainer};
        personalityRepository.saveAll(Arrays.asList(personalities));
    }

    private Personality createPersonality(String name, String type, String description, String eg) {
        Personality personality = new Personality();
        personality.setName(name);
        personality.setType(type);
        personality.setDescription(description);
        personality.setEg(eg);
        return personality;
    }
}

