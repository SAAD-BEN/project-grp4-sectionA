package ma.fstg.projectgrp4seca.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class OperationImmobilier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String titreFoncierBienImmobilier;
    String typeOperation;
    double montant;

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

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "OperationImmobilier{" +
                "id=" + id +
                ", titreFoncierBienImmobilier='" + titreFoncierBienImmobilier + '\'' +
                ", typeOperation='" + typeOperation + '\'' +
                ", montant=" + montant +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationImmobilier that = (OperationImmobilier) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}