package ma.fstg.projectgrp4seca.service;


import java.util.List;


import ma.fstg.projectgrp4seca.bean.BienImmobilier;
import ma.fstg.projectgrp4seca.bean.Client;
import ma.fstg.projectgrp4seca.bean.TransactionImmobilier;
import ma.fstg.projectgrp4seca.dao.TransactionImmobilierDao;
import ma.fstg.projectgrp4seca.vo.TransactionImmobilierVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;


@Service
public class TransactionImmobilierService {

    @Autowired
    TransactionImmobilierDao transactionImmobilierDao;
    @Autowired
    BienImmobilierService bienImmobilierService;
    @Autowired
    OperationImmobilierService operationImmobilierService;
    @Autowired
    ClientService clientService;
    @Autowired
    EntityManager entityManager;

    public List<TransactionImmobilier> findByBienImmobilierTitreFoncier(String titreFoncier) {
        return transactionImmobilierDao.findByBienImmobilierTitreFoncier(titreFoncier);
    }

    public int deleteByBienImmobilierTitreFoncier(String titreFoncier) {
        return transactionImmobilierDao.deleteByBienImmobilierTitreFoncier(titreFoncier);
    }

    public List<TransactionImmobilier> findAll() {
        return transactionImmobilierDao.findAll();
    }

    public int save(TransactionImmobilier transactionImmobilier) {
        BienImmobilier b = bienImmobilierService.findByTitreFoncier(transactionImmobilier.getBienImmobilier().getTitreFoncier());
        if (b == null) {
            return -1;
        } else if (operationImmobilierService.findByBienImmobilierTitreFoncier(transactionImmobilier.getBienImmobilier().getTitreFoncier()) != null) {
            return -2;
        }else if (b.getProprietaire().getRef().equals(transactionImmobilier.getNouveauProprietaire().getRef())){
            return -3;
        } else {
            bienImmobilierService.modifyProprietaire(transactionImmobilier.getBienImmobilier().getTitreFoncier(), transactionImmobilier.getNouveauProprietaire());
            Client c = clientService.findByRef(transactionImmobilier.getNouveauProprietaire().getRef());
            transactionImmobilier.setBienImmobilier(b);
            transactionImmobilier.setNouveauProprietaire(c);
            transactionImmobilierDao.save(transactionImmobilier);
            return 1;
        }
    }
    public List<TransactionImmobilier> findByCriteria(TransactionImmobilierVo transactionImmobilierVo){
        String query = ("select t from TransactionImmobilier t where 1=1");
        if (transactionImmobilierVo.getMaxMontant()!=null) query+=(" and t.montant>='" + transactionImmobilierVo.getMaxMontant()+"'");
        if (transactionImmobilierVo.getMinMontant()!=null) query+=(" and t.montant<='" + transactionImmobilierVo.getMinMontant()+"'");
        return entityManager.createQuery(query).getResultList();
    }
}
