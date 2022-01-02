package ru.rsatu.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Place")
public class Place {
    @Id
    private Long id_place;
    private String place_name;

    public Long getId_place() {
        return id_place;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public Place() {
    }
    public Place(String place_name) {
        this.place_name = place_name;
    }
}
