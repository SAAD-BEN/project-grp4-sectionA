package ma.fstg.projectgrp4seca.service;

import ma.fstg.projectgrp4seca.bean.OperationImmobilier;
import ma.fstg.projectgrp4seca.dao.OperatonImmobilierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OperationImmobilierService {
    public OperationImmobilier findbyTitreFoncierBienImmobilier(String titreFoncierBienImmobilier) {
        return operationImobilierDao.findbyTitreFoncierBienImmobilier(titreFoncierBienImmobilier);
    }


    public OperationImmobilier findbyTypeOperation(String typeOperation) {
        return operationImobilierDao.findbyTypeOperation(typeOperation);
    }
    @Transactional
    public OperationImmobilier DeletebyTypeOperation(String typeOperation) {
        return operationImobilierDao.DeletebyTypeOperation(typeOperation);
    }

    public List<OperationImmobilier> findAll() {
        return operationImobilierDao.findAll();
    }

    public <S extends OperationImmobilier> S save(S s) {
        return operationImobilierDao.save(s);
    }

    @Autowired
    private OperatonImmobilierDao operationImobilierDao ;

}
