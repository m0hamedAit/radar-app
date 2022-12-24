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
@RequestMapping("/commands/owner")
public class OwnerCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createOwner(@RequestBody CreateOwnerRequestDTO request) {
        return commandGateway.send(new CreateOwnerCommand(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getBirthday(),
                request.getEmail(),
                request.getPhone()
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateOwner(@RequestBody UpdateOwnerRequestDTO request) {
        return commandGateway.send(new UpdateOwnerCommand(
                request.getId(),
                request.getName(),
                request.getBirthday(),
                request.getEmail(),
                request.getPhone()
        ));
    }

    @DeleteMapping("/delete/{id}")
    public CompletableFuture<String> deleteOwner(@PathVariable String id) {
        return commandGateway.send(new DeleteOwnerCommand(
                id
        ));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
