package org.dronefeeder.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import org.dronefeeder.commons.EntidadeExistenteException;
import org.dronefeeder.commons.EntidadeNaoEncontradaException;
import org.dronefeeder.dto.EntregaDto;
import org.dronefeeder.entity.EntregaEntity;

@ApplicationScoped
public class EntregaService {

  public DroneService drone;

  public List<EntregaEntity> listar() {
    return EntregaEntity.listAll();
  }

  public EntregaEntity buscarId(Long id) {
    return EntregaEntity.findById(id);
  }

  @Transactional
  public void salvar(EntregaDto dto) throws EntidadeExistenteException {
    try {

      EntregaEntity entrega = new EntregaEntity();

      if (this.listar().stream().filter(entr -> entr.getDataEHora() == dto.getDataEHora())
          .findFirst().isPresent()) {
        throw new EntidadeExistenteException();
      }

      entrega.setDataEHora(dto.getDataEHora());
      entrega.setDestinatario(dto.getDestinatario());
      entrega.setDroneEntity(drone.listar().stream().filter(drone -> drone.isOcupado() == false)
          .findAny().orElseThrow());
      entrega.setEndereço(dto.getEndereço());
      entrega.setStatusEntrega(dto.getStatusEntrega());
      entrega.persist();
    } catch (EntidadeExistenteException e) {
      throw e;
    }
  }

  @Transactional
  public void editar(Long id, EntregaDto dto) throws EntidadeNaoEncontradaException {
    try {

      EntregaEntity entrega = EntregaEntity.findById(id);
      if (EntregaEntity.findById(id) == null) {
        throw new EntidadeNaoEncontradaException();
      }
      entrega.setDestinatario(dto.getDestinatario());
      entrega.setDroneEntity(drone.listar().stream().filter(drone -> drone.isOcupado() == false)
          .findAny().orElseThrow());
      entrega.setEndereço(dto.getEndereço());
      entrega.setStatusEntrega(dto.getStatusEntrega());
      entrega.persist();
    } catch (EntidadeNaoEncontradaException e) {
      throw e;
    }
  }

  @Transactional
  public void deletar(Long id) throws EntidadeNaoEncontradaException {
    try {

      if (EntregaEntity.findById(id) == null) {
        throw new EntidadeNaoEncontradaException();
      }
      EntregaEntity.deleteById(id);
    } catch (EntidadeNaoEncontradaException e) {
      throw e;
    }
  }

}
