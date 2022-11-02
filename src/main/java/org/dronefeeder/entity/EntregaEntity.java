package org.dronefeeder.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EntregaEntity extends PanacheEntityBase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private DroneEntity droneEntity;

  private String endereço;
  private String destinatario;

  private LocalDate DataEHora;

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

  public LocalDate getDataEHora() {
    return DataEHora;
  }

  public void setDataEHora(LocalDate dataEHora) {
    DataEHora = dataEHora;
  }

  public String getStatusEntrega() {
    return StatusEntrega;
  }

  public void setStatusEntrega(String statusEntrega) {
    StatusEntrega = statusEntrega;
  }


}