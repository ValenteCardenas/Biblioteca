/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.capapersistencia;

import com.example.demo.capanegocio.modelo.Libro;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author vsfs2
 */
@Repository
public interface LibroRepository extends CrudRepository <Libro, Long> {
    public Libro findByTitulo(String titulo); 
    public List<Libro> findByAutor(String autor);
    public List<Libro> findBySucursal(String sucursal);
}
