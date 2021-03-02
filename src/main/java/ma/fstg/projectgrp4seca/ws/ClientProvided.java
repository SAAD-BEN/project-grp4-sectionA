package ma.fstg.projectgrp4seca.ws;

import ma.fstg.projectgrp4seca.bean.Client;
import ma.fstg.projectgrp4seca.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion-cadastre-foncier/client")
public class ClientProvided {
    @Autowired
    private ClientService clientService;

    @GetMapping("/ref/{ref}")
    public Client findByRef(@PathVariable String ref) {
        return clientService.findByRef(ref);
    }

    @Transactional
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return clientService.deleteByRef(ref);
    }

    @GetMapping("/nom/{nom}")
    public List<Client> findByNom(@PathVariable String nom) {
        return clientService.findByNom(nom);
    }

    @GetMapping("/")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Client client) {
        return clientService.save(client);
    }
}
