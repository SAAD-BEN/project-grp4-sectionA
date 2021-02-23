package ma.fstg.projectgrp4seca.service;

import ma.fstg.projectgrp4seca.bean.Cadastre;
import ma.fstg.projectgrp4seca.dao.CadastreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class CadastreService {
    @Autowired
    private CadastreDao cadastreDao;

    public Cadastre findByRef(String ref) {
        return cadastreDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return cadastreDao.deleteByRef(ref);
    }

    public List<Cadastre> findByDescriptionLike(String description) {
        return cadastreDao.findByDescriptionLike(description);
    }

    public List<Cadastre> findAll() {
        return cadastreDao.findAll();
    }

    public int save(Cadastre cadastre) {
        if (findByRef(cadastre.getRef()) != null) {
            return -1;
        } else {
            cadastreDao.save(cadastre);
            return 1;
        }
    }

    public int modifyDescription(String ref, String description) {
        Cadastre cadastre = findByRef(ref);
        if (cadastre == null) {
            return -1;
        } else {
            cadastre.setDescription(description);
            cadastreDao.save(cadastre);
            return 1;
        }
    }

}