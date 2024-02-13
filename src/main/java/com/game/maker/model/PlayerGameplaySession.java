package com.game.maker.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@SequenceGenerator(name = "tb_sessao_jogador_seq", allocationSize = 1)
@Entity
@Table(name = "tb_sessao_jogador")
public class PlayerGameplaySession {

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
    private List<PlayerQuestionSession> playerQuestionSessions = new ArrayList<>();



    public PlayerGameplaySession() {

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

    public List<PlayerQuestionSession> getPlayerGameplaySessionQuestions() {
        return playerQuestionSessions;
    }

    public void setPlayerGameplaySessionQuestions(List<PlayerQuestionSession> playerQuestionSessions) {
        this.playerQuestionSessions = playerQuestionSessions;
    }

    @Override
    public String toString() {
        return "\nPlayerGameplaySession{" +
                "\nid=" + id +
                "\nuserId=" + userId +
                "\nscore=" + score +
                "\nsessionActivated=" + sessionActivated;
    }

    public static final class Builder {
        private PlayerGameplaySession playerGameplaySession;

        private Builder() {
            playerGameplaySession = new PlayerGameplaySession();
        }

        public static Builder aPlayerSession() {
            return new Builder();
        }

        public Builder id(Long id) {
            playerGameplaySession.setId(id);
            return this;
        }

        public Builder userId(Long userId) {
            playerGameplaySession.setUserId(userId);
            return this;
        }

        public Builder score(Long score) {
            playerGameplaySession.setScore(score);
            return this;
        }

        public Builder sessionEnd(Boolean sessionActivated) {
            playerGameplaySession.setSessionActivated(sessionActivated);
            return this;
        }

        public Builder playerGameplaySessionQuestions(List<PlayerQuestionSession> playerQuestionSessions) {
            playerGameplaySession.setPlayerGameplaySessionQuestions(playerQuestionSessions);
            return this;
        }

        public PlayerGameplaySession build() {
            return playerGameplaySession;
        }
    }



}
