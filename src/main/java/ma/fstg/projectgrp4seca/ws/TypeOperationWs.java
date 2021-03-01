package ma.fstg.projectgrp4seca.ws;

import ma.fstg.projectgrp4seca.bean.TypeOperation;
import ma.fstg.projectgrp4seca.service.TypeOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("gestion-cadastre-foncier/TypeOperation")

public class TypeOperationWs {
    @Autowired
    private TypeOperationService typeOperationService;

    @GetMapping("/libelle/{libelle}")
    public TypeOperation findByLibelle(@PathVariable String libelle) {
        return typeOperationService.findByLibelle(libelle);
    }

    @Transactional
    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(String libelle) {
        return typeOperationService.deleteByLibelle(libelle);
    }

    @GetMapping("/")
    public List<TypeOperation> findAll() {
        return typeOperationService.findAll();
    }

    @PutMapping("/")
    public int save(@RequestBody TypeOperation typeOperation) {
        return typeOperationService.save(typeOperation);
    }
}
