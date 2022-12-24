package ma.m0hamedait.immatriculationcommand.aggregates;

import ma.m0hamedait.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
public class OwnerAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private Date birthDay;
    private String email;
    private String phone;

    public OwnerAggregate() {
    }

    @CommandHandler
    public OwnerAggregate(CreateOwnerCommand command) {
        AggregateLifecycle.apply(new OwnerCreatedEvent(command.getId(), command.getName(),
                command.getBirthday(), command.getEmail(), command.getPhone()));
    }

    @EventSourcingHandler
    public void on(OwnerCreatedEvent event){
        this.id = event.getId();
        this.name = event.getName();
        this.birthDay = event.getBirthday();
        this.email = event.getEmail();
        this.phone = event.getPhone();
    }

    @CommandHandler
    public void handle(UpdateOwnerCommand command){
        AggregateLifecycle.apply(new OwnerUpdatedEvent(command.getId(), command.getName(),
                command.getBirthday(), command.getEmail(), command.getTel()));
    }

    @EventSourcingHandler
    public void on(OwnerUpdatedEvent event){
        this.id = event.getId();
        this.name = event.getName();
        this.birthDay = event.getBirthday();
        this.email = event.getEmail();
        this.phone = event.getTel();
    }

    @CommandHandler
    public void handle(DeleteOwnerCommand command){
        AggregateLifecycle.apply(new OwnerDeletedEvent(command.getId()));
    }

    @EventSourcingHandler
    public void on(OwnerDeletedEvent event){
        AggregateLifecycle.markDeleted();
    }


}
