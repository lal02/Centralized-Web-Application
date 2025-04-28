package com.lalbr.core.dashboard;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name ="api_config")
@Entity
public class APIConfigModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "apiConfigModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<APIConfigField> fields = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<APIConfigField> getFields() {
        return fields;
    }

    public void setFields(List<APIConfigField> fields) {
        this.fields = fields;
    }

    public void addField(String field) {
        //this.fields.add(field);
    }
}
