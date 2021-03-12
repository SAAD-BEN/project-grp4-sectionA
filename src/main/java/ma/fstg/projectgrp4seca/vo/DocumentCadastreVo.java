package ma.fstg.projectgrp4seca.vo;

public class DocumentCadastreVo {
    private String typeDocument;
    private String maxMontant;
    private String minMontant;
    private String dateDocument;

    public String getDateDocument() {
        return dateDocument;
    }

    public void setDateDocument(String dateDocument) {
        this.dateDocument = dateDocument;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getMaxMontant() {
        return maxMontant;
    }

    public void setMaxMontant(String maxMontant) {
        this.maxMontant = maxMontant;
    }

    public String getMinMontant() {
        return minMontant;
    }

    public void setMinMontant(String minMontant) {
        this.minMontant = minMontant;
    }

}
