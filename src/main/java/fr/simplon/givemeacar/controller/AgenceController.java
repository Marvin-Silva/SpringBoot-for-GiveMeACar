package fr.simplon.givemeacar.controller;

import fr.simplon.givemeacar.model.Agence;
import fr.simplon.givemeacar.services.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class AgenceController {

    @Autowired
    private AgenceService agenceService;

    @CrossOrigin (origins = "*")
    @RequestMapping (value="/agences", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAgences(){
        List<Agence> listAgence = null;
        try {
            listAgence = agenceService.getAllAgence();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(listAgence);
    }


}
