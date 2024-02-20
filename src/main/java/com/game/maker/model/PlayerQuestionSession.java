package com.game.maker.model;

import jakarta.persistence.*;

@SequenceGenerator(name = "tb_sessao_questao_seq", allocationSize = 1)
@Entity
@Table(name = "tb_sessao_questao")
public class PlayerQuestionSession {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_sessao_questao_seq")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "questao_id")
  private Question question;

  @Column(name = "foi_jogado")
  private Boolean wasPlayed;

  @Column(name = "jogador_venceu")
  private Boolean playerWin;

  @Column(name = "questao_ativa")
  private Boolean questionIsActive;

  @Column(name = "pontuacao")
  private Long score;

  @ManyToOne
  @JoinColumn(name = "sessao_jogador_id")
  private PlayerGameplaySession playerGameplaySession;

  public PlayerQuestionSession() {
  }

  public PlayerQuestionSession(Question question, PlayerGameplaySession playerGameplaySession, Boolean wasPlayed) {
    this.question = question;
    this.playerGameplaySession = playerGameplaySession;
    this.wasPlayed = wasPlayed;
  }

  public PlayerQuestionSession(Long id, Question question, Boolean wasPlayed, PlayerGameplaySession playerGameplaySession) {
    this(question, playerGameplaySession, wasPlayed);
    this.id = id;
  }

  public PlayerQuestionSession(Long id, Question question, Boolean wasPlayed, Boolean playerWin, Boolean questionIsActive, Long score, PlayerGameplaySession playerGameplaySession) {
    this(id, question, wasPlayed, playerGameplaySession);
    this.playerWin = playerWin;
    this.score = score;
    this.questionIsActive = questionIsActive;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  public Boolean getWasPlayed() {
    return wasPlayed;
  }

  public void setWasPlayed(Boolean wasPlayed) {
    this.wasPlayed = wasPlayed;
  }

  public PlayerGameplaySession getPlayerGameplaySession() {
    return playerGameplaySession;
  }

  public void setPlayerGameplaySession(PlayerGameplaySession playerGameplaySession) {
    this.playerGameplaySession = playerGameplaySession;
  }

  public Boolean getPlayerWin() {
    return playerWin;
  }

  public void setPlayerWin(Boolean playerWin) {
    this.playerWin = playerWin;
  }

  public Boolean getQuestionIsActive() {
    return questionIsActive;
  }

  public void setQuestionIsActive(Boolean questionIsActive) {
    this.questionIsActive = questionIsActive;
  }

  public Long getScore() {
    return score;
  }

  public void setScore(Long score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return "\nQuestionSessionService{" +
        "\nid=" + id +
        "\nquestion=" + question +
        "\nalreadyUsed=" + wasPlayed +
        "\nplayerGameplaySession=" + playerGameplaySession +
        "\njogadorVenceu=" + playerWin +
        "\nquestionIsActive= " + questionIsActive +
        "\nscore= " + score;
  }


  public static final class Builder {
    private PlayerQuestionSession playerQuestionSession;

    private Builder() {
      playerQuestionSession = new PlayerQuestionSession();
    }

    public static Builder aPlayerGameplaySessionQuestion() {
      return new Builder();
    }

    public Builder id(Long id) {
      playerQuestionSession.setId(id);
      return this;
    }

    public Builder question(Question question) {
      playerQuestionSession.setQuestion(question);
      return this;
    }

    public Builder alreadyUsed(Boolean alreadyUsed) {
      playerQuestionSession.setWasPlayed(alreadyUsed);
      return this;
    }

    public Builder playerGameplaySession(PlayerGameplaySession playerGameplaySession) {
      playerQuestionSession.setPlayerGameplaySession(playerGameplaySession);
      return this;
    }

    public Builder playerWin(Boolean playerWin) {
      playerQuestionSession.setPlayerWin(playerWin);
      return this;
    }

    public Builder questionIsActive(Boolean questionIsActive) {
      playerQuestionSession.setQuestionIsActive(questionIsActive);
      return this;
    }

    public Builder score(Long score) {
      playerQuestionSession.setScore(score);
      return this;
    }

    public PlayerQuestionSession build() {
      return playerQuestionSession;
    }

  }

}