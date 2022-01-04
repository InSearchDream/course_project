package ru.rsatu.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.sql.Date;

@Entity
@Table(name = "Schedule")
public class Schedule {
    @Id
    private Long id_schedule;
    private String id_place;
    private String id_section;
    private String id_header_schedule;
    private Date date;
    private Time time_start;
    private Time time_end;
    private Boolean cansell;
    private String note;

    public Long getId_schedule() {
        return id_schedule;
    }

    public String getId_place() {
        return id_place;
    }

    public void setId_place(String id_place) {
        this.id_place = id_place;
    }

    public String getId_section() {
        return id_section;
    }

    public void setId_section(String id_section) {
        this.id_section = id_section;
    }

    public String getId_header_schedule() {
        return id_header_schedule;
    }

    public void setId_header_schedule(String id_header_schedule) {
        this.id_header_schedule = id_header_schedule;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime_start() {
        return time_start;
    }

    public void setTime_start(Time time_start) {
        this.time_start = time_start;
    }

    public Time getTime_end() {
        return time_end;
    }

    public void setTime_end(Time time_end) {
        this.time_end = time_end;
    }

    public Boolean getCansell() {
        return cansell;
    }

    public void setCansell(Boolean cansell) {
        this.cansell = cansell;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Schedule() {
    }

    public Schedule(String id_place, String id_section, String id_header_schedule, Date date, Time time_start, Time time_end, Boolean cansell, String note) {
        this.id_place = id_place;
        this.id_section = id_section;
        this.id_header_schedule = id_header_schedule;
        this.date = date;
        this.time_start = time_start;
        this.time_end = time_end;
        this.cansell = cansell;
        this.note = note;
    }
}
