/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulval.stetoskop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.Data;

/**
 *
 * @author Diego Dulval
 */
@Data
@Entity
public class InterationMedicament implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private InterationMedicamentPK id = new InterationMedicamentPK();

    private String description;

    @JsonProperty("medicament")
    @JsonIgnoreProperties(value = {"interations"})
    public Medicament getMedicamentInteration() {
        return id.getMedicamentInteration();
    }

    public void setMedicamentInteration(Medicament med) {
        id.setMedicamentInteration(med);
    }

    public InterationMedicament() {
    }

    public InterationMedicament(Medicament a, Medicament b, String description) {
        id.setMedicament(a);
        id.setMedicamentInteration(b);
        this.description = description;
    }
}
