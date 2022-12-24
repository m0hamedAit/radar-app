package ma.m0hamedait.immatriculationquery.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.ownerquery.entities.Owner;
import ma.m0hamedait.ownerquery.repositories.OwnerRepository;
import ma.m0hamedait.vehiclequery.entities.Vehicle;
import ma.m0hamedait.vehiclequery.queries.GetAllVehiclesQuery;
import ma.m0hamedait.vehiclequery.queries.GetOwnerVehiclesQuery;
import ma.m0hamedait.vehiclequery.queries.GetVehicleByIdQuery;
import ma.m0hamedait.vehiclequery.queries.GetVehicleByMatriculeQuery;
import ma.m0hamedait.vehiclequery.repositories.VehicleRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class VehicleServiceHandler {
    private VehicleRepository vehicleRepository;
    private OwnerRepository ownerRepository;

    @EventHandler
    public void on(VehicleCreatedEvent event) {
        log.info("*** VehicleCreatedEvent received ***");
        Vehicle vehicle = new Vehicle();
        vehicle.setId(event.getId());
        vehicle.setMatricule(event.getMatricule());
        vehicle.setBrand(event.getBrand());
        vehicle.setModel(event.getModel());
        vehicle.setColor(event.getColor());
        vehicle.setFiscalPower(event.getFiscalPower());
        vehicle.setOwner(ownerRepository.findById(event.getOwnerID()).get());
        vehicleRepository.save(vehicle);
    }

    @EventHandler
    public void on(VehicleUpdatedEvent event) {
        log.info("*** VehicleUpdatedEvent received ***");
        Vehicle vehicle =  vehicleRepository.getById(event.getId());
        vehicle.setMatricule(event.getMatricule());
        vehicle.setBrand(event.getBrand());
        vehicle.setModel(event.getModel());
        vehicle.setColor(event.getColor());
        vehicle.setFiscalPower(event.getFiscalPower());
        vehicleRepository.save(vehicle);
    }

    @EventHandler
    public void on(VehicleDeletedEvent event) {
        log.info("*** VehicleDeletedEvent received ***");
        Vehicle vehicle = vehicleRepository.getById(event.getId());
        vehicleRepository.delete(vehicle);
    }

    @QueryHandler
    public List<Vehicle> on(GetAllVehiclesQuery query) {
        log.info("*** GetAllVehiclesQuery received ***");
        return vehicleRepository.findAll();
    }

    @QueryHandler
    public Vehicle on(GetVehicleByIdQuery query) {
        log.info("*** GetVehicleByIdQuery received ***");
        return vehicleRepository.getById(query.getId());
    }

    @QueryHandler
    public Vehicle on(GetVehicleByMatriculeQuery query) {
        log.info("*** GetVehicleByMatriculeQuery received ***");
        return vehicleRepository.getById(query.getMatricule());
    }

    @QueryHandler
    public List<Owner> on(GetOwnerVehiclesQuery query) {
        log.info("*** GetAllVehiclesByOwnerQuery received ***");
        return vehicleRepository.findAllByOwner(ownerRepository.getById(query.getOwnerId()));
    }

}
