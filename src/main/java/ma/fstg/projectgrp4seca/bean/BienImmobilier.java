package ma.fstg.projectgrp4seca.bean;

import javax.persistence.*;

@Entity
public class BienImmobilier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String localisation;
    private String titreFoncier;
    private double surface;

    @ManyToOne
    private Cadastre cadastre;

    public Cadastre getCadastre() {
        return cadastre;
    }

    public void setCadastre(Cadastre cadastre) {
        this.cadastre = cadastre;
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
