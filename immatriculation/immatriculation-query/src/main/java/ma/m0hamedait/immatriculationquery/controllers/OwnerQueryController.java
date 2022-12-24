package ma.m0hamedait.immatriculationquery.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.immatriculationquery.entities.Owner;
import ma.m0hamedait.immatriculationquery.entities.Vehicle;
import ma.m0hamedait.immatriculationquery.queries.GetAllOwnersQuery;
import ma.m0hamedait.immatriculationquery.queries.GetOwnerByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/queries/radar")
@AllArgsConstructor
@Slf4j
public class OwnerQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/allRadars")
    public List<Owner> getAllOwners(){
        return queryGateway.query(new GetAllOwnersQuery(),
                ResponseTypes.multipleInstancesOf(Owner.class)).join();
    }

    @GetMapping("/{id}")
    public Owner ownerInfo(String id){
        return queryGateway.query(new GetOwnerByIdQuery(id),
                ResponseTypes.instanceOf(Owner.class)).join();
    }

    @GetMapping("/vehicles/{id}")
    public List<Vehicle> ownerVehicles(String id){
        return queryGateway.query(new GetOwnerByIdQuery(id),
                ResponseTypes.multipleInstancesOf(Vehicle.class)).join();
    }
}
