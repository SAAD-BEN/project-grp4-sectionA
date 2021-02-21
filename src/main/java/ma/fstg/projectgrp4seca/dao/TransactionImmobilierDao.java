package ma.fstg.projectgrp4seca.dao;


import java.util.List;

import ma.fstg.projectgrp4seca.bean.TransactionImmobilier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionImmobilierDao extends JpaRepository<TransactionImmobilier, Long> {

    TransactionImmobilier findByTitreFoncierBienImmobilier(String titreFoncierBienImmobilier);

    int deleteByTitreFoncierBienImmobilier(String titreFoncierBienImmobilier);

    List<TransactionImmobilier> findByReferenceNouveauProprietaire(String referenceNouveauProprietaire);

    List<TransactionImmobilier> findByReferenceAncienProprietaire(String referenceAncienProprietaire);

}
