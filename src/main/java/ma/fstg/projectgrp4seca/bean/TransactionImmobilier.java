package ma.fstg.projectgrp4seca.bean;

import javax.persistence.*;

@Entity
public class TransactionImmobilier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typeOperation;
    private String referenceAncienProprietaire;
    private String referenceNouveauProprietaire;
    private double montant;

    @ManyToOne
    private BienImmobilier bienImmobilier;

    public TransactionImmobilier() {
        super();
    }

    public TransactionImmobilier(Long id, String typeOperation,
                                 String referenceAncienProprietaire, String referenceNouveauProprietaire, double montant,String titreFoncierBienImmobilier) {
        super();
        this.id = id;
        this.typeOperation = typeOperation;
        this.referenceAncienProprietaire = referenceAncienProprietaire;
        this.referenceNouveauProprietaire = referenceNouveauProprietaire;
        this.montant = montant;
        this.bienImmobilier.setTitreFoncier(titreFoncierBienImmobilier);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BienImmobilier getBienImmobilier() {
        return bienImmobilier;
    }

    public void setBienImmobilier(BienImmobilier bienImmobilier) {
        this.bienImmobilier = bienImmobilier;
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
