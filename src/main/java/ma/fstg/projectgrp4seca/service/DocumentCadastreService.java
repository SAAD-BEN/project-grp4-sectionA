package ma.fstg.projectgrp4seca.service;

import ma.fstg.projectgrp4seca.bean.BienImmobilier;
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

    public List<DocumentCadastre> findByBienImmobilierTitreFoncier(String titreImmobilier) {
        return documentCadastreDao.findByBienImmobilierTitreFoncier(titreImmobilier);
    }

    public List<DocumentCadastre> findAllByDemandeur(String demandeur) {
        return documentCadastreDao.findAllByDemandeur(demandeur);
    }

    public List<DocumentCadastre> findAll() {
        return documentCadastreDao.findAll();
    }

    public int save(DocumentCadastre documentCadastre) {
        BienImmobilier b = bienImmobilierDao.findByTitreFoncier(documentCadastre.getBienImmobilier().getTitreFoncier());
        documentCadastre.setBienImmobilier(b);
        if (b == null) {
            return -1;
        } else {
            documentCadastreDao.save(documentCadastre);
            return 1;
        }
    }

    @Transactional
    public int deleteByBienImmobilierTitreFoncierAndDateDocumentAndTypeDocument(String titreImmobilier, String dateDocument, String typeDocuent) {
        return documentCadastreDao.deleteByBienImmobilierTitreFoncierAndDateDocumentAndTypeDocument(titreImmobilier, dateDocument, typeDocuent);
    }
}
