package com.gfa.foxbook.foxbook.loaders;

import com.gfa.foxbook.foxbook.models.nonusermodels.Technology;
import com.gfa.foxbook.foxbook.repositories.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TechnologyDataLoader implements CommandLineRunner {

    private final TechnologyRepository technologyRepository;

    @Autowired
    public TechnologyDataLoader(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (technologyRepository.count() == 0) {
            // Load initial technologies if the database is empty
            loadInitialTechnologies();
        }
    }

    private void loadInitialTechnologies() {
        // List of technologies
        List<String> technologiesList = Arrays.asList(
                "HTML",
                "CSS",
                "JavaScript",
                "TypeScript",
                "React",
                "Angular",
                "Vue.js",
                "Node.js",
                "Express.js",
                "Django",
                "Flask",
                "Ruby on Rails",
                "Spring Boot",
                "ASP.NET",
                "Swift",
                "Objective-C",
                "Kotlin",
                "Java (Android)",
                "React Native",
                "Flutter",
                "Xamarin",
                "Unity",
                "Unreal Engine",
                "MySQL",
                "PostgreSQL",
                "Oracle",
                "Microsoft SQL Server",
                "MongoDB",
                "Redis",
                "Cassandra",
                "Amazon Web Services (AWS)",
                "Microsoft Azure",
                "Google Cloud Platform (GCP)",
                "Docker",
                "Kubernetes",
                "Jenkins",
                "Travis CI",
                "CircleCI",
                "TensorFlow",
                "PyTorch",
                "scikit-learn",
                "Keras",
                "Hadoop",
                "Apache Spark",
                "Apache Flink",
                "Apache Kafka",
                "Arduino",
                "Raspberry Pi",
                "Linux (Various distributions)",
                "Windows",
                "macOS",
                "Git",
                "GitHub",
                "GitLab",
                "Bitbucket",
                "TCP/IP",
                "HTTP/HTTPS",
                "WebSocket",
                "Bitcoin",
                "Ethereum",
                "Smart Contracts",
                "Firewall",
                "Encryption",
                "SSL/TLS",
                "Penetration Testing"
        );

        // Save each technology to the repository
        for (String tech : technologiesList) {
            Technology technology = new Technology();
            technology.setName(tech);
            technologyRepository.save(technology);
        }
    }
}
