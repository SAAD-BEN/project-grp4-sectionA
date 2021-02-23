package ma.fstg.projectgrp4seca.ws;

import ma.fstg.projectgrp4seca.bean.DocumentCadastre;
import ma.fstg.projectgrp4seca.service.DocumentCadastreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion-cadastre-foncier/documentcadastre")
public class DocumentCadastreProvided {
    @Autowired
    DocumentCadastreService documentCadastreService;

    @GetMapping("/titreImmobilier/{titreImmobilier}")
    public List<DocumentCadastre> findByTitreImmobilier(@PathVariable String titreImmobilier) {
        return documentCadastreService.findByTitreImmobilier(titreImmobilier);
    }

    @GetMapping("/demandeur/{demandeur}")
    public List<DocumentCadastre> findAllByDemandeur(@PathVariable String demandeur) {
        return documentCadastreService.findAllByDemandeur(demandeur);
    }

    @GetMapping("/")
    public List<DocumentCadastre> findAll() {
        return documentCadastreService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody DocumentCadastre documentCadastre) {
        return documentCadastreService.save(documentCadastre);
    }

    @Transactional
    @DeleteMapping("/titreImmobilier/{titreImmobilier}/dateDocument/{dateDocument}/typeDocuent/{typeDocuent}")
    public int deleteByTitreImmobilierAndDateDocumentAndTypeDocument(String titreImmobilier, String dateDocument, String typeDocuent) {
        return documentCadastreService.deleteByTitreImmobilierAndDateDocumentAndTypeDocument(titreImmobilier, dateDocument, typeDocuent);
    }
}
