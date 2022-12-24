package ma.m0hamedait.radarcommand.controllers;

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
@RequestMapping("/commands/radar")
public class radarCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    //Faker faker = new Faker();

    /* @PostMapping("/create")
    public CompletableFuture<String> createRadar() {
        return commandGateway.send(new CreateRadarCommand(
                UUID.randomUUID().toString(),
                faker.address().longitude(),
                faker.address().latitude(),
                (int) (Math.random() * (200 - 100 + 1) + 100)
        ));
    } */

    @PostMapping("/create")
    public CompletableFuture<String> createRadar(@RequestBody CreateRadarRequestDTO request) {
        return commandGateway.send(new CreateRadarCommand(
                UUID.randomUUID().toString(),
                request.getLongitude(),
                request.getLatitude(),
                request.getSpeedLimit()
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateRadar(@RequestBody UpdateRadarRequestDTO request) {
        return commandGateway.send(new UpdateRadarCommand(
                request.getId(),
                request.getLongitude(),
                request.getLatitude(),
                request.getSpeedLimit()
        ));
    }

    //delete radar
     @DeleteMapping("/delete/{id}")
    public CompletableFuture<String> deleteRadar(@PathVariable String id) {
         return commandGateway.send(new DeleteRadarCommand(
                 id
         ));
     }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
