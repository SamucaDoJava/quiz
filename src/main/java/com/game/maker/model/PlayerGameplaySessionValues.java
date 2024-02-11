package com.game.maker.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@SequenceGenerator(name = "tb_sessao_jogador_seq", allocationSize = 1)
@Entity
@Table(name = "tb_sessao_jogador")
public class PlayerGameplaySessionValues {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_sessao_jogador_seq")
    private Long id;

    @Column(name = "usuario_id")
    private Long userId;

    @Column(name = "pontuacao")
    private Long score;

    @Column(name = "sessao_ativada")
    private Boolean sessionActivated;

    @OneToMany(mappedBy = "playerGameplaySession", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<GameplaySessionPlayerQuestion> gameplaySessionPlayerQuestions = new ArrayList<>();



    public PlayerGameplaySessionValues() {

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Boolean getSessionActivated() {
        return sessionActivated;
    }

    public void setSessionActivated(Boolean sessionActivated) {
        this.sessionActivated = sessionActivated;
    }

    public List<GameplaySessionPlayerQuestion> getPlayerGameplaySessionQuestions() {
        return gameplaySessionPlayerQuestions;
    }

    public void setPlayerGameplaySessionQuestions(List<GameplaySessionPlayerQuestion> gameplaySessionPlayerQuestions) {
        this.gameplaySessionPlayerQuestions = gameplaySessionPlayerQuestions;
    }

    @Override
    public String toString() {
        return "\nPlayerGameplaySessionValues{" +
                "\nid=" + id +
                "\nuserId=" + userId +
                "\nscore=" + score +
                "\nsessionActivated=" + sessionActivated +
                "\ngameplaySessionPlayerQuestions= " + gameplaySessionPlayerQuestions;
    }

    public static final class Builder {
        private PlayerGameplaySessionValues playerGameplaySessionValues;

        private Builder() {
            playerGameplaySessionValues = new PlayerGameplaySessionValues();
        }

        public static Builder aPlayerSession() {
            return new Builder();
        }

        public Builder id(Long id) {
            playerGameplaySessionValues.setId(id);
            return this;
        }

        public Builder userId(Long userId) {
            playerGameplaySessionValues.setUserId(userId);
            return this;
        }

        public Builder score(Long score) {
            playerGameplaySessionValues.setScore(score);
            return this;
        }

        public Builder sessionEnd(Boolean sessionActivated) {
            playerGameplaySessionValues.setSessionActivated(sessionActivated);
            return this;
        }

        public Builder playerGameplaySessionQuestions(List<GameplaySessionPlayerQuestion> gameplaySessionPlayerQuestions) {
            playerGameplaySessionValues.setPlayerGameplaySessionQuestions(gameplaySessionPlayerQuestions);
            return this;
        }

        public PlayerGameplaySessionValues build() {
            return playerGameplaySessionValues;
        }
    }



}
