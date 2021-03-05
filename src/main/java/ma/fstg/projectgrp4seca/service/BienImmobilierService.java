package ma.fstg.projectgrp4seca.service;

import ma.fstg.projectgrp4seca.bean.BienImmobilier;
import ma.fstg.projectgrp4seca.bean.Cadastre;
import ma.fstg.projectgrp4seca.bean.Client;
import ma.fstg.projectgrp4seca.dao.BienImmobilierDao;
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
    @Autowired
    ClientService clientService;
    @Autowired
    OperationImmobilierService OperationImmobilierService;
    @Autowired
    TransactionImmobilierService transactionImmobilierService;

    public BienImmobilier findByTitreFoncier(String titreFoncier) {
        return bienImmobilierDao.findByTitreFoncier(titreFoncier);
    }

    @Transactional
    public int deleteByTitreFoncier(String titreFoncier) {
        if (OperationImmobilierService.findByBienImmobilierTitreFoncier(titreFoncier) == null) {
            transactionImmobilierService.deleteByBienImmobilierTitreFoncier(titreFoncier);
            bienImmobilierDao.deleteByTitreFoncier(titreFoncier);
            return 1;
        }
        return 0;
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

    public int modifyProprietaire(String titreFoncier, Client newProp) {
        BienImmobilier bt = findByTitreFoncier(titreFoncier);
        Client cl = clientService.findByRef(newProp.getRef());
        if (bt == null) {
            return -1;
        } else if (cl == null) {
            clientService.save(newProp);
            cl = clientService.findByRef(newProp.getRef());
            bt.setProprietaire(cl);
            bienImmobilierDao.save(bt);
            return 1;
        } else {
            bt.setProprietaire(cl);
            bienImmobilierDao.save(bt);
            return 2;
        }

    }

    public List<BienImmobilier> findByProprietaireRef(String ref) {
        return bienImmobilierDao.findByProprietaireRef(ref);
    }

    public int save(BienImmobilier bienImmobilier) {
        BienImmobilier bi = findByTitreFoncier(bienImmobilier.getTitreFoncier());
        Cadastre c = cadastreService.findByRef(bienImmobilier.getCadastre().getRef());
        Client cl = clientService.findByRef(bienImmobilier.getProprietaire().getRef());
        if (cl == null) clientService.save(bienImmobilier.getProprietaire());
        cl = clientService.findByRef(bienImmobilier.getProprietaire().getRef());
        if (bi != null) {
            return -1;
        } else if (c == null) {
            return -2;
        } else {
            bienImmobilier.setCadastre(c);
            bienImmobilier.setProprietaire(cl);
            bienImmobilierDao.save(bienImmobilier);
            return 1;
        }
    }
}
