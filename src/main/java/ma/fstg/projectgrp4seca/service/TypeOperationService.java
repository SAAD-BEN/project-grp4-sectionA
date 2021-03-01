package ma.fstg.projectgrp4seca.service;

import ma.fstg.projectgrp4seca.bean.TypeOperation;
import ma.fstg.projectgrp4seca.dao.TypeOperationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class TypeOperationService {


    public TypeOperationDao finfByCode(String code) {
        return typeOperationDao.finfByCode(code);
    }

    public TypeOperationDao findByLibelle(String libelle) {
        return typeOperationDao.findByLibelle(libelle);
    }
    @Transactional
    public int deleteByCode(String code) {
        return typeOperationDao.deleteByCode(code);
    }
    @Transactional
    public int deleteByLibelle(String libelle) {
        return typeOperationDao.deleteByLibelle(libelle);
    }

    public List<TypeOperationDao> findAll() {
        return typeOperationDao.findAll();
    }



    @Autowired
    private TypeOperationDao typeOperationDao ;

}

