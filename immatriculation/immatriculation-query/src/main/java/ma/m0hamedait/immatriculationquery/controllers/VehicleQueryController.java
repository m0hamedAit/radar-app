package ma.m0hamedait.immatriculationquery.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.immatriculationquery.entities.Vehicle;
import ma.m0hamedait.immatriculationquery.queries.GetAllVehiclesQuery;
import ma.m0hamedait.immatriculationquery.queries.GetVehicleByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/queries/vehicle")
@AllArgsConstructor
@Slf4j
public class VehicleQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/allVehicles")
    public List<Vehicle> getAllVehicles(){
        return queryGateway.query(new GetAllVehiclesQuery(),
                ResponseTypes.multipleInstancesOf(Vehicle.class)).join();
    }

    @GetMapping("/{id}")
    public Vehicle VehicleInfo(String id){
        return queryGateway.query(new GetVehicleByIdQuery(id),
                ResponseTypes.instanceOf(Vehicle.class)).join();
    }
}
