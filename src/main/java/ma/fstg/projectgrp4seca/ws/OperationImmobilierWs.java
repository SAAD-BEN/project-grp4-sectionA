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
    public OperationImmobilier findbyTitreFoncierBienImmobilier(String titreFoncierBienImmobilier) {
        return operationImmobilierService.findByTitreFoncierBienImmobilier(titreFoncierBienImmobilier);
    }

    @GetMapping("/typeOperation/{typeOperation}")
    public OperationImmobilier findbyTypeOperation(@PathVariable String typeOperation) {
        return operationImmobilierService.findByTypeOperation(typeOperation);
    }

    @Transactional
    @DeleteMapping("/titreFoncierBienImmobilier/{titreFoncierBienImmobilier}")
    public int deleteByTitreFoncierBienImmobilier(@PathVariable String titreFoncierBienImmobilier) {
        return operationImmobilierService.deleteByTitreFoncierBienImmobilier(titreFoncierBienImmobilier);
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
