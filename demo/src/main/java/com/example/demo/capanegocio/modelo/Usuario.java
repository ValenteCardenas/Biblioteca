/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.capanegocio.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

    
    @Entity  // Marcamos que esta clase se va a convertir en una tabla en la BD 
public class Usuario {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // estrategía es cómo quiero que se genere ese id
    private long idUsuario;
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String correo;
    private long telefono;
    private String contrasena;    
    private int tipoUsuario; 
  
    private LocalDate ultimoAcceso;

    public long getidUsuario() {
        return idUsuario;
    }

    public void setidUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int TipoUsuario) {
        this.tipoUsuario = TipoUsuario;
    }

    public LocalDate getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(LocalDate ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }


    @Override
public String toString() {
    return "ID Usuario: " + idUsuario + "\n" +
           "Nombre: " + nombre + "\n" +
           "Apellido Paterno: " + apellidoPat + "\n" +
           "Apellido Materno: " + apellidoMat + "\n" +
           "Correo: " + correo + "\n" +
           "Teléfono: " + telefono + "\n" +
           "Contraseña: "+ contrasena + "\n"+ 
           "Tipo de Usuario: " + tipoUsuario + "\n" +
           "Último Acceso: " + ultimoAcceso + "\n";
}


    
    
    
}


