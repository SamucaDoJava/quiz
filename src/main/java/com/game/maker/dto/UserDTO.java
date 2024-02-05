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
    private String email;
    private String password;

    public UserDTO(String name, String fullName, Integer age, String email, String password) {
        this.name = name;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "\n\nUser:" +
                "\nname= " + name +
                "\nfullName= " + fullName +
                "\nage= " + age +
                "\nemail= " + email +
                "\npassword= " + password;
    }
}
