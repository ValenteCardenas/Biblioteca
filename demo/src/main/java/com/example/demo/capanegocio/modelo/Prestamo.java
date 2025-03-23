package com.example.demo.capanegocio.modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrestamo;

    @ManyToOne
    @JoinColumn(name = "idLibro", nullable = false)
    private Libro libro;  // Cambiado de idLibro a libro

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;  // Cambiado de id_usuario a usuario

    @Column(nullable = false)
    private LocalDate fechaPrestamo;

    @Column(nullable = false)
    private LocalDate fechaLimite;

    // Getters y setters
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }
    
    // Método toString
    @Override
public String toString() {
    return "Prestamo:" + "\n"+
           "  ID Prestamo: " + idPrestamo + "\n" +
           "  Libro: " + (libro != null ? libro.getTitulo() : "N/A") + "\n" +
           "  Usuario: " + (usuario != null ? usuario.getNombre() : "N/A") + "\n" +
           "  Fecha de prestamo: " + fechaPrestamo + "\n" +
           "  Fecha limite: " + fechaLimite;
}
    
}