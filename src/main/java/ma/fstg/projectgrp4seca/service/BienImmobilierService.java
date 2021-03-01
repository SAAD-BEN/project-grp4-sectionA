package ma.fstg.projectgrp4seca.service;

import ma.fstg.projectgrp4seca.bean.BienImmobilier;
import ma.fstg.projectgrp4seca.bean.Cadastre;
import ma.fstg.projectgrp4seca.dao.BienImmobilierDao;
import ma.fstg.projectgrp4seca.dao.CadastreDao;
import ma.fstg.projectgrp4seca.ws.BienImmobilierProvided;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BienImmobilierService {
    @Autowired
    BienImmobilierDao bienImmobilierDao;
    @Autowired
    CadastreService cadastreService;


    public BienImmobilier findByTitreFoncier(String titreFoncier) {
        return bienImmobilierDao.findByTitreFoncier(titreFoncier);
    }

    @Transactional
    public int deleteByTitreFoncier(String titreFoncier) {
        return bienImmobilierDao.deleteByTitreFoncier(titreFoncier);
    }

    public List<BienImmobilier> findByLocalisationLike(String localistion) {
        return bienImmobilierDao.findByLocalisationLike(localistion);
    }

    public List<BienImmobilier> findBySurfaceGreaterThan(double minSurf) {
        return bienImmobilierDao.findBySurfaceGreaterThan(minSurf);
    }

    public List<BienImmobilier> findAll() {
        return bienImmobilierDao.findAll();
    }

    public int modifyTitreFoncier(String oldT, String newT) {
        BienImmobilier bt = findByTitreFoncier(oldT);
        BienImmobilier bt2 = findByTitreFoncier(newT);

        if (bt != null && bt2 == null) {
            bt.setTitreFoncier(newT);
            bienImmobilierDao.save(bt);
            return 1;
        } else if (bt == null) {
            return -1;
        } else {
            return -3;
        }

    }

    public int save(BienImmobilier bienImmobilier) {
        BienImmobilier b = findByTitreFoncier(bienImmobilier.getTitreFoncier());
        Cadastre c = cadastreService.findByRef(bienImmobilier.getCadastre().getRef());
        bienImmobilier.setCadastre(c);
        if (b != null) {
            return -1;
        } else if (c == null) {
            return -2;
        } else {
            bienImmobilierDao.save(bienImmobilier);
            return 1;
        }
    }

    public Cadastre findByCadastreRef(String ref) {
        return bienImmobilierDao.findByCadastreRef(ref);
    }
}
