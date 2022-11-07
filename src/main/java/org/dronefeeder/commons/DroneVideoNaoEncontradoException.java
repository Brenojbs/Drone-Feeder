package org.dronefeeder.commons;

public class DroneVideoNaoEncontradoException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public DroneVideoNaoEncontradoException() {
    super("Video Não encontrado!");
  }

}
