package ma.fstg.projectgrp4seca.dao;

import ma.fstg.projectgrp4seca.bean.Cadastre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CadastreDao extends JpaRepository<Cadastre, Long> {
    Cadastre findByRef(String ref);

    int deleteByRef(String ref);

    List<Cadastre> findByDescriptionLike(String description);
}
