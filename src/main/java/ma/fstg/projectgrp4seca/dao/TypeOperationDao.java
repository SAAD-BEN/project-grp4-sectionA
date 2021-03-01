package ma.fstg.projectgrp4seca.dao;

import ma.fstg.projectgrp4seca.bean.TypeOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOperationDao extends JpaRepository<TypeOperation, Long> {
    TypeOperation findByLibelle(String libelle);

    int deleteByLibelle(String libelle);
}
