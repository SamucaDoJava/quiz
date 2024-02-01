package com.game.maker.dto;


public class UserDTO {

    private Long id;
    private String name;
    private String fullName;

    private Integer age;

    private String email;

    private String password;

    public UserDTO() {

    }

    public UserDTO(String name, String fullName, Integer age) {
        this.name = name;
        this.fullName = fullName;
        this.age = age;
    }

    public UserDTO(Long id, String name, String fullName, Integer age, String email, String password) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public static final class Builder {
        private UserDTO userDTO;

        private Builder() {
            userDTO = new UserDTO();
        }

        public static Builder anUserDTO() {
            return new Builder();
        }

        public Builder id(Long id) {
            userDTO.setId(id);
            return this;
        }

        public Builder name(String name) {
            userDTO.setName(name);
            return this;
        }

        public Builder fullName(String fullName) {
            userDTO.setFullName(fullName);
            return this;
        }

        public Builder age(Integer age) {
            userDTO.setAge(age);
            return this;
        }

        public Builder email(String email) {
            userDTO.setEmail(email);
            return this;
        }

        public Builder password(String password) {
            userDTO.setPassword(password);
            return this;
        }

        public UserDTO build() {
            return userDTO;
        }
    }
}
