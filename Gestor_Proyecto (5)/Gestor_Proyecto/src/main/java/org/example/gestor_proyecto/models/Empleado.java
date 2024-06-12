package org.example.gestor_proyecto.models;

import java.util.ArrayList;
import java.util.Objects;

public class Empleado {

    private String nombreEmpleado;
   private int ID;
   private String workArea;

   private String apellidoEmpleado;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public Empleado(String nombreEmpleado, String workArea, int ID, String apellidoEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
        this.ID = ID;
        this.workArea = workArea;
        this.apellidoEmpleado = apellidoEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombreEmpleado='" + nombreEmpleado + '\'' +
                ", ID=" + ID +
                ", workArea='" + workArea + '\'' +
                ", apellidoEmpleado='" + apellidoEmpleado + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return ID == empleado.ID && Objects.equals(nombreEmpleado, empleado.nombreEmpleado) && Objects.equals(workArea, empleado.workArea) && Objects.equals(apellidoEmpleado ,empleado.apellidoEmpleado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreEmpleado, ID, workArea, apellidoEmpleado);
    }
}
