package com.biblioteca.model;

public class Editorial {

    private  int cod_editorial;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;

    public Editorial() {
    }

    public Editorial(int cod_editorial, String nombre, String direccion, String telefono, String email) {
        this.cod_editorial = cod_editorial;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public int getCod_editorial() {
        return cod_editorial;
    }

    public void setCod_editorial(int cod_editorial) {
        this.cod_editorial = cod_editorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
