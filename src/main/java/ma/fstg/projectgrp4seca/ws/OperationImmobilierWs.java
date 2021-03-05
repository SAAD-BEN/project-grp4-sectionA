package ma.fstg.projectgrp4seca.ws;

import ma.fstg.projectgrp4seca.bean.OperationImmobilier;
import ma.fstg.projectgrp4seca.service.OperationImmobilierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("gestion-cadastre-foncier/OperationImmobile")
public class OperationImmobilierWs {
    @GetMapping("/titrefoncier/{titreFoncier}")
    public OperationImmobilier findByBienImmobilierTitreFoncier(@PathVariable String titreFoncier) {
        return operationImmobilierService.findByBienImmobilierTitreFoncier(titreFoncier);
    }
    @GetMapping("/typeoperation/libelle/{libelle}")
    public OperationImmobilier findByTypeOperationLibelle(@PathVariable String libelle) {
        return operationImmobilierService.findByTypeOperationLibelle(libelle);
    }

    @Transactional
    @DeleteMapping("/titreFoncierBienImmobilier/{titreFoncier}")
    public int deleteByBienImmobilierTitreFoncier(@PathVariable String titreFoncier) {
        return operationImmobilierService.deleteByBienImmobilierTitreFoncier(titreFoncier);
    }

    @GetMapping("/")
    public List<OperationImmobilier> findAll() {
        return operationImmobilierService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody OperationImmobilier operationImmobilier) {
        return operationImmobilierService.save(operationImmobilier);
    }

    @Autowired
    private OperationImmobilierService operationImmobilierService;

}
