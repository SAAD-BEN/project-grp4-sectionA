package ma.fstg.projectgrp4seca.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionImmobilier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titreFoncierBienImmobilier;
    private String typeOperation;
    private String referenceAncienProprietaire;
    private String referenceNouveauProprietaire;
    private double montant;

    public TransactionImmobilier() {
        super();
        // TODO Auto-generated constructor stub
    }

    public TransactionImmobilier(Long id, String titreFoncierBienImmobilier, String typeOperation,
                                 String referenceAncienProprietaire, String referenceNouveauProprietaire, double montant) {
        super();
        this.id = id;
        this.titreFoncierBienImmobilier = titreFoncierBienImmobilier;
        this.typeOperation = typeOperation;
        this.referenceAncienProprietaire = referenceAncienProprietaire;
        this.referenceNouveauProprietaire = referenceNouveauProprietaire;
        this.montant = montant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitreFoncierBienImmobilier() {
        return titreFoncierBienImmobilier;
    }

    public void setTitreFoncierBienImmobilier(String titreFoncierBienImmobilier) {
        this.titreFoncierBienImmobilier = titreFoncierBienImmobilier;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public String getReferenceAncienProprietaire() {
        return referenceAncienProprietaire;
    }

    public void setReferenceAncienProprietaire(String referenceAncienProprietaire) {
        this.referenceAncienProprietaire = referenceAncienProprietaire;
    }

    public String getReferenceNouveauProprietaire() {
        return referenceNouveauProprietaire;
    }

    public void setReferenceNouveauProprietaire(String referenceNouveauProprietaire) {
        this.referenceNouveauProprietaire = referenceNouveauProprietaire;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "TransactionImmobilier [id=" + id + ", titreFoncierBienImmobilier=" + titreFoncierBienImmobilier
                + ", typeOperation=" + typeOperation + ", referenceAncienProprietaire=" + referenceAncienProprietaire
                + ", referenceNouveauProprietaire=" + referenceNouveauProprietaire + ", montant=" + montant + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TransactionImmobilier other = (TransactionImmobilier) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


}
