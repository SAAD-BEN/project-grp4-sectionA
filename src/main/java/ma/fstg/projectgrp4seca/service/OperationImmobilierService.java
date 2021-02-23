package ma.fstg.projectgrp4seca.service;

import ma.fstg.projectgrp4seca.bean.OperationImmobilier;
import ma.fstg.projectgrp4seca.dao.OperatonImmobilierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OperationImmobilierService {
    public OperationImmobilier findByTitreFoncierBienImmobilier(String titreFoncierBienImmobilier) {
        return operationImobilierDao.findByTitreFoncierBienImmobilier(titreFoncierBienImmobilier);
    }

    public OperationImmobilier findByTypeOperation(String typeOperation) {
        return operationImobilierDao.findByTypeOperation(typeOperation);
    }

    @Transactional
    public int deleteByTitreFoncierBienImmobilier(String titreFoncierBienImmobilier) {
        return operationImobilierDao.deleteByTitreFoncierBienImmobilier(titreFoncierBienImmobilier);
    }

    public List<OperationImmobilier> findAll() {
        return operationImobilierDao.findAll();
    }

    public int save(OperationImmobilier operationImmobilier) {
        OperationImmobilier op = findByTitreFoncierBienImmobilier(operationImmobilier.getTitreFoncierBienImmobilier());
        if (op != null) {
            return -1;
        } else {
            operationImobilierDao.save(operationImmobilier);
            return 1;
        }
    }

    @Autowired
    private OperatonImmobilierDao operationImobilierDao;
}
