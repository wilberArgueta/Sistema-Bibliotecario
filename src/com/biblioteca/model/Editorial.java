package com.biblioteca.model;

public class Editorial{

    private  int cod_editorial;
    private String nombreEditorial;
    private String direccion;
    private String telefono;
    private String email;

    public Editorial() {
    }

    public Editorial(int cod_editorial, String nombreEditorial, String direccion, String telefono, String email) {
        this.cod_editorial = cod_editorial;
        this.nombreEditorial = nombreEditorial;
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

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
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
