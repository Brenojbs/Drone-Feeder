package org.dronefeeder.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import org.dronefeeder.dto.DroneDto;
import org.dronefeeder.entity.DroneEntity;

@ApplicationScoped
public class DroneService {

  @Transactional
  public void deletar(Long id) {
    DroneEntity.deleteById(id);
  }

  public DroneEntity buscarId(Long id) {
    return DroneEntity.findById(id);
  }

  public List<DroneEntity> listar() {
    return DroneEntity.listAll();
  }

  @Transactional
  public void salvar(DroneDto dto) {
    DroneEntity drone = new DroneEntity();
    drone.setCoordenadas(dto.getCoordenadas());
    drone.setOcupado(false);
    drone.persist();
  }

  @Transactional
  public void editar(Long id, DroneDto dto) {
    DroneEntity drone = DroneEntity.findById(id);
    drone.setOcupado(dto.isOcupado());
    drone.setCoordenadas(dto.getCoordenadas());
    drone.setEntregaAtual(dto.getEntregaAtual());
    drone.persist();
  }

}
