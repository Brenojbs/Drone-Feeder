package org.dronefeeder.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import org.dronefeeder.commons.DroneVideoNaoEncontradoException;
import org.dronefeeder.commons.ErroInesperadoException;
import org.dronefeeder.dto.DroneVideoDto;
import org.dronefeeder.entity.DroneVideoEntity;

@ApplicationScoped
public class DroneVideoService {

  @Transactional
  public void salvar(DroneVideoDto dto) {
    DroneVideoEntity droneVideo = new DroneVideoEntity();
    droneVideo.setUrl(dto.getUrl());
    droneVideo.persist();
  }


  public List<DroneVideoEntity> listar() {
    return DroneVideoEntity.listAll();
  }

  public DroneVideoEntity buscarId(Long id) {
    try {
      DroneVideoEntity drone = DroneVideoEntity.findById(id);

      if (drone == null) {
        throw new DroneVideoNaoEncontradoException();
      }

      return drone;

    } catch (DroneVideoNaoEncontradoException e) {
      throw new DroneVideoNaoEncontradoException();
    } catch (Exception e) {
      throw new ErroInesperadoException();
    }
  }

  @Transactional
  public void deletar(Long id) throws DroneVideoNaoEncontradoException {

    try {
      boolean deleted = DroneVideoEntity.deleteById(id);

      if (!deleted) {
        throw new DroneVideoNaoEncontradoException();
      }

    } catch (DroneVideoNaoEncontradoException e) {
      throw new DroneVideoNaoEncontradoException();
    } catch (Exception e) {
      throw new ErroInesperadoException();
    }
  }
}
