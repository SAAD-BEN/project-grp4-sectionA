package ma.fstg.projectgrp4seca.service;


import java.util.List;

import ma.fstg.projectgrp4seca.bean.BienImmobilier;
import ma.fstg.projectgrp4seca.bean.TransactionImmobilier;
import ma.fstg.projectgrp4seca.dao.TransactionImmobilierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TransactionImmobilierService {

    @Autowired
    TransactionImmobilierDao transactionImmobilierDao;
    @Autowired
    BienImmobilierService bienImmobilierService;
    @Autowired
    OperationImmobilierService operationImmobilierService;

    public BienImmobilier findByBienImmobilierTitreFoncier(String titreFoncier) {
        return transactionImmobilierDao.findByBienImmobilierTitreFoncier(titreFoncier);
    }

    @Transactional
    public int deleteByBienImmobilierTitreFoncier(String titreFoncierBienImmobilier) {
        return transactionImmobilierDao.deleteByBienImmobilierTitreFoncier(titreFoncierBienImmobilier);
    }

    public List<TransactionImmobilier> findByReferenceNouveauProprietaire(String referenceNouveauProprietaire) {
        return transactionImmobilierDao.findByReferenceNouveauProprietaire(referenceNouveauProprietaire);
    }

    public List<TransactionImmobilier> findByReferenceAncienProprietaire(String referenceAncienProprietaire) {
        return transactionImmobilierDao.findByReferenceAncienProprietaire(referenceAncienProprietaire);
    }

    public int save(TransactionImmobilier transactionImmobilier) {
        if (bienImmobilierService.findByTitreFoncier(transactionImmobilier.getBienImmobilier().getTitreFoncier()) == null) {
            return -1;
        } else if (operationImmobilierService.findByTitreFoncierBienImmobilier(transactionImmobilier.getBienImmobilier().getTitreFoncier()) != null) {
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
