package com.gfa.foxbook.foxbook.models.nonusermodels;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Language(String name) {
        this.name = name;
    }

    public static List<Language> getLanguageList() {
        return List.of(
                new Language("Italian"),
                new Language("Persian (Farsi)"),
                new Language("Thai"),
                new Language("Gujarati"),
                new Language("Polish"),
                new Language("Ukrainian"),
                new Language("Malayalam"),
                new Language("Kannada"),
                new Language("Oriya (Odia)"),
                new Language("Burmese"),
                new Language("Hakka"),
                new Language("Bhojpuri"),
                new Language("Tagalog"),
                new Language("Yoruba"),
                new Language("Maithili"),
                new Language("Uzbek"),
                new Language("Sindhi"),
                new Language("Amharic"),
                new Language("Fula"),
                new Language("Romanian"),
                new Language("Oromo"),
                new Language("Igbo"),
                new Language("Azerbaijani"),
                new Language("Dutch"),
                new Language("Kurdish"),
                new Language("Malagasy"),
                new Language("Saraiki"),
                new Language("Nepali"),
                new Language("Sinhala"),
                new Language("Czech"),
                new Language("Haitian Creole"),
                new Language("Hungarian"),
                new Language("Swedish"),
                new Language("Belarusian"),
                new Language("Shona"),
                new Language("Zulu"),
                new Language("Somali"),
                new Language("Tigrinya"),
                new Language("Kinyarwanda"),
                new Language("Hmong"),
                new Language("Uighur"),
                new Language("Greek"),
                new Language("Czech"),
                new Language("Bulgarian"),
                new Language("Khmer (Cambodian)"),
                new Language("Kazakh"),
                new Language("Danish"),
                new Language("Maltese"),
                new Language("Finnish"),
                new Language("Icelandic"),
                new Language("Slovak"),
                new Language("Lithuanian"),
                new Language("Slovenian"),
                new Language("Latvian"),
                new Language("Estonian"),
                new Language("Georgian"),
                new Language("Hausa"),
                new Language("Macedonian"),
                new Language("Albanian"),
                new Language("Afrikaans"),
                new Language("Swahili"),
                new Language("Mongolian"),
                new Language("Armenian"),
                new Language("Hebrew"),
                new Language("Yiddish"),
                new Language("Gujarati"),
                new Language("Assamese"),
                new Language("Kashmiri"),
                new Language("Konkani"),
                new Language("Maithili"),
                new Language("Manipuri"),
                new Language("Sindhi"),
                new Language("Tibetan"),
                new Language("Tulu"),
                new Language("Santali"),
                new Language("Awadhi"),
                new Language("Magahi"),
                new Language("Chhattisgarhi"),
                new Language("Malvi"),
                new Language("Bhili")
        );
    }
}