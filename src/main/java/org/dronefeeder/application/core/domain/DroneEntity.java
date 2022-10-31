package org.dronefeeder.application.core.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DroneEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String coordenadas;
  private String entregaAtual;
  private boolean ocupado;

  @OneToMany(mappedBy = "droneEntity", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<EntregaEntity> entregas;

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

  public List<EntregaEntity> getEntregas() {
    return entregas;
  }

  public void setEntregas(List<EntregaEntity> entregas) {
    this.entregas = entregas;
  }

}
