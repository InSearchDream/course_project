package ru.rsatu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "learner")
public class Learner extends People {
    @Id
    private Long id_learner;
    private String id_section;
    private Boolean enrolled;

    public Long getId_learner() {
        return id_learner;
    }

    public String getId_section() {
        return id_section;
    }

    public void setId_section(String id_section) {
        this.id_section = id_section;
    }

    public Boolean getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(Boolean enrolled) {
        this.enrolled = enrolled;
    }

    public Learner() {
    }

}
