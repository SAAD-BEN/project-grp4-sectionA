package ma.fstg.projectgrp4seca.bean;

import javax.persistence.*;

@Entity
public class TransactionImmobilier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double montant;
    @ManyToOne
    private Client nouveauProprietaire;
    @ManyToOne
    private BienImmobilier bienImmobilier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Client getNouveauProprietaire() {
        return nouveauProprietaire;
    }

    public void setNouveauProprietaire(Client nouveauProprietaire) {
        this.nouveauProprietaire = nouveauProprietaire;
    }

    public BienImmobilier getBienImmobilier() {
        return bienImmobilier;
    }

    public void setBienImmobilier(BienImmobilier bienImmobilier) {
        this.bienImmobilier = bienImmobilier;
    }
}
