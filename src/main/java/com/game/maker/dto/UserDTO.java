package com.game.maker.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String fullName;
    private Integer age;

    @Override
    public String toString() {
        return "\n\nUser:" +
                "\nname='" + name +
                "\nfullName='" + fullName +
                "\nage=" + age;
    }
}
