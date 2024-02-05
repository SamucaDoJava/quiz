package com.game.maker.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tb_sessao_jogador")
public class PlayerGameplaySessionValues {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "usuario_id")
    private Long userId;

    @Column(name = "pontuacao")
    private Long score;

    @Column(name = "sessao_encerrada")
    private Boolean sessionEnd;

    @ElementCollection
    @CollectionTable(name = "tb_sessao_jogador_questao", joinColumns = @JoinColumn(name = "sessao_jogador_id"))
    @Column(name = "questao_id")
    private List<Long> questionIdList = new ArrayList<>();

    //@ManyToOne
    //@JoinColumn(name = "questao_id", referencedColumnName = "id", insertable = false, updatable = false)
    // private Question question;

    public PlayerGameplaySessionValues() {

    }

    public PlayerGameplaySessionValues(Long id, Long userId, Long score, Boolean sessionEnd, List<Long> questionIdList) {
        this.id = id;
        this.userId = userId;
        this.score = score;
        this.sessionEnd = sessionEnd;
        this.questionIdList = questionIdList;
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

    public Boolean getSessionEnd() {
        return sessionEnd;
    }

    public void setSessionEnd(Boolean sessionEnd) {
        this.sessionEnd = sessionEnd;
    }

    public List<Long> getQuestionIdList() {
        return questionIdList;
    }

    public void setQuestionIdList(List<Long> questionIdList) {
        this.questionIdList = questionIdList;
    }

    @Override
    public String toString() {
        return "PlayerGameplaySessionValues{" +
                "id=" + id +
                ", userId=" + userId +
                ", score=" + score +
                ", sessionEnd=" + sessionEnd +
                ", questionIdList=" + questionIdList +
                '}';
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

        public Builder sessionEnd(Boolean sessionEnd) {
            playerGameplaySessionValues.setSessionEnd(sessionEnd);
            return this;
        }

        public Builder questionIdList(List<Long> questionIdList) {
            playerGameplaySessionValues.setQuestionIdList(questionIdList);
            return this;
        }

        public PlayerGameplaySessionValues build() {
            return playerGameplaySessionValues;
        }
    }



}
