package fr.simplon.givemeacar.services;

import fr.simplon.givemeacar.Agence;
import fr.simplon.givemeacar.dao.AgenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceServiceImpl implements AgenceService {

    @Autowired
    private AgenceDao dao;


    public List<Agence> getAllAgence() throws Exception {
        return dao.getAllAgences();
    }
}
