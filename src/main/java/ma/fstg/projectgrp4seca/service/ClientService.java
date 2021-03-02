package ma.fstg.projectgrp4seca.service;

import ma.fstg.projectgrp4seca.bean.Client;
import ma.fstg.projectgrp4seca.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientDao clientDao;

    public Client findByRef(String ref) {
        return clientDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return clientDao.deleteByRef(ref);
    }

    public List<Client> findByNom(String nom) {
        return clientDao.findByNom(nom);
    }

    public List<Client> findAll() {
        return clientDao.findAll();
    }

    public int save(Client client) {
        if (findByRef(client.getRef()) != null) {
            return -1;
        }
        clientDao.save(client);
        return 1;
    }
}
