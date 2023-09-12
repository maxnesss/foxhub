package com.gfa.foxbook.foxbook.models.nonusermodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfile implements Serializable {

    @JsonProperty("First name")
    private String[] firstName;

    @JsonProperty("Last name")
    private String[] lastName;

    @JsonProperty("Email")
    private String[] email;

    @JsonProperty("Highest education (Impact report)")
    private String[] education;




}
