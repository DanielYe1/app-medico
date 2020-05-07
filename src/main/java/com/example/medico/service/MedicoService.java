package com.example.medico.service;

import com.example.medico.messaging.MedicoSender;
import com.example.medico.model.Medico;
import com.example.medico.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    MedicoSender medicoSender;

    public Medico add(Medico medico){
        Medico inserted = medicoRepository.insert(medico);
        medicoSender.send(inserted.toString());
        return inserted;
    }

    public boolean delete(String id) {
        boolean exists = medicoRepository.existsById(id);
        if (exists) {
            medicoSender.send("delete" + id);
            medicoRepository.deleteById(id);
        }
        return exists;
    }

    public boolean update(String id, Medico medico) {
        boolean exists = medicoRepository.existsById(id);
        if (exists) {
            medico.setId(id);
            medicoRepository.save(medico);
            medicoSender.send(medico);
        }
        return exists;
    }

    public Optional<Medico> findById(String id) {
        return medicoRepository.findById(id);
    }

    public List<Medico> findAll(){
        return medicoRepository.findAll();
    }

}
