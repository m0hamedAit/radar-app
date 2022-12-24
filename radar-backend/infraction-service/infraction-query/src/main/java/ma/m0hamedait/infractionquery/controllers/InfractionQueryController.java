package ma.m0hamedait.infractionquery.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.infractionquery.entities.Infraction;
import ma.m0hamedait.infractionquery.queries.GetAllInfractionsQuery;
import ma.m0hamedait.infractionquery.queries.GetInfractionByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/queries/infraction")
@AllArgsConstructor
@Slf4j
public class InfractionQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/allInfractions")
    public List<Infraction> getAllInfractions(){
        return queryGateway.query(new GetAllInfractionsQuery(),
                ResponseTypes.multipleInstancesOf(Infraction.class)).join();
    }

    @GetMapping("/{id}")
    public Infraction infractionInfo(@PathVariable String id){
        return queryGateway.query(new GetInfractionByIdQuery(id),
                ResponseTypes.instanceOf(Infraction.class)).join();
    }

    @GetMapping("/radar/{radarId}")
    public List<Infraction> getInfractionsByRadarId(@PathVariable String radarId){
        return queryGateway.query(new GetInfractionByIdQuery(radarId),
                ResponseTypes.multipleInstancesOf(Infraction.class)).join();
    }

    @GetMapping("/vehicle/{vehicleMatricule}")
    public List<Infraction> getInfractionsByVehicleMatricule(@PathVariable String vehicleMatricule){
        return queryGateway.query(new GetInfractionByIdQuery(vehicleMatricule),
                ResponseTypes.multipleInstancesOf(Infraction.class)).join();
    }
}
