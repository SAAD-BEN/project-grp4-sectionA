package ma.fstg.projectgrp4seca.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOperationDao extends JpaRepository<TypeOperationDao , Long> {
    TypeOperationDao finfByCode(String code) ;
    TypeOperationDao findByLibelle (String libelle) ;
    int deleteByCode (String code ) ;
    int deleteByLibelle (String libelle) ;
}
