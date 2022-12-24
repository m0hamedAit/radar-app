package ma.m0hamedait.immatriculationquery.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class GetVehicleByMatriculeQuery {
    private String matricule;
}
