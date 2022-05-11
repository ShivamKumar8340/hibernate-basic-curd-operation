package com.sunglowsys.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "add_img")
public class AddrressAndImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30,name = "str")
    private String street;
    private String city;

    private boolean isOpen;

    //to neglect column
    @Transient
    private String x;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Lob
    private byte[] image;

    public AddrressAndImage() {}

    public AddrressAndImage(Long id, String street, String city, boolean isOpen, String x, Date date, byte[] image) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.isOpen = isOpen;
        this.x = x;
        this.date = date;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
