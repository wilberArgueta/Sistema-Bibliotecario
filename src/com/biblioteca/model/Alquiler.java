package com.biblioteca.model;

public class Alquiler extends Usuario {
    private int idAlquiler;
    private String fAdquirido;
    private  String fDevolucion;
    private int cod_usuario;
    private int cod_libro;

    public Alquiler() {
    }

    public Alquiler(int idAlquiler, String fAdquirido, String fDevolucion, int cod_usuario, int cod_libro) {
        this.idAlquiler = idAlquiler;
        this.fAdquirido = fAdquirido;
        this.fDevolucion = fDevolucion;
        this.cod_usuario = cod_usuario;
        this.cod_libro = cod_libro;
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public String getfAdquirido() {
        return fAdquirido;
    }

    public void setfAdquirido(String fAdquirido) {
        this.fAdquirido = fAdquirido;
    }

    public String getfDevolucion() {
        return fDevolucion;
    }

    public void setfDevolucion(String fDevolucion) {
        this.fDevolucion = fDevolucion;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public int getCod_libro() {
        return cod_libro;
    }

    public void setCod_libro(int cod_libro) {
        this.cod_libro = cod_libro;
    }
}
