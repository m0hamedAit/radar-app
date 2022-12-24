package ma.m0hamedait.radarquery.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.RadarCreatedEvent;
import ma.m0hamedait.RadarDeletedEvent;
import ma.m0hamedait.RadarUpdatedEvent;
import ma.m0hamedait.radarquery.queries.GetAllRadarsQuery;
import ma.m0hamedait.radarquery.entities.Radar;
import ma.m0hamedait.radarquery.queries.GetRadarByIdQuery;
import ma.m0hamedait.radarquery.repositories.RadarRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RadarServiceHandler {
    private RadarRepository radarRepository;

    @EventHandler
    public void on(RadarCreatedEvent event) {
        log.info("*** RadarCreatedEvent received ***");
        Radar radar = new Radar();
        radar.setId(event.getId());
        radar.setLatitude(event.getLatitude());
        radar.setLongitude(event.getLongitude());
        radar.setSpeedLimit(event.getSpeedLimit());
        radarRepository.save(radar);
    }

    @EventHandler
    public void on(RadarUpdatedEvent event) {
        log.info("*** RadarUpdatedEvent received ***");
        Radar radar = radarRepository.getById(event.getId());
        radar.setLatitude(event.getLatitude());
        radar.setLongitude(event.getLongitude());
        radar.setSpeedLimit(event.getSpeedLimit());
        radarRepository.save(radar);
    }

    @EventHandler
    public void on(RadarDeletedEvent event) {
        log.info("*** RadarDeletedEvent received ***");
        Radar radar = radarRepository.getById(event.getId());
        radarRepository.delete(radar);
    }

    @QueryHandler
    public List<Radar> on(GetAllRadarsQuery query) {
        log.info("*** GetAllRadarsQuery received ***");
        return radarRepository.findAll();
    }

    @QueryHandler
    public Radar on(GetRadarByIdQuery query) {
        log.info("*** GetRadarByIdQuery received ***");
        return radarRepository.getById(query.getId());
    }

}
