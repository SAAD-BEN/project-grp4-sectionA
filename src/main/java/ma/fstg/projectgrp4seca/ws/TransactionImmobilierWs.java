package ma.fstg.projectgrp4seca.ws;


import java.util.List;

import ma.fstg.projectgrp4seca.bean.TransactionImmobilier;
import ma.fstg.projectgrp4seca.service.TransactionImmobilierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("gestion-cadastre-foncier/transacion-immobilier")
public class TransactionImmobilierWs {

    @Autowired
    TransactionImmobilierService transactionImmobilierService;

    @GetMapping("/titreFoncierBienImmobilier/{titreFoncierBienImmobilier}")
    public TransactionImmobilier findByTitreFoncierBienImmobilier(@PathVariable String titreFoncierBienImmobilier) {
        return transactionImmobilierService.findByTitreFoncierBienImmobilier(titreFoncierBienImmobilier);
    }

    @DeleteMapping("/titreFoncierBienImmobilier/{titreFoncierBienImmobilier}")
    public int deleteByTitreFoncierBienImmobilier(@PathVariable String titreFoncierBienImmobilier) {
        return transactionImmobilierService.deleteByTitreFoncierBienImmobilier(titreFoncierBienImmobilier);
    }

    @GetMapping("/referenceNouveauProprietaire/{referenceNouveauProprietaire}")
    public List<TransactionImmobilier> findByReferenceNouveauProprietaire(@PathVariable String referenceNouveauProprietaire) {
        return transactionImmobilierService.findByReferenceNouveauProprietaire(referenceNouveauProprietaire);
    }

    @GetMapping("/referenceAncienProprietaire/{referenceAncienProprietaire}")
    public List<TransactionImmobilier> findByReferenceAncienProprietaire(@PathVariable String referenceAncienProprietaire) {
        return transactionImmobilierService.findByReferenceAncienProprietaire(referenceAncienProprietaire);
    }

    @PostMapping("/")
    public int save(@RequestBody TransactionImmobilier transactionImmobilier) {
        return transactionImmobilierService.save(transactionImmobilier);
    }

    @GetMapping("/")
    public List<TransactionImmobilier> findAll() {
        return transactionImmobilierService.findAll();
    }
}

