package org.example.gestor_proyecto.models;

import java.time.LocalDate;

public class ProyectoEscritorio extends TipoProyecto{
protected String sistemaOperativo;

    public ProyectoEscritorio(String sistemaOperativo) {
        super();
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public String toString() {
        return "ProyectoEscritorio{" +
                "sistemaOperativo='" + sistemaOperativo + '\'' +
                ", nombreProject='" + nombreProject + '\'' +
                ", starDate=" + starDate +
                ", endDate=" + endDate +
                ", descripcionProyect='" + descripcionProyect + '\'' +
                '}';
    }
}
