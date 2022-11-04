package org.dronefeeder.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class EntregaEntity extends PanacheEntityBase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  public DroneEntity droneEntity;

  private String endereço;
  private String destinatario;

  private LocalDateTime DataEHora;

  // "Separação", "Em transito" e "Entregue"
  private String StatusEntrega;

  public DroneEntity getDroneEntity() {
    return droneEntity;
  }

  public void setDroneEntity(DroneEntity droneEntity) {
    this.droneEntity = droneEntity;
  }

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
