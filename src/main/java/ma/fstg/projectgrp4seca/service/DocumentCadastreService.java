package ma.fstg.projectgrp4seca.service;

import ma.fstg.projectgrp4seca.dao.BienImmobilierDao;
import ma.fstg.projectgrp4seca.bean.DocumentCadastre;
import ma.fstg.projectgrp4seca.dao.DocumentCadastreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocumentCadastreService {
    @Autowired
    private DocumentCadastreDao documentCadastreDao;
    @Autowired
    private BienImmobilierDao bienImmobilierDao;

    public List<DocumentCadastre> findByTitreImmobilier(String titreImmobilier) {
        return documentCadastreDao.findByTitreImmobilier(titreImmobilier);
    }

    public List<DocumentCadastre> findAllByDemandeur(String demandeur) {
        return documentCadastreDao.findAllByDemandeur(demandeur);
    }

    public List<DocumentCadastre> findAll() {
        return documentCadastreDao.findAll();
    }

    public int save(DocumentCadastre documentCadastre) {
        if (bienImmobilierDao.findByTitreFoncier(documentCadastre.getTitreImmobilier()) == null) {
            return -1;
        } else {
            documentCadastreDao.save(documentCadastre);
            return 1;
        }
    }

    @Transactional
    public int deleteByTitreImmobilierAndDateDocumentAndTypeDocument(String titreImmobilier, String dateDocument,String typeDocuent) {
        return documentCadastreDao.deleteByTitreImmobilierAndDateDocumentAndTypeDocument(titreImmobilier, dateDocument,typeDocuent);
    }
}
