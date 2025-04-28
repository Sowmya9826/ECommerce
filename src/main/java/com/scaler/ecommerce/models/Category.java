package com.scaler.ecommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{

    private String title;
    @OneToMany (mappedBy = "category")//(fetch = FetchType.EAGER)
    private List<Product> products;
}
