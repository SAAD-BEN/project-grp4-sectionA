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
    public List<DocumentCadastre> findByBienImmobilierTitreFoncier(@PathVariable String titreImmobilier) {
        return documentCadastreService.findByBienImmobilierTitreFoncier(titreImmobilier);
    }

    @GetMapping("/ref/{ref}")
    public List<DocumentCadastre> findByDemandeurRef(@PathVariable String ref) {
        return documentCadastreService.findByDemandeurRef(ref);
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
    public int deleteByBienImmobilierTitreFoncierAndDateDocumentAndTypeDocument(String titreImmobilier, String dateDocument, String typeDocuent) {
        return documentCadastreService.deleteByBienImmobilierTitreFoncierAndDateDocumentAndTypeDocument(titreImmobilier, dateDocument, typeDocuent);
    }
}
