package ma.fstg.projectgrp4seca.ws;


import ma.fstg.projectgrp4seca.bean.Cadastre;
import ma.fstg.projectgrp4seca.service.CadastreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("gestion-cadastre-foncier/cadastre")
public class CadastreProvided {
    @Autowired
    private CadastreService cadastreService;

    @GetMapping("/ref/{ref}")
    public Cadastre findByRef(@PathVariable String ref) {
        return cadastreService.findByRef(ref);
    }

    @Transactional
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return cadastreService.deleteByRef(ref);
    }

    @GetMapping("/description/{description}")
    public List<Cadastre> findByDescriptionLike(@PathVariable String description) {
        return cadastreService.findByDescriptionLike(description);
    }

    @GetMapping("/")
    public List<Cadastre> findAll() {
        return cadastreService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Cadastre cadastre) {
        return cadastreService.save(cadastre);
    }

    @PutMapping("/ref/{ref}/description/{description}")
    public int modifyDescription(@PathVariable String ref, @PathVariable String description) {
        return cadastreService.modifyDescription(ref, description);
    }
}
