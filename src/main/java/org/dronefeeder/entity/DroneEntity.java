package org.dronefeeder.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class DroneEntity extends PanacheEntityBase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String coordenadas;
  private String entregaAtual;
  private boolean ocupado;

  @OneToMany(mappedBy = "droneEntity", cascade = CascadeType.ALL,
      orphanRemoval = true)
  public List<EntregaEntity> entregas;

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
