package ma.m0hamedait.infractioncommand.controllers;

import lombok.AllArgsConstructor;
import ma.m0hamedait.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@RestController
@RequestMapping("/commands/infraction")
public class InfractionCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createInfraction(@RequestBody CreateInfractionRequestDTO request) {
        return commandGateway.send(new CreateInfractionCommand(
                UUID.randomUUID().toString(),
                new Date(),
                request.getRadarId(),
                request.getVehicleMatricule(),
                request.getVehicleSpeed(),
                request.getSpeedLimit(),
                request.getAmountToPay()
        ));
    }

    @PutMapping("/pay")
    public CompletableFuture<String> payInfraction(@RequestBody UpdateInfractionRequestDTO request) {
        if(request.isPaid()){
            throw new IllegalArgumentException("Infraction is already paid");
        }
        return commandGateway.send(new PayInfractionCommand(
                request.getId(),
                request.getAmountToPay(),
                request.isPaid()
        ));
    }


}
