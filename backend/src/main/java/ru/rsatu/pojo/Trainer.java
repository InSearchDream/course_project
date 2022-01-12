package ru.rsatu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "trainer")
public class Trainer extends People{
    @Id
    private Long id_trainer;

    public Long getId_trainer() {
        return id_trainer;
    }

    public Trainer() {
    }

}
