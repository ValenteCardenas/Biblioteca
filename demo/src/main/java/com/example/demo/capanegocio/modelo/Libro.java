package com.example.demo.capanegocio.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class Libro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLibro;
    
    @Column(nullable = false, length = 250)
    private String titulo;
    
    @Column(nullable = false, length = 100)
    private String editorial;
    
    @Column(nullable = false, length = 20)
    private int anio;
    
    @Column(nullable = false)
    private int cantidad;
    
    @ManyToOne  // Muchos libros pueden pertecer a un autor 
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

    public int getidLibro() {
        return idLibro;
    }

    public void setidLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

}
