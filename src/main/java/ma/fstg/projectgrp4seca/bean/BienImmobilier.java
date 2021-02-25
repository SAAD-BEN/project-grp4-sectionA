package ma.fstg.projectgrp4seca.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BienImmobilier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String localisation;
    private String titreFoncier;
    private double surface;
    private String refCadastre ;

    public String getRefCadastre() {
        return refCadastre;
    }

    public void setRefCadastre(String refCadastre) {
        this.refCadastre = refCadastre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getTitreFoncier() {
        return titreFoncier;
    }

    public void setTitreFoncier(String titreFoncier) {
        this.titreFoncier = titreFoncier;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

}
