package org.dronefeeder.commons;

public class EntidadeExistenteException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public EntidadeExistenteException() {
    super("Entidade já existe!");
  }

}
