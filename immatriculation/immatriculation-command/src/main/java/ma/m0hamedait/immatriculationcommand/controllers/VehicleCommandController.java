package ma.m0hamedait.immatriculationcommand.controllers;

import lombok.AllArgsConstructor;
import ma.m0hamedait.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@RestController
@RequestMapping("/commands/vehicle")
public class VehicleCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createVehicle(@RequestBody CreateVehicleRequestDTO request) {
        return commandGateway.send(new CreateVehicleCommand(
                UUID.randomUUID().toString(),
                request.getMatricule(),
                request.getBrand(),
                request.getModel(),
                request.getColor(),
                request.getFiscalPower(),
                request.getOwnerId()
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateVehicle(@RequestBody UpdateVehicleRequestDTO request) {
        return commandGateway.send(new UpdateVehicleCommand(
                request.getId(),
                request.getMatricule(),
                request.getBrand(),
                request.getModel(),
                request.getColor(),
                request.getFiscalPower()
        ));
    }

    @DeleteMapping("/delete/{id}")
    public CompletableFuture<String> deleteVehicle(@PathVariable String id) {
        return commandGateway.send(new DeleteVehicleCommand(
                id
        ));
    }

    @PutMapping("/changeOwner")
    public CompletableFuture<String> changeOwner(@RequestBody ChangeVehiculeOwnerCommand request) {
        return commandGateway.send(new ChangeVehiculeOwnerCommand(
                request.getId(),
                request.getOwnerId()
        ));
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
