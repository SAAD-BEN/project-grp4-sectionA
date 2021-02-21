package ma.fstg.projectgrp4seca.dao;


import ma.fstg.projectgrp4seca.bean.OperationImmobilier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatonImmobilierDao extends JpaRepository<OperationImmobilier, Long> {
    OperationImmobilier findbyTitreFoncierBienImmobilier(String titreFoncierBienImmobilier);

    OperationImmobilier findbyTypeOperation(String typeOperation);

    OperationImmobilier DeletebyTypeOperation(String typeOperation);

}
