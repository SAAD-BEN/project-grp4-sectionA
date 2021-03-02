package ma.fstg.projectgrp4seca.dao;

import ma.fstg.projectgrp4seca.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {
    Client findByRef(String ref);

    int deleteByRef(String ref);

    List<Client> findByNom(String nom);
}
