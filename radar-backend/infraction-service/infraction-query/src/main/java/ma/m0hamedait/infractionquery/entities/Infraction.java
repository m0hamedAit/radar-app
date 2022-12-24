package ma.m0hamedait.infractionquery.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Infraction {
    @Id
    private String id;
    private Date date;
    private String radarId;
    private String vehicleMatricule;
    private int vehicleSpeed;
    private int radarSpeedLimit;
    private Double amountToPay;
    private Boolean paid;
}
