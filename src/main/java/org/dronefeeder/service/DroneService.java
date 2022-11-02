package org.dronefeeder.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import org.dronefeeder.commons.DroneNaoEncontradoException;
import org.dronefeeder.commons.ErroInesperadoException;
import org.dronefeeder.dto.DroneDto;
import org.dronefeeder.entity.DroneEntity;

@ApplicationScoped
public class DroneService {

  @Transactional
  public void deletar(Long id) throws DroneNaoEncontradoException {
    try {
      boolean deleted = DroneEntity.deleteById(id);

      if (!deleted) {
        throw new DroneNaoEncontradoException();
      }

    } catch (DroneNaoEncontradoException e) {
      throw new DroneNaoEncontradoException();
    } catch (Exception e) {
      throw new ErroInesperadoException();
    }
  }

  public DroneEntity buscarId(Long id) {
    try {
      DroneEntity drone = DroneEntity.findById(id);

      if (drone == null) {
        throw new DroneNaoEncontradoException();
      }

      return drone;

    } catch (DroneNaoEncontradoException e) {
      throw new DroneNaoEncontradoException();
    } catch (Exception e) {
      throw new ErroInesperadoException();
    }
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
    try {
      DroneEntity drone = DroneEntity.findById(id);

      if (drone == null) {
        throw new DroneNaoEncontradoException();
      }

      drone.setOcupado(dto.isOcupado());
      drone.setCoordenadas(dto.getCoordenadas());
      drone.setEntregaAtual(dto.getEntregaAtual());
      drone.persist();
    } catch (DroneNaoEncontradoException e) {
      throw new DroneNaoEncontradoException();
    } catch (Exception e) {
      throw new ErroInesperadoException();
    }
  }

}
