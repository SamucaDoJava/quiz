package com.game.maker.model;


public class User {

    private Long id;
    private String name;
    private String fullName;
    private Integer age;
    private String email;
    private String password;

    public User() {

    }

    public User(String name, String fullName, Integer age) {
        this.name = name;
        this.fullName = fullName;
        this.age = age;
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


    public static final class Builder {
        private User user;

        private Builder() {
            user = new User();
        }

        public static Builder anUser() {
            return new Builder();
        }

        public Builder id(Long id) {
            user.setId(id);
            return this;
        }

        public Builder name(String name) {
            user.setName(name);
            return this;
        }

        public Builder fullName(String fullName) {
            user.setFullName(fullName);
            return this;
        }

        public Builder age(Integer age) {
            user.setAge(age);
            return this;
        }

        public Builder email(String email) {
            user.setEmail(email);
            return this;
        }

        public Builder password(String password) {
            user.setPassword(password);
            return this;
        }

        public User build() {
            return user;
        }
    }
}
