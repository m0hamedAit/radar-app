package ma.m0hamedait.immatriculationquery.repositories;

import ma.m0hamedait.immatriculationquery.entities.Owner;
import ma.m0hamedait.immatriculationquery.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    List<Vehicle> findAllByOwner(Owner owner);
    Vehicle findByMatricule(String id);
}
