package ma.m0hamedait.infractioncommand.aggregates;

import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
@Slf4j
public class InfractionAggregate {
    @AggregateIdentifier
    private String id;
    private Date date;
    private String radarId;
    private String vehicleMatricule;
    private int vehicleSpeed;
    private int radarSpeedLimit;
    private Double amountToPay;
    private boolean paid;

    public InfractionAggregate() {
    }

    @CommandHandler
    public InfractionAggregate(CreateInfractionCommand command) {
        AggregateLifecycle.apply(new InfractionCreatedEvent(command.getId(), command.getDate(),
                command.getRadarId(), command.getVehicleMatricule(), command.getVehicleSpeed(),
                command.getSpeedLimit(), command.getAmountToPay(), false));
    }

    @EventSourcingHandler
    public void on(InfractionCreatedEvent event) {
        this.id = event.getId();
        this.radarId = event.getRadarID();
        this.vehicleMatricule = event.getVehicleMatricule();
        this.vehicleSpeed = event.getVehicleSpeed();
        this.radarSpeedLimit = event.getRadarSpeedLimit();
        this.amountToPay = event.getAmountToPay();
        this.paid = event.isPaid();
    }

    @CommandHandler
    public void handle(UpdateInfractionCommand command) {
        AggregateLifecycle.apply(new InfractionPaidEvent(command.getId(),
                command.getAmountToPay(), command.getPaid()));
    }

    @EventSourcingHandler
    public void on(InfractionPaidEvent event) {
        this.id = event.getId();
        this.amountToPay = event.getAmountToPay();
        this.paid = event.isPaid();
    }
}
