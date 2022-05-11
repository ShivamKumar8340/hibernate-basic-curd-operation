package com.sunglowsys.embaddeableE;

import javax.persistence.Embeddable;

@Embeddable
public class AddressEmp {
    private String street;
    private String city;

    public AddressEmp() {}

    public AddressEmp(String street, String city) {
        this.street = street;
        this.city = city;
    }



    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address2{" +

                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
