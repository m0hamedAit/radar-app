package ma.m0hamedait.radarcommand.aggregates;

import ma.m0hamedait.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class RadarAggregate {
    @AggregateIdentifier
    private String id;
    private String longitude;
    private String latitude;
    private int speedLimit;

    public RadarAggregate(){

    }

    @CommandHandler
    public RadarAggregate(CreateRadarCommand command){
        AggregateLifecycle.apply(new RadarCreatedEvent(command.getId(), command.getLongitude(), command.getLatitude(), command.getSpeedLimit()));
    }

    @EventSourcingHandler
    public void on(RadarCreatedEvent event){
        this.id = event.getId();
        this.longitude = event.getLongitude();
        this.latitude = event.getLatitude();
        this.speedLimit = event.getSpeedLimit();
    }

    @CommandHandler
    public void handle(UpdateRadarCommand command){
        AggregateLifecycle.apply(new RadarUpdatedEvent(command.getId(), command.getLongitude(), command.getLatitude(), command.getSpeedLimit()));
    }

    @EventSourcingHandler
    public void on(RadarUpdatedEvent event){
        this.id = event.getId();
        this.longitude = event.getLongitude();
        this.latitude = event.getLatitude();
        this.speedLimit = event.getSpeedLimit();
    }

    @CommandHandler
    public void handle(DeleteRadarCommand command){
        AggregateLifecycle.apply(new RadarDeletedEvent(command.getId()));
    }

    @EventSourcingHandler
    public void on(RadarDeletedEvent event){
        AggregateLifecycle.markDeleted();
    }
}
