package ma.fstg.projectgrp4seca.bean;

import javax.persistence.*;

@Entity
public class DocumentCadastre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typeDocument;
    private double montant;
    private String dateDocument;
    @ManyToOne
    private Client demandeur;
    @ManyToOne
    private BienImmobilier bienImmobilier;

    public BienImmobilier getBienImmobilier() {
        return bienImmobilier;
    }

    public void setBienImmobilier(BienImmobilier bienImmobilier) {
        this.bienImmobilier = bienImmobilier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDateDocument() {
        return dateDocument;
    }

    public void setDateDocument(String dateDocument) {
        this.dateDocument = dateDocument;
    }

    public Client getDemandeur() {
        return demandeur;
    }

    public void setDemandeur(Client demandeur) {
        this.demandeur = demandeur;
    }
}
