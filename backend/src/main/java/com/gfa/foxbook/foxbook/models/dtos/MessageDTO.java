package com.gfa.foxbook.foxbook.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    public String from;
    public String message;
    public String interestedIn;
}
