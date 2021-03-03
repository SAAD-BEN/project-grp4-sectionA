package ma.fstg.projectgrp4seca.ws;

import ma.fstg.projectgrp4seca.bean.BienImmobilier;
import ma.fstg.projectgrp4seca.bean.Cadastre;
import ma.fstg.projectgrp4seca.bean.Client;
import ma.fstg.projectgrp4seca.service.BienImmobilierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion-cadastre-foncier/bienimmobilier")
public class BienImmobilierProvided {
    @Autowired
    BienImmobilierService bienImmobilierService;

    @GetMapping("/titreFoncier/{titreFoncier}")
    public BienImmobilier findByTitreFoncier(@PathVariable String titreFoncier) {
        return bienImmobilierService.findByTitreFoncier(titreFoncier);
    }

    @DeleteMapping("/titreFoncier/{titreFoncier}")
    public int deleteByTitreFoncier(@PathVariable String titreFoncier) {
        return bienImmobilierService.deleteByTitreFoncier(titreFoncier);
    }

    @GetMapping("/localisation/{localistion}")
    public List<BienImmobilier> findByLocalisationLike(@PathVariable String localistion) {
        return bienImmobilierService.findByLocalisationLike(localistion);
    }

    @GetMapping("/minSurf/{minSurf}")
    public List<BienImmobilier> findBySurfaceGreaterThan(double minSurf) {
        return bienImmobilierService.findBySurfaceGreaterThan(minSurf);
    }

    @GetMapping("/")
    public List<BienImmobilier> findAll() {
        return bienImmobilierService.findAll();
    }

    @PutMapping("/modifierTitreFoncier/oldT/{oldT}/newTitre/{newT}")
    public int modifyProprietaire(@PathVariable String titreFoncier, @PathVariable Client newProp) {
        return bienImmobilierService.modifyProprietaire(titreFoncier, newProp);
    }

    @PostMapping("/")
    public int save(@RequestBody BienImmobilier bienImmobilier) {
        return bienImmobilierService.save(bienImmobilier);
    }

    @GetMapping("/Cadastre/ref/{ref}")
    public Cadastre findByCadastreRef(@PathVariable String ref) {
        return bienImmobilierService.findByCadastreRef(ref);
    }

    @GetMapping("/Proprietaire/ref/{ref}")
    public List<BienImmobilier> findByProprietaireRef(@PathVariable String ref) {
        return bienImmobilierService.findByProprietaireRef(ref);
    }
}
