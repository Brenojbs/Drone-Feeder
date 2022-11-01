package org.dronefeeder.commons;

/**
 * Classe DataError.
 **/


public class DataError {
  /**
   * Atributos.
   **/
  private String mensagem;

  /**
   * Construtor da classe DataError.
   */
  public DataError(String mensagem) {
    this.mensagem = mensagem;
  }

  public DataError() {}

  /**
   * Métodos.
   **/
  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }
}
