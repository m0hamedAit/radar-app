package ma.m0hamedait.immatriculationquery;

import ma.m0hamedait.speedviolationapp.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({AxonConfig.class})
@EnableDiscoveryClient
public class ImmatriculationQueryApplication {
    public static void main(String[] args) {
        SpringApplication.run(ImmatriculationQueryApplication.class, args);
    }
}
