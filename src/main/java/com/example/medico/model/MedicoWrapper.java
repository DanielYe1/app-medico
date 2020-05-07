package com.example.medico.model;

import java.io.Serializable;

public class MedicoWrapper implements Serializable {
    private String status;
    private Medico medico;

    public MedicoWrapper(String status, Medico medico) {
        this.status = status;
        this.medico = medico;
    }

    public String getStatus() {
        return status;
    }

    public Medico getMedico() {
        return medico;
    }
}
