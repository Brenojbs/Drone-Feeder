package org.dronefeeder.commons;

public class ErroInesperadoException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ErroInesperadoException() {
    super("Erro inesperado");
  }
}
