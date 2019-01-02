package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.Localizacao;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class LocalizacaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private Integer id;

    @NotEmpty
    private Double latitude;

    @NotEmpty
    private Double longitude;

    public LocalizacaoDTO() {
    }

    public LocalizacaoDTO(Localizacao obj) {
        id = obj.getId();
        latitude = obj.getLatitude();
        longitude = obj.getLongitude();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
