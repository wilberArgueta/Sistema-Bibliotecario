package com.biblioteca.model;

public class Libro_Autor {

    private int idLibroAutor;
    private int cod_libro;
    private int cod_autor;

    public Libro_Autor() {
    }

    public Libro_Autor(int idLibroAutor, int cod_libro, int cod_autor) {
        this.idLibroAutor = idLibroAutor;
        this.cod_libro = cod_libro;
        this.cod_autor = cod_autor;
    }

    public int getIdLibroAutor() {
        return idLibroAutor;
    }

    public void setIdLibroAutor(int idLibroAutor) {
        this.idLibroAutor = idLibroAutor;
    }

    public int getCod_libro() {
        return cod_libro;
    }

    public void setCod_libro(int cod_libro) {
        this.cod_libro = cod_libro;
    }

    public int getCod_autor() {
        return cod_autor;
    }

    public void setCod_autor(int cod_autor) {
        this.cod_autor = cod_autor;
    }
}
