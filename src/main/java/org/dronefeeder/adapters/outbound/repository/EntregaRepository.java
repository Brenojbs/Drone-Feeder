package org.dronefeeder.adapters.outbound.repository;

import javax.enterprise.context.ApplicationScoped;
import org.dronefeeder.application.core.domain.EntregaEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class EntregaRepository implements PanacheRepositoryBase<EntregaEntity, Long> {

}
