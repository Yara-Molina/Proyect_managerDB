package org.example.gestor_proyecto.models;

import java.time.LocalDate;

public class ProyectoPaginaWeb extends TipoProyecto{
private String framework;
private String tipoPagina;

    public ProyectoPaginaWeb(String framework, String tipoPagina) {
        super();
        this.framework = framework;
        this.tipoPagina = tipoPagina;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public String getTipoPagina() {
        return tipoPagina;
    }

    public void setTipoPagina(String tipoPagina) {
        tipoPagina = tipoPagina;
    }

    @Override
    public String toString() {
        return "ProyectoPaginaWeb{" +
                "framework='" + framework + '\'' +
                ", tipoPagina='" + tipoPagina + '\'' +
                ", nombreProject='" + nombreProject + '\'' +
                ", starDate=" + starDate +
                ", endDate=" + endDate +
                ", descripcionProyect='" + descripcionProyect + '\'' +
                '}';
    }
}
