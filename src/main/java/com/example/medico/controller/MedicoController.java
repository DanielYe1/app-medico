package com.example.medico.controller;

import com.example.medico.model.Medico;
import com.example.medico.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    MedicoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listAll(){
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseEntity saveMedico(@Valid Medico medico) {
        Medico added = service.add(medico);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity searchMedico(@PathVariable("id") String medicoId) {
        Optional<Medico> medico = service.findById(medicoId);
        if (medico.isPresent()) {
            return new ResponseEntity<Medico>(medico.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Medico>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateMedico(@PathVariable("id") String id, @RequestBody Medico medico) {
        if (service.update(id, medico)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteMedico(@PathVariable("id") String medicoId) {
        if (service.delete(medicoId)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
