package ma.fstg.projectgrp4seca.dao;

import ma.fstg.projectgrp4seca.bean.BienImmobilier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BienImmobilierDao extends JpaRepository<BienImmobilier, Long> {
    BienImmobilier findByTitreFoncier(String titreFoncier);

    int deleteByTitreFoncier(String titreFoncier);

    List<BienImmobilier> findByLocalisationLike(String localistion);

    List<BienImmobilier> findBySurfaceGreaterThan(double minSurf);

    List<BienImmobilier> findByProprietaireRef(String ref);
}
