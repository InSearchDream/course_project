package ru.rsatu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Trainer")
public class Trainer {
    @Id
    private Long id_trainer;
    private String last_name;
    private String first_name;
    private String middle_name;
    private String phone;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date birthday;

    public Long getId_trainer() {
        return id_trainer;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Trainer() {
    }

    public Trainer (String last_name, String first_name, String middle_name, String phone, Date birthday) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.phone = phone;
        this.birthday = birthday;
    }
}
