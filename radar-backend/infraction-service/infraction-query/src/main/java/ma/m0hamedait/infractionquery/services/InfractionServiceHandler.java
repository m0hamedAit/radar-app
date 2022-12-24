package ma.m0hamedait.infractionquery.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.InfractionCreatedEvent;
import ma.m0hamedait.InfractionPaidEvent;
import ma.m0hamedait.infractionquery.entities.Infraction;
import ma.m0hamedait.infractionquery.queries.GetAllInfractionsQuery;
import ma.m0hamedait.infractionquery.queries.GetInfractionByIdQuery;
import ma.m0hamedait.infractionquery.queries.GetInfractionsByRadarIdQuery;
import ma.m0hamedait.infractionquery.queries.GetInfractionsByVehicleQuery;
import ma.m0hamedait.infractionquery.repositories.InfractionRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class InfractionServiceHandler {
    private InfractionRepository infractionRepository;

    @EventHandler
    public void on(InfractionCreatedEvent event){
        log.info("*** InfractionCreateEvent received ***");
        Infraction infraction = new Infraction();
        infraction.setId(event.getId());
        infraction.setDate(event.getDate());
        infraction.setRadarId(event.getRadarID());
        infraction.setVehicleMatricule(event.getVehicleMatricule());
        infraction.setVehicleSpeed(event.getVehicleSpeed());
        infraction.setRadarSpeedLimit(event.getRadarSpeedLimit());
        infraction.setAmountToPay(event.getAmountToPay());
        infraction.setPaid(event.isPaid());
        infractionRepository.save(infraction);
    }

    @EventHandler
    public void on(InfractionPaidEvent event){
        log.info("*** InfractionPaidEvent received ***");
        Infraction infraction = infractionRepository.findById(event.getId()).get();
        infraction.setPaid(true);
        infractionRepository.save(infraction);
    }

    @QueryHandler
    public List<Infraction> on(GetAllInfractionsQuery query){
        log.info("*** GetAllInfractionsQuery received ***");
        return infractionRepository.findAll();
    }

    @QueryHandler
    public Infraction on(GetInfractionByIdQuery query){
        log.info("*** GetInfractionByIdQuery received ***");
        return infractionRepository.findById(query.getId()).get();
    }

    @QueryHandler
    public List<Infraction> on(GetInfractionsByRadarIdQuery query){
        log.info("*** GetInfractionByRadarIdQuery received ***");
        return infractionRepository.findByRadarId(query.getRadarId());
    }

    @QueryHandler
    public List<Infraction> on(GetInfractionsByVehicleQuery query){
        log.info("*** GetInfractionsByVehicleQuery received ***");
        return infractionRepository.findByVehicleMatricule(query.getVehicleMatricule());
    }
}
