package ma.fstg.projectgrp4seca.service;

import ma.fstg.projectgrp4seca.bean.TypeOperation;
import ma.fstg.projectgrp4seca.dao.TypeOperationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeOperationService {
    @Autowired
    private TypeOperationDao typeOperationDao;

    public TypeOperation findByLibelle(String libelle) {
        return typeOperationDao.findByLibelle(libelle);
    }
    @Transactional
    public int deleteByLibelle(String libelle) {
        return typeOperationDao.deleteByLibelle(libelle);
    }

    public List<TypeOperation> findAll() {
        return typeOperationDao.findAll();
    }

    public int save(TypeOperation typeOperation) {
        if (typeOperationDao.findByLibelle(typeOperation.getLibelle()) != null) {
            return -1;
        } else {
            typeOperationDao.save(typeOperation);
            return 1;
        }
    }
}

