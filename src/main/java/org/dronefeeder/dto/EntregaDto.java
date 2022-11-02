package org.dronefeeder.dto;

import java.time.LocalDateTime;

public class EntregaDto {
  private String endereço;
  private String destinatario;
  private LocalDateTime DataEHora;
  private String StatusEntrega;

  public String getEndereço() {
    return endereço;
  }

  public void setEndereço(String endereço) {
    this.endereço = endereço;
  }

  public String getDestinatario() {
    return destinatario;
  }

  public void setDestinatario(String destinatario) {
    this.destinatario = destinatario;
  }

  public LocalDateTime getDataEHora() {
    return DataEHora;
  }

  public void setDataEHora(LocalDateTime dataEHora) {
    DataEHora = dataEHora;
  }

  public String getStatusEntrega() {
    return StatusEntrega;
  }

  public void setStatusEntrega(String statusEntrega) {
    StatusEntrega = statusEntrega;
  }
}
