package ma.m0hamedait.infractionquery.repositories;

import ma.m0hamedait.infractionquery.entities.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface InfractionRepository extends JpaRepository<Infraction, String> {
    List<Infraction> findByRadarId(String radarId);
    List<Infraction> findByVehicleMatricule(String vehicleMatricule);
}
