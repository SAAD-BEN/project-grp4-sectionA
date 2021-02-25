package ma.fstg.projectgrp4seca.service;

import ma.fstg.projectgrp4seca.bean.OperationImmobilier;
import ma.fstg.projectgrp4seca.dao.BienImmobilierDao;
import ma.fstg.projectgrp4seca.dao.OperatonImmobilierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OperationImmobilierService {
    @Autowired
    private OperatonImmobilierDao operationImobilierDao;
    @Autowired
    private BienImmobilierDao bienImmobilierDao;

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
        } else if (bienImmobilierDao.findByTitreFoncier(operationImmobilier.getTitreFoncierBienImmobilier()) == null) {
            return -2;
        } else {
            operationImobilierDao.save(operationImmobilier);
            return 1;
        }
    }
}
