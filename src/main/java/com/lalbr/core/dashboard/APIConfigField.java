package com.lalbr.core.dashboard;

import jakarta.persistence.*;

@Entity
@Table(name = "api_config_field")
public class APIConfigField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "api_config_id")
    private APIConfigModel apiConfigModel;

    @Column(name ="field_json_name")
    private String json_name;

    @Column(name = "field_display_name")
    private String display_name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJson_name() {
        return json_name;
    }

    public void setJson_name(String field) {
        this.json_name = field;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public APIConfigModel getApiConfigModel() {
        return apiConfigModel;
    }

    public void setApiConfigModel(APIConfigModel apiConfigModel) {
        this.apiConfigModel = apiConfigModel;
    }


}
