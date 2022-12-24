package ma.m0hamedait.immatriculationquery.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.immatriculationquery.entities.Owner;
import ma.m0hamedait.immatriculationquery.entities.Vehicle;
import ma.m0hamedait.immatriculationquery.queries.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/queries/immatriculation")
@AllArgsConstructor
@Slf4j
public class ImmatriculationQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/owner/allOwners")
    public List<Owner> getAllOwners(){
        return queryGateway.query(new GetAllOwnersQuery(),
                ResponseTypes.multipleInstancesOf(Owner.class)).join();
    }

    @GetMapping("/owner/{id}")
    public Owner ownerInfo(@PathVariable String id){
        return queryGateway.query(new GetOwnerByIdQuery(id),
                ResponseTypes.instanceOf(Owner.class)).join();
    }

    @GetMapping("/vehicles/{id}")
    public List<Vehicle> ownerVehicles(@PathVariable String id){
        return queryGateway.query(new GetOwnerVehiclesQuery(id),
                ResponseTypes.multipleInstancesOf(Vehicle.class)).join();
    }

    @GetMapping("/vehicle/allVehicles")
    public List<Vehicle> getAllVehicles(){
        return queryGateway.query(new GetAllVehiclesQuery(),
                ResponseTypes.multipleInstancesOf(Vehicle.class)).join();
    }

    @GetMapping("/vehicle/{id}")
    public Vehicle VehicleInfo(@PathVariable String id){
        return queryGateway.query(new GetVehicleByIdQuery(id),
                ResponseTypes.instanceOf(Vehicle.class)).join();
    }

    @GetMapping("/vehicle/matricule/{id}")
    public Vehicle VehicleByMatriculeInfo(@PathVariable String id){
        return queryGateway.query(new GetVehicleByMatriculeQuery(id),
                ResponseTypes.instanceOf(Vehicle.class)).join();
    }
}
