package ru.rsatu.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HeaderSchedule")
public class HeaderSchedule {
    @Id
    private Long id_header_schedule;
    private String header_name;
    private Boolean approved;

    public Long getId_header_schedule() {
        return id_header_schedule;
    }

    public String getHeader_name() {
        return header_name;
    }

    public void setHeader_name(String header_name) {
        this.header_name = header_name;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public HeaderSchedule() {
    }

    public HeaderSchedule(String header_name, Boolean approved) {
        this.header_name = header_name;
        this.approved = approved;
    }
}
