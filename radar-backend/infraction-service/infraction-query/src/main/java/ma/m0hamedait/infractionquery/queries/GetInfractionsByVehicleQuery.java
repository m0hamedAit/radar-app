package ma.m0hamedait.infractionquery.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class GetInfractionsByVehicleQuery {
    private String vehicleMatricule;
}
