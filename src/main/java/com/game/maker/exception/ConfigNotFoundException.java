package com.game.maker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ConfigNotFoundException extends ResponseStatusException {

  public ConfigNotFoundException(String message) {
    super(HttpStatus.NOT_FOUND, message);
  }

}