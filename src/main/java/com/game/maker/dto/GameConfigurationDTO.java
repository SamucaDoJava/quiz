package com.game.maker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GameConfigurationDTO {

  private Long id;

  private Long scorePerHit;

  private Long initialCoins;

  private String level;

}