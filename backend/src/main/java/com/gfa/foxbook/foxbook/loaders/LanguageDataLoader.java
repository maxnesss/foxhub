
package com.gfa.foxbook.foxbook.loaders;

import com.gfa.foxbook.foxbook.models.nonusermodels.Language;
import com.gfa.foxbook.foxbook.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class LanguageDataLoader implements CommandLineRunner {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageDataLoader(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (languageRepository.count() == 0) {
            // Load initial languages if the database is empty
            loadInitialLanguages();
        }
    }

    private void loadInitialLanguages() {
        // Add the initial languages here

        List<String> languageNames = Arrays.asList(
                "English",
                "Spanish",
                "Chinese (Mandarin)",
                "Hindi",
                "Arabic",
                "Portuguese",
                "Bengali",
                "Russian",
                "Japanese",
                "Punjabi",
                "German",
                "Javanese",
                "Korean",
                "French",
                "Telugu",
                "Marathi",
                "Turkish",
                "Tamil",
                "Vietnamese",
                "Urdu",
                "Italian",
                "Thai",
                "Gujarati",
                "Kannada",
                "Persian (Farsi)",
                "Bhojpuri",
                "Malayalam",
                "Odia (Oriya)",
                "Ukrainian",
                "Maithili",
                "Filipino (Tagalog)",
                "Burmese",
                "Hakka",
                "Sindhi",
                "Hausa",
                "Yoruba",
                "Ukrainian",
                "Kurdish",
                "Amharic",
                "Oromo",
                "Zulu",
                "Igbo",
                "Azerbaijani",
                "Pashto",
                "Greek",
                "Malagasy",
                "Romanian",
                "Dutch",
                "Cebuano",
                "Hungarian",
                "Swedish",
                "Norwegian",
                "Danish",
                "Finnish",
                "Polish",
                "Czech",
                "Slovak",
                "Serbian"
        );

        for (String name : languageNames) {
            Language language = new Language();
            language.setName(name);
            languageRepository.save(language);
        }
    }
}
