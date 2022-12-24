package ma.m0hamedait.immatriculationquery.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.OwnerCreatedEvent;
import ma.m0hamedait.OwnerDeletedEvent;
import ma.m0hamedait.OwnerUpdatedEvent;
import ma.m0hamedait.immatriculationquery.entities.Owner;
import ma.m0hamedait.immatriculationquery.entities.Vehicle;
import ma.m0hamedait.immatriculationquery.queries.GetAllOwnersQuery;
import ma.m0hamedait.immatriculationquery.queries.GetOwnerByIdQuery;
import ma.m0hamedait.immatriculationquery.queries.GetOwnerVehiclesQuery;
import ma.m0hamedait.immatriculationquery.repositories.OwnerRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class OwnerServiceHandler {
    private OwnerRepository ownerRepository;

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
        Owner owner = ownerRepository.getById(event.getId());
        owner.setName(event.getName());
        owner.setBirthDay(event.getBirthday());
        owner.setEmail(event.getEmail());
        owner.setPhone(event.getTel());
        ownerRepository.save(owner);
    }

    @EventHandler
    public void on(OwnerDeletedEvent event) {
        log.info("*** OwnerDeletedEvent received ***");
        Owner owner = ownerRepository.getById(event.getId());
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
        return ownerRepository.getById(query.getId());
    }


    @QueryHandler
    public List<Vehicle> on(GetOwnerVehiclesQuery query) {
        log.info("*** GetOwnerVehiclesQuery received ***");
        return ownerRepository.getById(query.getId()).getVehicle();
    }
}
