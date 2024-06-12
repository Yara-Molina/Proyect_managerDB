package org.example.gestor_proyecto.models;

import java.time.LocalDate;

public class ProyectoMobile extends TipoProyecto{
private String plataforma;
private String conectividad;

    public ProyectoMobile(String plataforma,String conectividad) {
        super();
        this.plataforma = plataforma;
        this.conectividad = conectividad;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getConectividad() {
        return conectividad;
    }

    public void setConectividad(String conectividad) {
        this.conectividad = conectividad;
    }

    @Override
    public String toString() {
        return "ProyectoMobile{" +
                "plataforma='" + plataforma + '\'' +
                ", conectividad='" + conectividad + '\'' +
                ", nombreProject='" + nombreProject + '\'' +
                ", starDate=" + starDate +
                ", endDate=" + endDate +
                ", descripcionProyect='" + descripcionProyect + '\'' +
                '}';
    }
}
