package ru.rsatu.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "section")
public class Section {
    @Id
    private Long id_section;
    private String section_name;
    private String id_trainer;

    public Long getId_section() {
        return id_section;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public String getId_trainer() {
        return id_trainer;
    }

    public void setId_trainer(String id_trainer) {
        this.id_trainer = id_trainer;
    }

    public Section() {
    }

}
