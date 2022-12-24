package ma.m0hamedait.immatriculationquery.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Owner {
    @Id
    private String id;
    private String name;
    private Date birthDay;
    private String email;
    private String phone;
    @OneToMany(mappedBy = "owner")
    private List<Vehicle> vehicle;
}
