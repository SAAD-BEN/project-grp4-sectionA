package ma.fstg.projectgrp4seca.ws;


import ma.fstg.projectgrp4seca.bean.TransactionImmobilier;
import ma.fstg.projectgrp4seca.service.TransactionImmobilierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("gestion-cadastre-foncier/transacion-immobilier")
public class TransactionImmobilierWs {

    @Autowired
    TransactionImmobilierService transactionImmobilierService;

    @GetMapping("/bienimmobilier/titrefoncier/{titreFoncier}/")
    public List<TransactionImmobilier> findByBienImmobilierTitreFoncier(@PathVariable String titreFoncier) {
        return transactionImmobilierService.findByBienImmobilierTitreFoncier(titreFoncier);
    }

    @DeleteMapping("/bienimmobilier/titrefoncier/{titreFoncier}/")
    public int deleteByBienImmobilierTitreFoncier(@PathVariable String titreFoncier) {
        return transactionImmobilierService.deleteByBienImmobilierTitreFoncier(titreFoncier);
    }

    @GetMapping("/")
    public List<TransactionImmobilier> findAll() {
        return transactionImmobilierService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody TransactionImmobilier transactionImmobilier) {
        return transactionImmobilierService.save(transactionImmobilier);
    }
}

