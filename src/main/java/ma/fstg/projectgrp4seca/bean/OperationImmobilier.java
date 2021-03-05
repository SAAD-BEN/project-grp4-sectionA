package ma.fstg.projectgrp4seca.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OperationImmobilier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double montant;
    private String proprietaire ;
    @ManyToOne
    private BienImmobilier bienImmobilier;
    @ManyToOne
    private TypeOperation typeOperation;


    public BienImmobilier getBienImmobilier() {
        return bienImmobilier;
    }

    public void setBienImmobilier(BienImmobilier bienImmobilier) {
        this.bienImmobilier = bienImmobilier;
    }
    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

}