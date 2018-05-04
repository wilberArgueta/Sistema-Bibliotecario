package com.biblioteca.model;

public class Autor extends Editorial{
    private int cod_autor;
    private String nombre;
    private String apellido;
    private String f_nacimiento;
    private String nacionalidad;
    private String email;


    public Autor() {
    }

    public Autor(int cod_autor, String nombre, String apellido, String f_nacimiento, String nacionalidad, String email) {
        this.cod_autor = cod_autor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.f_nacimiento = f_nacimiento;
        this.nacionalidad = nacionalidad;
        this.email = email;
    }

    public int getCod_autor() {
        return cod_autor;
    }

    public void setCod_autor(int cod_autor) {
        this.cod_autor = cod_autor;
    }

    public String getNombreAutor() {
        return nombre;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombre = nombreAutor;
    }

    public String getApellidoAutor() {
        return apellido;
    }

    public void setApellidoAutor(String apellido) {
        this.apellido = apellido;
    }

    public String getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(String f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
