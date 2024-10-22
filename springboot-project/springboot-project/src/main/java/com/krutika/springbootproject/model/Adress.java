package com.krutika.springbootproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import javax.lang.model.element.Name;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "adress")
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addressId;
    private String city;
    private String adressType;
    @JsonIgnore
    @ManyToMany(mappedBy = "adress")
    private Set<Employee> employee = new HashSet<>();

    @Override
    public String toString() {
        return "Adress{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                ", adressType='" + adressType + '\'' +
                '}';
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdressType() {
        return adressType;
    }

    public void setAdressType(String adressType) {
        this.adressType = adressType;
    }



}
