package ma.m0hamedait.infractioncommand;

import lombok.AllArgsConstructor;
import ma.m0hamedait.CreateInfractionCommand;
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

import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Import({AxonConfig.class})
//@AllArgsConstructor
@EnableDiscoveryClient
public class InfractionCommandApplication {

    //private CommandGateway commandGateway;

    public static void main(String[] args) {
        SpringApplication.run(InfractionCommandApplication.class, args);
    }

    @Bean
    public CommandBus commandBus() {
        return SimpleCommandBus.builder().build();
    }

    /*@Bean
    public CommandLineRunner commandLineRunner() {
        //create and initialize a list of ids at the same time
        Faker faker = new Faker();

        List<String> vehicleMatricules = new ArrayList<>();
        List<String> radarIds = new ArrayList<>();
        List<Integer> radarMaxSpeeds = new ArrayList<>();
        Collections.addAll(vehicleMatricules,"tsv-0959", "cde-6641",
                "mwe-3943", "dih-4841", "kad-0882", "jkg-4058", "rzs-7373", "czh-0772", "wfn-2919", "vdf-6533", "ekn-8399");
        Collections.addAll(radarIds, "1945a2ec-fcfd-4dee-9ce9-3dde77d3539f", "1945a2ec-fcfd-4dee-9ce9-3dde77d3539f", "1945a2ec-fcfd-4dee-9ce9-3dde77d3539f", "7e7a8ddc-2f56-44cd-a70b-5dc308e466cf",
                "7e7a8ddc-2f56-44cd-a70b-5dc308e466cf", "ab1c0f3f-3375-4681-9438-6bd344db6c35", "ab1c0f3f-3375-4681-9438-6bd344db6c35", "ab1c0f3f-3375-4681-9438-6bd344db6c35",
                "ab1c0f3f-3375-4681-9438-6bd344db6c35", "ab1c0f3f-3375-4681-9438-6bd344db6c35", "ab1c0f3f-3375-4681-9438-6bd344db6c35", "ab1c0f3f-3375-4681-9438-6bd344db6c35");
        Collections.addAll(radarMaxSpeeds, 64,69,139,156,120,174,137,132,193,153,82,130);
        return args -> {
            for (int i = 0; i < 25; i++) {
                int randN = faker.number().numberBetween(0, radarIds.size() - 1);

                commandGateway.send(new CreateInfractionCommand(
                        UUID.randomUUID().toString(),
                        new Date(),
                        radarIds.get(randN),
                        vehicleMatricules.get(faker.number().numberBetween(0, vehicleMatricules.size() - 1)),
                        radarMaxSpeeds.get(randN)+faker.number().numberBetween(10, 100),
                        radarMaxSpeeds.get(randN),
                        (double) faker.number().numberBetween(50, 4500)
                ));
            }


        };
    }*/

}
