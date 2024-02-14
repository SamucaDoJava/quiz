package com.game.maker.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@SequenceGenerator(name = "tb_tema_seq", allocationSize = 1)
@Entity
@Table(name = "tb_tema")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_tema_seq")
    private Long id;

    @Column(name = "theme")
    private String theme;

    @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Question> questions = new ArrayList<>();


    public Theme(){

    }

    public Theme(Long id, String theme) {
        this.id = id;
        this.theme = theme;
    }

    public Theme(String theme) {
        this.theme = theme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                '}';
    }

    public static final class Builder {
        private Theme theme;

        private Builder() {
            theme = new Theme();
        }

        public static Builder aTema() {
            return new Builder();
        }

        public Builder id(Long id) {
            theme.setId(id);
            return this;
        }

        public Builder theme(String theme) {
            this.theme.setTheme(theme);
            return this;
        }

        public Theme build() {
            return theme;
        }
    }

}
