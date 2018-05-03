package com.biblioteca.model;

public class Libro_Publicacion {

    private int idLibroPublicacion;
    private String fPublicacion;
    private int cod_libro;
    private int cod_editorial;

    public Libro_Publicacion() {
    }

    public Libro_Publicacion(int idLibroPublicacion, String fPublicacion, int cod_libro, int cod_editorial) {
        this.idLibroPublicacion = idLibroPublicacion;
        this.fPublicacion = fPublicacion;
        this.cod_libro = cod_libro;
        this.cod_editorial = cod_editorial;
    }

    public int getIdLibroPublicacion() {
        return idLibroPublicacion;
    }

    public void setIdLibroPublicacion(int idLibroPublicacion) {
        this.idLibroPublicacion = idLibroPublicacion;
    }

    public String getfPublicacion() {
        return fPublicacion;
    }

    public void setfPublicacion(String fPublicacion) {
        this.fPublicacion = fPublicacion;
    }

    public int getCod_libro() {
        return cod_libro;
    }

    public void setCod_libro(int cod_libro) {
        this.cod_libro = cod_libro;
    }

    public int getCod_editorial() {
        return cod_editorial;
    }

    public void setCod_editorial(int cod_editorial) {
        this.cod_editorial = cod_editorial;
    }
}
