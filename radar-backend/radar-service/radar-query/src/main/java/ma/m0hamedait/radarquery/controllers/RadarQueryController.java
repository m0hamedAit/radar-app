package ma.m0hamedait.radarquery.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.radarquery.queries.GetAllRadarsQuery;
import ma.m0hamedait.radarquery.entities.Radar;
import ma.m0hamedait.radarquery.queries.GetRadarByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/queries/radar")
@AllArgsConstructor
@Slf4j
public class RadarQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/allRadars")
    public List<Radar> getAllRadars(){
        return queryGateway.query(new GetAllRadarsQuery(),
                ResponseTypes.multipleInstancesOf(Radar.class)).join();
    }

    @GetMapping("/{id}")
    public Radar radarInfo(@PathVariable String id){
        return queryGateway.query(new GetRadarByIdQuery(id),
                ResponseTypes.instanceOf(Radar.class)).join();
    }
}
