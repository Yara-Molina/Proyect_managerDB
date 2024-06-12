package org.example.gestor_proyecto.models;

import java.util.ArrayList;

public class Usuario {
    private String usuario;
    private String contraseña;
    private static ArrayList<Usuario> usuarios ;
    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.usuarios = new ArrayList<>();
    }

    public Usuario() {

    }
    public static Usuario buscarUsuarioPorCredenciales(String nombreUsuario, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                return usuario; // Usuario encontrado
            }
        }
        return null; // Usuario no encontrado
    }

    public static void agregarUsuario(String nuevoUsuario, String nuevaContraseña) {
        Usuario uss = new Usuario(nuevoUsuario,nuevaContraseña);
        usuarios.add(uss);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
