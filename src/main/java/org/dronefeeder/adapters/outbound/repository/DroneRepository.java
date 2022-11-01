package org.dronefeeder.adapters.outbound.repository;

import javax.enterprise.context.ApplicationScoped;
import org.dronefeeder.application.core.domain.DroneEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class DroneRepository implements PanacheRepositoryBase<DroneEntity, Long> {

}
