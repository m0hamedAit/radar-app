package ma.m0hamedait.radarquery.repositories;

import ma.m0hamedait.radarquery.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar, String> {
}
