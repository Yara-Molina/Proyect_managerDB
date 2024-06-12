package org.example.gestor_proyecto.models;

import java.time.LocalDate;

public class Tarea {
    private String nameTarea;
    private LocalDate startDate1;
    private LocalDate endDate1;
    private String description;
    private String whoMakes;

    public Tarea(String nameTarea, LocalDate startDate1, LocalDate endDate1, String description, String whoMakes) {
        this.nameTarea = nameTarea;
        this.startDate1 = startDate1;
        this.endDate1 = endDate1;
        this.description = description;
        this.whoMakes = whoMakes;
    }


    public String getNameTarea() {
        return nameTarea;
    }

    public void setNameTarea(String nameTarea) {
        this.nameTarea = nameTarea;
    }

    public LocalDate getStartDate1() {
        return startDate1;
    }

    public void setStartDate1(LocalDate startDate1) {
        this.startDate1 = startDate1;
    }

    public LocalDate getEndDate1() {
        return endDate1;
    }

    public void setEndDate1(LocalDate endDate1) {
        this.endDate1 = endDate1;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getWhoMakes() {
        return whoMakes;
    }

    public void setWhoMakes(String whoMakes) {
        this.whoMakes = whoMakes;
    }
}
