package ma.m0hamedait.immatriculationcommand;

import lombok.AllArgsConstructor;
import ma.m0hamedait.CreateOwnerCommand;
import ma.m0hamedait.CreateRadarCommand;
import ma.m0hamedait.CreateVehicleCommand;
import ma.m0hamedait.speedviolationapp.AxonConfig;
import net.datafaker.Faker;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@Import({AxonConfig.class})
@EnableDiscoveryClient
//@AllArgsConstructor
public class ImmatriculationCommandApplication {

   // private CommandGateway commandGateway;
    public static void main(String[] args) {
        SpringApplication.run(ImmatriculationCommandApplication.class, args);
    }

    @Bean
    public CommandBus commandBus() {
        return SimpleCommandBus.builder().build();
    }

    /*@Bean
    public CommandLineRunner commandLineRunner() {
        Faker faker = new Faker();
        List<String> ids = new ArrayList<>();
        return args -> {
            for (int i = 0; i < 15; i++) {
                String id = UUID.randomUUID().toString();
                ids.add(id);
                commandGateway.send(new CreateOwnerCommand(
                        id,
                        faker.name().fullName(),
                        faker.date().birthday(),
                        faker.internet().emailAddress(),
                        faker.phoneNumber().phoneNumber()
                ));
            }

            for (String id : ids) {
                int numberOfVehicles = (int) (Math.random() * (3 - 1 + 1) + 1);
                for (int i = 0; i < numberOfVehicles; i++) {
                    commandGateway.send(new CreateVehicleCommand(
                            UUID.randomUUID().toString(),
                            faker.vehicle().licensePlate(),
                            faker.vehicle().manufacturer(),
                            faker.vehicle().model(),
                            faker.vehicle().color(),
                            (int) (Math.random() * (500 - 4 + 1) + 4),
                            id
                    ));
                }
            }



        };
    }*/
}
