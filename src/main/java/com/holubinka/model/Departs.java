package com.holubinka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DEPARTS")
public class Departs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DEPART_NAME")
    private String departName;

    @Column(name = "HEAD_OF_DEPART")
    private String headOfDepart;

    @ManyToMany(mappedBy = "departs")
    private List<Lectors> lectors = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getHeadOfDepart() {
        return headOfDepart;
    }

    public void setHeadOfDepart(String headOfDepart) {
        this.headOfDepart = headOfDepart;
    }

    public List<Lectors> getLectors() {
        return lectors;
    }

    public void setLectors(List<Lectors> lectors) {
        this.lectors = lectors;
    }
}
