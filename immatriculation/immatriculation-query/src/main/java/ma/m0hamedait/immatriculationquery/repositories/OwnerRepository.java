package ma.m0hamedait.immatriculationquery.repositories;

import ma.m0hamedait.immatriculationquery.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, String> {
}
