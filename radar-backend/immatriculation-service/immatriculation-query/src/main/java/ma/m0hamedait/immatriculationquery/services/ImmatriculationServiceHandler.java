package ma.m0hamedait.immatriculationquery.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.*;
import ma.m0hamedait.immatriculationquery.entities.Owner;
import ma.m0hamedait.immatriculationquery.entities.Vehicle;
import ma.m0hamedait.immatriculationquery.queries.*;
import ma.m0hamedait.immatriculationquery.repositories.OwnerRepository;
import ma.m0hamedait.immatriculationquery.repositories.VehicleRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ImmatriculationServiceHandler {
    private OwnerRepository ownerRepository;
    private VehicleRepository vehicleRepository;

    @EventHandler
    public void on(OwnerCreatedEvent event) {
        log.info("*** OwnerCreatedEvent received ***");
        Owner owner = new Owner();
        owner.setId(event.getId());
        owner.setName(event.getName());
        owner.setBirthDay(event.getBirthday());
        owner.setEmail(event.getEmail());
        owner.setPhone(event.getPhone());
        ownerRepository.save(owner);
    }

    @EventHandler
    public void on(OwnerUpdatedEvent event) {
        log.info("*** OwnerUpdatedEvent received ***");
        Owner owner = ownerRepository.findById(event.getId()).get();
        owner.setName(event.getName());
        owner.setBirthDay(event.getBirthday());
        owner.setEmail(event.getEmail());
        owner.setPhone(event.getTel());
        ownerRepository.save(owner);
    }

    @EventHandler
    public void on(OwnerDeletedEvent event) {
        log.info("*** OwnerDeletedEvent received ***");
        Owner owner = ownerRepository.findById(event.getId()).get();
        ownerRepository.delete(owner);
    }

    @QueryHandler
    public List<Owner> on(GetAllOwnersQuery query) {
        log.info("*** GetAllOwnersQuery received ***");
        return ownerRepository.findAll();
    }

    @QueryHandler
    public Owner on(GetOwnerByIdQuery query) {
        log.info("*** GetOwnerByIdQuery received ***");
        return ownerRepository.findById(query.getId()).get();
    }

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
        Vehicle vehicle =  vehicleRepository.findById(event.getId()).get();
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
        Vehicle vehicle = vehicleRepository.findById(event.getId()).get();
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
        return vehicleRepository.findById(query.getId()).get();
    }

    @QueryHandler
    public Vehicle on(GetVehicleByMatriculeQuery query) {
        log.info("*** GetVehicleByMatriculeQuery received ***");
        return vehicleRepository.findByMatricule(query.getId());
    }

    @QueryHandler
    public List<Vehicle> on(GetOwnerVehiclesQuery query) {
        log.info("*** GetAllVehiclesByOwnerQuery received ***");
        return vehicleRepository.findAllByOwner(ownerRepository.findById(query.getId()).get());
    }
}
