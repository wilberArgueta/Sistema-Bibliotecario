package com.biblioteca.model;

public class Libro extends Autor {


    private int cod_libro;
    private String titulo;
    private String ISBM;

    public Libro() {
    }

    public Libro(int cod_libro, String titulo, String ISBM) {
        this.cod_libro = cod_libro;
        this.titulo = titulo;
        this.ISBM = ISBM;
    }

    public int getCod_libro() {
        return cod_libro;
    }

    public void setCod_libro(int cod_libro) {
        this.cod_libro = cod_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBM() {
        return ISBM;
    }

    public void setISBM(String ISBM) {
        this.ISBM = ISBM;
    }
}
