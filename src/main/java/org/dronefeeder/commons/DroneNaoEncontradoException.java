package org.dronefeeder.commons;

public class DroneNaoEncontradoException extends RuntimeException {
  public DroneNaoEncontradoException() {
    super("Drone não encontrado!");
  }

}
