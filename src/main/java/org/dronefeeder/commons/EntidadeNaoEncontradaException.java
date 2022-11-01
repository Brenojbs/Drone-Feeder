package org.dronefeeder.commons;

public class EntidadeNaoEncontradaException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public EntidadeNaoEncontradaException() {
    super("Entidade não foi encontrada!");
  }

}
