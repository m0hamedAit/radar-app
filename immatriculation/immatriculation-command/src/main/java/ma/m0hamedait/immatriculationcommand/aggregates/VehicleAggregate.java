package ma.m0hamedait.immatriculationcommand.aggregates;

import ma.m0hamedait.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class VehicleAggregate {
    @AggregateIdentifier
    private String id;
    private String matricule;
    private String brand;
    private String model;
    private String color;
    private int fiscalPower;
    private String ownerId;


    public VehicleAggregate() {
    }

    @CommandHandler
    public VehicleAggregate(CreateVehicleCommand command) {
        AggregateLifecycle.apply(new VehicleCreatedEvent(command.getId(), command.getMatricule(),
                command.getBrand(), command.getModel(), command.getColor(), command.getFiscalPower(),
                command.getOwnerID()));
    }

    @EventSourcingHandler
    public void on(VehicleCreatedEvent event) throws Exception {
        this.id = event.getId();
        this.matricule = event.getMatricule();
        this.brand = event.getBrand();
        this.model = event.getModel();
        this.color = event.getColor();
        this.fiscalPower = event.getFiscalPower();
        this.ownerId = event.getOwnerID();
    }

    @CommandHandler
    public void handle(UpdateVehicleCommand command){
        AggregateLifecycle.apply(new VehicleUpdatedEvent(command.getId(), command.getMatricule(),
                command.getBrand(), command.getModel(), command.getColor(), command.getFiscalPower()));
    }

    @EventSourcingHandler
    public void on(VehicleUpdatedEvent event){
        this.id = event.getId();
        this.matricule = event.getMatricule();
        this.brand = event.getBrand();
        this.model = event.getModel();
        this.color = event.getColor();
        this.fiscalPower = event.getFiscalPower();
    }

    @CommandHandler
    public void handle(DeleteVehicleCommand command){
        AggregateLifecycle.apply(new VehicleDeletedEvent(command.getId()));
    }

    @EventSourcingHandler
    public void on(VehicleDeletedEvent event){
        AggregateLifecycle.markDeleted();
    }

    @CommandHandler
    public void handle(ChangeVehiculeOwnerCommand command){
        AggregateLifecycle.apply(new VehicleOwnerChangedEvent(command.getId(), command.getOwnerId()));
    }
}
