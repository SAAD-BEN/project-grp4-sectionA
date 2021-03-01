package ma.fstg.projectgrp4seca.dao;


import ma.fstg.projectgrp4seca.bean.OperationImmobilier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationImmobilierDao extends JpaRepository<OperationImmobilier, Long> {
    OperationImmobilier findByBienImmobilierTitreFoncier(String titreFoncier);

    OperationImmobilier findByTypeOperationLibelle(String libelle);

    int deleteByBienImmobilierTitreFoncier(String titreFoncier);

}
