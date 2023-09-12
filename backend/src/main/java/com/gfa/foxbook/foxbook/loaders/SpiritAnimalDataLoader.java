package com.gfa.foxbook.foxbook.loaders;

import com.gfa.foxbook.foxbook.models.nonusermodels.SpiritAnimal;
import com.gfa.foxbook.foxbook.repositories.SpiritAnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SpiritAnimalDataLoader implements CommandLineRunner {

    private final SpiritAnimalRepository spiritAnimalRepository;

    @Autowired
    public SpiritAnimalDataLoader(SpiritAnimalRepository spiritAnimalRepository) {
        this.spiritAnimalRepository = spiritAnimalRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (spiritAnimalRepository.findAll().isEmpty()) {
            loadInitialSpiritAnimals();
        }
    }

    private void loadInitialSpiritAnimals() {
        SpiritAnimal ant = createSpiritAnimal("Ant", "Diligence, unity, patience, self-control, sacrifice, loyalty and honesty.");
        SpiritAnimal alligator = createSpiritAnimal("Alligator", "Retribution, creativity, efficiency, hostility, bravery, and efficiency.");
        SpiritAnimal anaconda = createSpiritAnimal("Anaconda", "Balance, immortality, patience, power, wisdom, cunning, and elusiveness.");
        SpiritAnimal albatross = createSpiritAnimal("Albatross", "Liberated, travel, limitless, good fate, sensitive and thoughtfulness.");
        SpiritAnimal antelope = createSpiritAnimal("Antelope", "Efficacious, energetic, defensive, perceptive, keen eyesight and risk-taker.");
        SpiritAnimal armadillo = createSpiritAnimal("Armadillo", "Sensitive, defensive, trustworthy, calm, isolated and humble.");
        SpiritAnimal beaver = createSpiritAnimal("Beaver", "Determined, visionary, defensive, inventor, fantasizer and subliminal.");
        SpiritAnimal buffalo = createSpiritAnimal("Buffalo", "Divine, strength, balance, thankfulness, wealth and firmness.");
        SpiritAnimal bat = createSpiritAnimal("Bat", "Ego, fear, challenge, keen-observation, inner-depth, illusion and clairvoyance.");
        SpiritAnimal bear = createSpiritAnimal("Bear", "Power, Bravery, understanding, peace, aggressive, authority, solitude and majesty.");
        SpiritAnimal bee = createSpiritAnimal("Bee", "Communication, love, success, wisdom, wealth, hard work, protection and chastity.");
        SpiritAnimal blackSwan = createSpiritAnimal("Black Swan", "Empathy, freedom, joy, dignity, loyalty and exposition.");
        SpiritAnimal butterfly = createSpiritAnimal("Butterfly", "Joy, romance, celebration, transformation, spirituality, creativity, and peace.");
        SpiritAnimal bluebird = createSpiritAnimal("Bluebird", "Flexibility, innovative, kindness, thankfulness, togetherness and glory.");
        SpiritAnimal bull = createSpiritAnimal("Bull", "Fertility, expressive, strength, courage, procurement and hasty.");
        SpiritAnimal cardinal = createSpiritAnimal("Cardinal", "Cheerful, brilliant, bold, extraordinary, dignity and trust.");
        SpiritAnimal camel = createSpiritAnimal("Camel", "Endurance, trust, commitment, determination, focus, humility, patience, and durability.");
        SpiritAnimal cheetah = createSpiritAnimal("Cheetah", "Quick thinking, passion, flexibility, quick-witted, freedom, progress, and protection.");
        SpiritAnimal cat = createSpiritAnimal("Cat", "Magic, curiosity, affection, observational-skills, secretive, supernatural, and mystery.");
        SpiritAnimal cougar = createSpiritAnimal("Cougar", "Patience, observation, sensuality, courage, responsible, dependable and spiritual warrior.");
        SpiritAnimal cuckoo = createSpiritAnimal("Cuckoo", "Flexibility, love, fortune, balance, shrewdness and insightful.");
        SpiritAnimal caribou = createSpiritAnimal("Caribou", "Nomad, flexibility, sensitive, guidance and assurance.");
        SpiritAnimal crane = createSpiritAnimal("Crane", "Isolated, integrity, endurance, attentive, self-reliant and wisdom.");
        SpiritAnimal crow = createSpiritAnimal("Crow", "Magical, fearless, adaptability, manipulative, wisdom and transformation.");
        SpiritAnimal deer = createSpiritAnimal("Deer", "Love, generosity, elegance, grace, compassion, caring, safety, and determination.");
        SpiritAnimal dove = createSpiritAnimal("Dove", "Purity, gentleness, devotion, hope, love, communication, peace, and sacrifice.");
        SpiritAnimal dog = createSpiritAnimal("Dog", "Loyalty, bravery, friends, affection, protection, communication, patience, and devotion.");
        SpiritAnimal dolphin = createSpiritAnimal("Dolphin", "Harmony, defensive, assistance, resurgence, lively and strength.");
        SpiritAnimal dragon = createSpiritAnimal("Dragon", "Transformation, defensive, motivational, authoritative, magical and strength.");
        SpiritAnimal dragonfly = createSpiritAnimal("Dragonfly", "Transformation, lively, flexibility, connection, emotional and illusionary.");
        SpiritAnimal eagle = createSpiritAnimal("Eagle", "Goal-oriented, focused, adventurous, resilient, vision, power and freedom.");
        SpiritAnimal elephant = createSpiritAnimal("Elephant", "Strength, loyalty, determination, confidence, honor, pride, dignity, and royalty.");
        SpiritAnimal emu = createSpiritAnimal("Emu", "Flexibility, unity, expressive, lively, equality and transit.");
        SpiritAnimal elk = createSpiritAnimal("Elk", "Strength, self-reliant, cleverness, magnificent, generosity and dignity.");
        SpiritAnimal falcon = createSpiritAnimal("Falcon", "Goal-oriented, fearless, authoritative, freedom, intelligence and victory.");
        SpiritAnimal flamingo = createSpiritAnimal("Flamingo", "Balance, goal-oriented, clear-sightedness, love, power, balance, and happiness.");
        SpiritAnimal fox = createSpiritAnimal("Fox", "Quick-witted, wisdom, luck, cleverness, curiosity, cunning, adaptability, and playfulness.");
        SpiritAnimal frog = createSpiritAnimal("Frog", "Transformation, sensitivity, peace, fertility, cleansing, rebirth, peace and power.");
        SpiritAnimal gazelle = createSpiritAnimal("Gazelle", "Alert, swift, consciousness, anticipation, refinement and lightness.");
        SpiritAnimal goat = createSpiritAnimal("Goat", "Firmness, self-reliant, isolated, vigor, alert and strength.");
        SpiritAnimal grasshopper = createSpiritAnimal("Grasshopper", "Good fate, wealth, innovative, visionary, dynamic and progressive.");
        SpiritAnimal giraffe = createSpiritAnimal("Giraffe", "Individuality, intelligence, peace, farsightedness, cleverness, gentleness and patience.");
        SpiritAnimal goose = createSpiritAnimal("Goose", "Joy, bravery, guidance, fertility, loyalty, reliability, teamwork, vigilance, and wisdom.");
        SpiritAnimal goldfinch = createSpiritAnimal("Goldfinch", "Courageous, defensive, dedication, happiness, luck and originality.");
        SpiritAnimal hawk = createSpiritAnimal("Hawk", "Vision, alertness, nobility, cleansing, goal-oriented, strength, creativity and courage.");
        SpiritAnimal hedgehog = createSpiritAnimal("Hedgehog", "Protection, flexibility, patience, kindness, strength and self-dependent.");
        SpiritAnimal hippopotamus = createSpiritAnimal("Hippopotamus", "Strength, protection, wisdom, hard-working, fertile and balance.");
        SpiritAnimal horse = createSpiritAnimal("Horse", "Freedom, adventurous, freedom, mobility, independence, friendship and endurance.");
        SpiritAnimal heron = createSpiritAnimal("Heron", "Independent, balance, calm, intrusive, multi-tasking and self-determined.");
        SpiritAnimal hummingbird = createSpiritAnimal("Hummingbird", "Flexibility, love, wisdom, hope, healing, ability, ecstasy, and aggression.");
        SpiritAnimal inchworm = createSpiritAnimal("Inchworm", "Logical, transformation, subtlety, concealment, and transmutation.");
        SpiritAnimal jellyfish = createSpiritAnimal("Jellyfish", "Faith, transparency, illumination, acceptance, sensitivity, protection and intention.");
        SpiritAnimal jaguar = createSpiritAnimal("Jaguar", "Power, loyalty, speed, strength, grace, knowledge, fertility and rejuvenation.");
        SpiritAnimal koala = createSpiritAnimal("Koala", "Gratitude, healing, calmness, trust, empathy, magic, protection and pleasure.");
        SpiritAnimal kiwi = createSpiritAnimal("Kiwi", "Alert, fidelity, authoritative, cultural, genius and togetherness.");
        SpiritAnimal ladybug = createSpiritAnimal("Ladybug", "Good fate, true love, innocence, metamorphosis, pious intervention and illusionary.");
        SpiritAnimal lion = createSpiritAnimal("Lion", "Pride, courage, power, natural-born leaders, authority, dignity, wisdom, and fiery.");
        SpiritAnimal lizard = createSpiritAnimal("Lizard", "Imagination, spirituality, sensitivity, adaptability, ego, intrusion, and quick-witted.");
        SpiritAnimal loon = createSpiritAnimal("Loon", "Patience, calm, connection, faithfulness, satisfaction and refreshment.");
        SpiritAnimal magpie = createSpiritAnimal("Magpie", "Flexibility, communicative, fate, love, opportunity and attitude.");
        SpiritAnimal monkey = createSpiritAnimal("Monkey", "Bold, confident, social, compassionate, playful, aggressive, creative and rebellious.");
        SpiritAnimal moose = createSpiritAnimal("Moose", "Endurance, intelligence, dignity, feminine, strength and impulsive.");
        SpiritAnimal mosquito = createSpiritAnimal("Mosquito", "Persistence, feminine, agility, direction, detection, self-confidence, and blunt.");
        SpiritAnimal mouse = createSpiritAnimal("Mouse", "Stealth, modesty, understanding, dishonest, grounded, eye-for-details and innocence.");
        SpiritAnimal mockingbird = createSpiritAnimal("Mockingbird", "Expression, thankfulness, defensive, lively, creativity and togetherness.");
        SpiritAnimal meadowlark = createSpiritAnimal("Meadowlark", "Satisfaction, joy, wisdom, carousal, modesty and manifestation.");
        SpiritAnimal orangutan = createSpiritAnimal("Orangutan", "Creativity, gentle, solitude, ingenuity, honorable and logical.");
        SpiritAnimal opossum = createSpiritAnimal("Opossum", "Wisdom, sensible, humble, togetherness, extraordinary and decisive.");
        SpiritAnimal otter = createSpiritAnimal("Otter", "Lively, cheerful, kindness, sensibility, dynamic and happiness.");
        SpiritAnimal ox = createSpiritAnimal("Ox", "Sacrifice, monogamy, grounded, longevity, strength and loyalty.");
        SpiritAnimal osprey = createSpiritAnimal("Osprey", "Balance, visionary, potentiality, rigor, timing and opportunity.");
        SpiritAnimal owl = createSpiritAnimal("Owl", "Wisdom, secret-keeper, freedom, comfort, stealth, vision, protection and deception.");
        SpiritAnimal panda = createSpiritAnimal("Panda", "Adaptability, balance, determination, willpower, diplomacy, inner-sight, and solitude.");
        SpiritAnimal panther = createSpiritAnimal("Panther", "Courage, valor, power, protective, aggressive and feminine.");
        SpiritAnimal peacock = createSpiritAnimal("Peacock", "Beauty, knowledge, self-esteem, foresight, endurance, royalty, love and sexuality.");
        SpiritAnimal penguin = createSpiritAnimal("Penguin", "Community-minded, grace, discipline, confidence, sacrifice, spiritual and determination.");
        SpiritAnimal pelican = createSpiritAnimal("Pelican", "Strong, selfless, warmth, responsible, defensive and kindness.");
        SpiritAnimal porcupine = createSpiritAnimal("Porcupine", "Innocence, visionary, self-involved, humble, togetherness and anxious.");
        SpiritAnimal rabbit = createSpiritAnimal("Rabbit", "Creativity, prosperity, intensity, love, cleverness, sensitivity, harmony, and imagination.");
        SpiritAnimal rat = createSpiritAnimal("Rat", "Kindness, fertility, foresight, intelligence, abundance, strength, success, and stealth.");
        SpiritAnimal ram = createSpiritAnimal("Ram", "Aloof, sensitive, hard-working, anxious, visionary and transformation.");
        SpiritAnimal rhinoceros = createSpiritAnimal("Rhinoceros", "Intelligence, isolated, decisive, endurance, liberated and insightful.");
        SpiritAnimal raccoon = createSpiritAnimal("Raccoon", "Confidentiality, illusionary, bravery, emphatic, versatility and protection.");
        SpiritAnimal reindeer = createSpiritAnimal("Reindeer", "Accomplishment, abundance, endurance, strength, faith, tenacity and protection.");
        SpiritAnimal rooster = createSpiritAnimal("Rooster", "Fearless, unique, intimacy, ego, nonconformity and intrusive.");
        SpiritAnimal snake = createSpiritAnimal("Snake", "Impulsive, power, shrewdness, transformation, magic, fear, wisdom and healing.");
        SpiritAnimal salmon = createSpiritAnimal("Salmon", "Dignity, seriousness, intelligence, resurgence, spiritual and firmness.");
        SpiritAnimal swan = createSpiritAnimal("Swan", "Grave, purity, love, beauty, power, elegance, devotion, calmness and balance.");
        SpiritAnimal spider = createSpiritAnimal("Spider", "Patience, creativity, protection, growth, aptitude, networking, balance and wisdom.");
        SpiritAnimal sheep = createSpiritAnimal("Sheep", "Compassion, peace, purity, courage, progress, level-headed and humble.");
        SpiritAnimal squirrel = createSpiritAnimal("Squirrel", "Playful, social, balance, passionate, trust, hardworking, and resourcefulness.");
        SpiritAnimal stork = createSpiritAnimal("Stork", "Resurgence, creativity, responsibility, boldness, protective and fertility.");
        SpiritAnimal tiger = createSpiritAnimal("Tiger", "Valor, power, pride, devotion, fearlessness, vigor, passion and royalty.");
        SpiritAnimal turtle = createSpiritAnimal("Turtle", "Wisdom, patience, speed, endurance, fertility, longevity, protection and peace.");
        SpiritAnimal turkey = createSpiritAnimal("Turkey", "Gratification, generosity, connection, togetherness, hard-working and wealth.");
        SpiritAnimal tarantula = createSpiritAnimal("Tarantula", "Creativity, patience, self-protection, transformation, and intimidation.");
        SpiritAnimal unicorn = createSpiritAnimal("Unicorn", "Magic, love, faith, vision, innocence, purity, gentleness and grace.");
        SpiritAnimal vulture = createSpiritAnimal("Vulture", "Loyalty, patience, quick-witted, goal-oriented, trust, vision, and perception.");
        SpiritAnimal wasp = createSpiritAnimal("Wasp", "Aggressive, creative, fertility, intelligence, teamwork, enthusiasm and determination.");
        SpiritAnimal wolf = createSpiritAnimal("Wolf", "Protection, partnership, loyalty, compassion, spirituality, togetherness, and power.");
        SpiritAnimal whale = createSpiritAnimal("Whale", "Wisdom, power, strength, self-reliance, protection, bravery and ancestry.");
        SpiritAnimal woodpecker = createSpiritAnimal("Woodpecker", "Intelligence, healing, unique, connection, revelation and perception.");

        SpiritAnimal[] spiritAnimals = {
                ant, alligator, anaconda, albatross,
                antelope, armadillo, beaver, buffalo, bat, bear, bee, blackSwan,
                butterfly, bluebird, bull, cardinal, camel, cheetah, cat, cougar,
                cuckoo, caribou, crane, crow, deer, dove, dog, dolphin, dragon,
                dragonfly, eagle, elephant, emu, elk, falcon, flamingo, fox, frog,
                gazelle, goat, grasshopper, giraffe, goose, goldfinch, hawk,
                hedgehog, hippopotamus, horse, heron, hummingbird, inchworm,
                jellyfish, jaguar, koala, kiwi, ladybug, lion, lizard, loon,
                magpie, monkey, moose, mosquito, mouse, mockingbird, meadowlark,
                orangutan, opossum, otter, ox, osprey, owl, panda, panther,
                peacock, penguin, pelican, porcupine, rabbit, rat, ram, rhinoceros,
                raccoon, reindeer, rooster, snake, salmon, swan, spider, sheep,
                squirrel, stork, tiger, turtle, turkey, tarantula, unicorn,
                vulture, wasp, wolf, whale, woodpecker
        };
        spiritAnimalRepository.saveAll(Arrays.asList(spiritAnimals));
    }

    private SpiritAnimal createSpiritAnimal(String name, String description) {
        SpiritAnimal spiritAnimal = new SpiritAnimal();
        spiritAnimal.setName(name);
        spiritAnimal.setDescription(description);
        return spiritAnimal;
    }
}
