package org.dronefeeder.dto;

import java.util.List;
import org.dronefeeder.entity.EntregaEntity;

public class DroneDto {

  private List<EntregaEntity> entregas;
  private String coordenadas;
  private String entregaAtual;
  private boolean ocupado;

  public String getCoordenadas() {
    return coordenadas;
  }

  public void setCoordenadas(String coordenadas) {
    this.coordenadas = coordenadas;
  }

  public String getEntregaAtual() {
    return entregaAtual;
  }

  public void setEntregaAtual(String entregaAtual) {
    this.entregaAtual = entregaAtual;
  }

  public boolean isOcupado() {
    return ocupado;
  }

  public void setOcupado(boolean ocupado) {
    this.ocupado = ocupado;
  }
}
