package ma.m0hamedait.immatriculationquery.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor

public class Vehicle {
    @Id
    private String id;
    private String matricule;
    private String brand;
    private String model;
    private String color;
    private int fiscalPower;
    @ManyToOne
    private Owner owner;
}
