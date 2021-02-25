package ma.fstg.projectgrp4seca.service;


import java.util.List;

import ma.fstg.projectgrp4seca.bean.TransactionImmobilier;
import ma.fstg.projectgrp4seca.dao.BienImmobilierDao;
import ma.fstg.projectgrp4seca.dao.OperatonImmobilierDao;
import ma.fstg.projectgrp4seca.dao.TransactionImmobilierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TransactionImmobilierService {
    @Autowired
    TransactionImmobilierDao transactionImmobilierDao;
    @Autowired
    OperatonImmobilierDao operatonImmobilierDao;
    @Autowired
    BienImmobilierDao bienImmobilierDao;

    public TransactionImmobilier findByTitreFoncierBienImmobilier(String titreFoncierBienImmobilier) {
        return transactionImmobilierDao.findByTitreFoncierBienImmobilier(titreFoncierBienImmobilier);
    }

    @Transactional
    public int deleteByTitreFoncierBienImmobilier(String titreFoncierBienImmobilier) {
        return transactionImmobilierDao.deleteByTitreFoncierBienImmobilier(titreFoncierBienImmobilier);
    }

    public List<TransactionImmobilier> findByReferenceNouveauProprietaire(String referenceNouveauProprietaire) {
        return transactionImmobilierDao.findByReferenceNouveauProprietaire(referenceNouveauProprietaire);
    }

    public List<TransactionImmobilier> findByReferenceAncienProprietaire(String referenceAncienProprietaire) {
        return transactionImmobilierDao.findByReferenceAncienProprietaire(referenceAncienProprietaire);
    }

    public int save(TransactionImmobilier transactionImmobilier) {
        if (bienImmobilierDao.findByTitreFoncier(transactionImmobilier.getTitreFoncierBienImmobilier()) == null) {
            return -1;
        }
        if (operatonImmobilierDao.findByTitreFoncierBienImmobilier(transactionImmobilier.getTitreFoncierBienImmobilier()) != null) {
            return -2;
        } else {
            transactionImmobilierDao.save(transactionImmobilier);
            return 1;
        }
    }

    public List<TransactionImmobilier> findAll() {
        return transactionImmobilierDao.findAll();
    }
}
