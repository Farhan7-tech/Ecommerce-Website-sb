package com.ecommerce.sbEcommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min = 5 , message = "Street name must be at least 5 characters")
    private String street;

    @NotBlank
    @Size(min = 5 , message = "Building name must be atleast 5 characters")
    private String buildingName;

    @NotBlank
    @Size(min = 4 , message = "City name must be at least 4 characters")
    private String city;

    @NotBlank
    @Size(min = 5 , message = "State name must be at least 2 characters")
    private String state;

    @NotBlank
    @Size(min = 2 , message = "Country name must be at least 2 characters")
    private String country;

    @NotBlank
    @Size(min = 6 , message = "Pincode  must be at least 2 characters")
    private String pincode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Address(String city, String country, String pincode, String state, String street) {
        this.city = city;
        this.country = country;
        this.pincode = pincode;
        this.state = state;
        this.street = street;
    }
}
