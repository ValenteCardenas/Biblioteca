/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.capanegocio.modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 *
 * @author 100077515
 */
@Entity
public class Devolucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDevolucion;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    
    @OneToOne
    @JoinColumn(name = "id_prestamo")
    private Prestamo prestamo;

    @Column(nullable = false)
    private LocalDate fechaDevolucion;

    @Column
    private double multa;

    @Column
    private String estado; // "PAGADO", "PENDIENTE"

    public int getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(int idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Devolucion:" + "\n" +
               "  ID Devolucion: " + idDevolucion + "\n" +
               "  Usuario: " + (usuario != null ? usuario.toString() : "N/A") + "\n" +
               "  Prestamo ID: " + (prestamo != null ? prestamo.getIdPrestamo() : "N/A") + "\n" +
               "  Fecha de devolucion: " + fechaDevolucion + "\n" +
               "  Multa: " + multa + "\n" +
               "  Estado: " + estado;
    }
}
