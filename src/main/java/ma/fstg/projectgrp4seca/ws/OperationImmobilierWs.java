package ma.fstg.projectgrp4seca.ws;

import ma.fstg.projectgrp4seca.bean.OperationImmobilier;
import ma.fstg.projectgrp4seca.service.OperationImmobilierService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequetMapping("gestion-cadastre-foncier/OperationImmobile")
public class OperationImmobilierWs {
    public OperationImmobilier findbyTitreFoncierBienImmobilier(String titreFoncierBienImmobilier) {
        return operationImmobilierService.findbyTitreFoncierBienImmobilier(titreFoncierBienImmobilier);
    }
    @GetMapping("/typeOperation/{typeOperation}")
    public OperationImmobilier findbyTypeOperation( @PathVariable String typeOperation) {
        return operationImmobilierService.findbyTypeOperation(typeOperation);
    }

    @Transactional
    public OperationImmobilier DeletebyTypeOperation(String typeOperation) {
        return operationImmobilierService.DeletebyTypeOperation(typeOperation);
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
    private OperationImmobilierService operationImmobilierService ;

}
