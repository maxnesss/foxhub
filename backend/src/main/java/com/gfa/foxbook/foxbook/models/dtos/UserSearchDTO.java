package com.gfa.foxbook.foxbook.models.dtos;


import com.gfa.foxbook.foxbook.models.User;
import com.gfa.foxbook.foxbook.models.nonusermodels.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchDTO {
    private String firstName;
    private String lastName;
    private String nickname;
    private String about;
    private Integer yearOfBirth;
    private Personality personality;
    private ColorPersonality colorPersonality;
    private Boolean verified;
    private Role role;
    private List<Location> locations;
    private String profilePictureUrl;
    private List<Technology> technologies;
    private List<Language> languages;
    private WorkPreference workPreference;
    private String oneLineAbout;
    private SpiritAnimal spiritAnimal;

    public UserSearchDTO(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.nickname = user.getNickname();
        this.about = user.getAbout();
        this.yearOfBirth = user.getYearOfBirth();
        this.technologies = user.getTechnologies();
        this.profilePictureUrl = user.getProfilePictureUrl();
        this.languages = user.getLanguages();
        this.personality = user.getPersonality();
        this.colorPersonality = user.getColorPersonality();
        this.verified = user.isVerified();
        this.role = user.getRole();
        this.locations = user.getLocations();
        this.workPreference = user.getWorkPreference();
        this.oneLineAbout = user.getOneLineAbout();
        this.spiritAnimal = user.getSpiritAnimal();
    }
}
