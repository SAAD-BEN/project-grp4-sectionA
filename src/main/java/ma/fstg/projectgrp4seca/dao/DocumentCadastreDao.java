package ma.fstg.projectgrp4seca.dao;

import ma.fstg.projectgrp4seca.bean.DocumentCadastre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentCadastreDao extends JpaRepository<DocumentCadastre, Long> {
    List<DocumentCadastre> findByBienImmobilierTitreFoncier(String titreImmobilier);

    List<DocumentCadastre> findAllByDemandeur(String demandeur);

    int deleteByBienImmobilierTitreFoncierAndDateDocumentAndTypeDocument(String titreImmobilier, String dateDocument,String typeDocuent);
}
