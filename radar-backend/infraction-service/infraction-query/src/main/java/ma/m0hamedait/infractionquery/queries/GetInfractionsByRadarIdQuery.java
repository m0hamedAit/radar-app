package ma.m0hamedait.infractionquery.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class GetInfractionsByRadarIdQuery {
    private String radarId;
}
