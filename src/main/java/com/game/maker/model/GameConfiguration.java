package com.game.maker.model;

import jakarta.persistence.*;

@SequenceGenerator(name = "tb_configuracao_jogo_seq", allocationSize = 1)
@Entity
@Table(name = "tb_configuracao_jogo")
public class GameConfiguration {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_configuracao_jogo_seq")
  private Long id;

  @Column(name = "pontuacao_por_acerto")
  private Long scorePerHit;

  @Column(name = "moeda_inicial")
  private Long initialCoins;

  @Column(name = "level")
  private String level;

  public GameConfiguration() {
  }

  public GameConfiguration(Long id, Long scorePerHit, Long initialCoins, String level) {
    this.id = id;
    this.scorePerHit = scorePerHit;
    this.initialCoins = initialCoins;
    this.level = level;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getScorePerHit() {
    return scorePerHit;
  }

  public void setScorePerHit(Long scorePerHit) {
    this.scorePerHit = scorePerHit;
  }

  public Long getInitialCoins() {
    return initialCoins;
  }

  public void setInitialCoins(Long initialCoins) {
    this.initialCoins = initialCoins;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  @Override
  public String toString() {
    return "GameConfiguration{" +
        "id=" + id +
        ", scorePerHit=" + scorePerHit +
        ", initialCoins=" + initialCoins +
        ", level='" + level + '\'' +
        '}';
  }

  public static final class Builder {
    private GameConfiguration gameConfiguration;

    private Builder() {
      gameConfiguration = new GameConfiguration();
    }

    public static Builder aGameConfiguration() {
      return new Builder();
    }

    public Builder id(Long id) {
      gameConfiguration.setId(id);
      return this;
    }

    public Builder scorePerHit(Long scorePerHit) {
      gameConfiguration.setScorePerHit(scorePerHit);
      return this;
    }

    public Builder initialCoins(Long initialCoins) {
      gameConfiguration.setInitialCoins(initialCoins);
      return this;
    }

    public Builder level(String level) {
      gameConfiguration.setLevel(level);
      return this;
    }

    public GameConfiguration build() {
      return gameConfiguration;
    }

  }

}