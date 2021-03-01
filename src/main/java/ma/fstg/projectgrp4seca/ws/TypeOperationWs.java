package ma.fstg.projectgrp4seca.ws;

import ma.fstg.projectgrp4seca.dao.TypeOperationDao;
import ma.fstg.projectgrp4seca.service.TypeOperationService;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("gestion-cadastre-foncier/TypeOperation")

public class TypeOperationWs {

    @GetMapping("/code/{code}")
    public TypeOperationDao finfByCode(@PathVariable String code) {
        return typeOperationService.finfByCode(code);
    }

    @GetMapping("/libelle/{libelle}")
    public TypeOperationDao findByLibelle(@PathVariable String libelle) {
        return typeOperationService.findByLibelle(libelle);
    }

    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByCode(String code) {
        return typeOperationService.deleteByCode(code);
    }

    @Transactional
    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(String libelle) {
        return typeOperationService.deleteByLibelle(libelle);
    }
    @GetMapping("/")
    public List<TypeOperationDao> findAll() {
        return typeOperationService.findAll();
    }

    private TypeOperationService typeOperationService ;

}
