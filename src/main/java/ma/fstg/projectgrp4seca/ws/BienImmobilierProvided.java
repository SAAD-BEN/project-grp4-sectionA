package ma.fstg.projectgrp4seca.ws;

import ma.fstg.projectgrp4seca.bean.BienImmobilier;
import ma.fstg.projectgrp4seca.bean.Client;
import ma.fstg.projectgrp4seca.service.BienImmobilierService;
import ma.fstg.projectgrp4seca.vo.BienImmobilierVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion-cadastre-foncier/bienimmobilier")
public class BienImmobilierProvided {
    @Autowired
    BienImmobilierService bienImmobilierService;
    @PostMapping("/critere")
    public List<BienImmobilierVo> findBycritere(@RequestBody BienImmobilierVo bienImmobilierVo) {
        return bienImmobilierService.findByCritere(bienImmobilierVo);
    }

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

    @PutMapping("/modifierTitreFoncier/oldT/{titreFoncier}/newTitre/{newProp}")
    public int modifyProprietaire(@PathVariable String titreFoncier, @PathVariable Client newProp) {
        return bienImmobilierService.modifyProprietaire(titreFoncier, newProp);
    }

    @PostMapping("/")
    public int save(@RequestBody BienImmobilier bienImmobilier) {
        return bienImmobilierService.save(bienImmobilier);
    }

    @GetMapping("/Proprietaire/ref/{ref}")
    public List<BienImmobilier> findByProprietaireRef(@PathVariable String ref) {
        return bienImmobilierService.findByProprietaireRef(ref);
    }
}
