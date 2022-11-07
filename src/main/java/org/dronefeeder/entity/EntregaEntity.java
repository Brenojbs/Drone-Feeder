package org.dronefeeder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EntregaEntity extends PanacheEntityBase {

  @ManyToOne
  @JsonIgnore
  public DroneEntity droneEntity;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String endereco;
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

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
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

  public Long getId() {
    return id;
  }
}
