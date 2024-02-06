package com.game.maker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InGameAlternativeDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("alternative")
    private String alternative;

    @JsonProperty("referenceLetter")
    private String referenceLetter;

    @Override
    public String toString() {
        return "\nInGameAlternativeDTO " +
                "\nid=" + id +
                "\nalternative='" + alternative +
                "\nreferenceLetter='" + referenceLetter;
    }
}
