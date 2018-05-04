package com.biblioteca.model;

public class Usuario extends Libro {
    private int cod_usuario;
    private String nombreUsuario;
    private String apellido;
    private String f_nacimiento;
    private String direccion;
    private String telefono;
    private String email;

    Usuario() {
    }

    public Usuario(int cod_usuario, String nombre,
                   String apellido, String f_nacimiento,
                   String direccion, String telefono, String email) {
        this.cod_usuario = cod_usuario;
        this.nombreUsuario = nombre;
        this.apellido = apellido;
        this.f_nacimiento = f_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(String f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
