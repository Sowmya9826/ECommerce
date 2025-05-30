package com.scaler.ecommerce.representingInheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_mentor")
@DiscriminatorValue(value ="2")
public class Mentor extends User {
    private double mentorRating;
}
