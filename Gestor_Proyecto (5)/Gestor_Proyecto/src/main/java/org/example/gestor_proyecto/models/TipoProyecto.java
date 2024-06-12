package org.example.gestor_proyecto.models;

import java.time.LocalDate;

public class TipoProyecto {
    protected String nombreProject;
    protected LocalDate starDate;
    protected LocalDate endDate;
    protected String descripcionProyect;


    public TipoProyecto(String nombreProject,LocalDate starDate, LocalDate endDate,String descripcionProyect) {
        this.nombreProject = nombreProject;
        this.starDate = starDate;
        this.endDate = endDate;
        this.descripcionProyect = descripcionProyect;
    }

    public TipoProyecto() {

    }

    public String getNombreProject() {
        return nombreProject;
    }

    public void setNombreProject(String nombreProject) {
        this.nombreProject = nombreProject;
    }

    public LocalDate getStarDate() {
        return starDate;
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescripcionProyect() {
        return descripcionProyect;
    }

    public void setDescripcionProyect(String descripcionProyect) {
        this.descripcionProyect = descripcionProyect;
    }

    @Override
    public String toString() {
        return "TipoProyecto{" +
                "nombreProject='" + nombreProject + '\'' +
                ", starDate=" + starDate +
                ", endDate=" + endDate +
                ", descripcionProyect='" + descripcionProyect + '\'' +
                '}';
    }
}

