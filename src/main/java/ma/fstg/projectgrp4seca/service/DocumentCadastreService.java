package ma.fstg.projectgrp4seca.service;

import ma.fstg.projectgrp4seca.bean.BienImmobilier;
import ma.fstg.projectgrp4seca.bean.Client;
import ma.fstg.projectgrp4seca.bean.DocumentCadastre;
import ma.fstg.projectgrp4seca.dao.DocumentCadastreDao;
import ma.fstg.projectgrp4seca.vo.DocumentCadastreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class DocumentCadastreService {
    @Autowired
    private DocumentCadastreDao documentCadastreDao;
    @Autowired
    private BienImmobilierService bienImmobilierService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private EntityManager entityManager;

    public List<DocumentCadastre> findByCriteria(DocumentCadastreVo documentCadastreVo){
        String query = ("select doc from DocumentCadastre doc where 1=1");
        if (documentCadastreVo.getTypeDocument()!=null) query+=(" and doc.typeDocument='" + documentCadastreVo.getTypeDocument()+"'");
        if (documentCadastreVo.getMaxMontant()!=null) query+=(" and doc.montant>=" + documentCadastreVo.getMaxMontant());
        if (documentCadastreVo.getMinMontant()!=null) query+=(" and doc.montant<=" + documentCadastreVo.getMinMontant());
        if (documentCadastreVo.getDateDocument()!=null) query+=(" and doc.dateDocument =" + documentCadastreVo.getDateDocument());
        return entityManager.createQuery(query).getResultList();
    }

    public List<DocumentCadastre> findByBienImmobilierTitreFoncier(String titreImmobilier) {
        return documentCadastreDao.findByBienImmobilierTitreFoncier(titreImmobilier);
    }

    public List<DocumentCadastre> findByDemandeurRef(String ref) {
        return documentCadastreDao.findByDemandeurRef(ref);
    }

    public List<DocumentCadastre> findAll() {
        return documentCadastreDao.findAll();
    }

    public int save(DocumentCadastre documentCadastre) {
        BienImmobilier b = bienImmobilierService.findByTitreFoncier(documentCadastre.getBienImmobilier().getTitreFoncier());
        Client c = clientService.findByRef(documentCadastre.getDemandeur().getRef());
        if (b == null) {
            return -1;
        } else if (c==null){
            return -2;
        } else if (!c.getRef().equals(b.getProprietaire().getRef())) {
            return -2;
        }
        else {
            documentCadastre.setBienImmobilier(b);
            documentCadastre.setDemandeur(c);
            documentCadastreDao.save(documentCadastre);
            return 1;
        }
    }

    @Transactional
    public int deleteByBienImmobilierTitreFoncierAndDateDocumentAndTypeDocument(String titreImmobilier, String dateDocument, String typeDocuent) {
        return documentCadastreDao.deleteByBienImmobilierTitreFoncierAndDateDocumentAndTypeDocument(titreImmobilier, dateDocument, typeDocuent);
    }
}
