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
public class UserDTO {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("fullName")
  private String fullName;

  @JsonProperty("age")
  private Integer age;

  @JsonProperty("email")
  private String email;

  @JsonProperty("password")
  private String password;

  @JsonProperty("nickName")
  private String nickName;

  @Override
  public String toString() {
    return "\n\nUser:" +
        "\nname= " + name +
        "\nfullName= " + fullName +
        "\nage= " + age +
        "\nemail= " + email +
        "\npassword= " + password +
        "\nnickName= " + nickName;
  }
}