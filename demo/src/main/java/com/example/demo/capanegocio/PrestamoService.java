/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.capanegocio;

import com.example.demo.capanegocio.modelo.Libro;
import com.example.demo.capanegocio.modelo.Prestamo;
import com.example.demo.capanegocio.modelo.Usuario;
import com.example.demo.capapersistencia.LibroRepository;
import com.example.demo.capapersistencia.PrestamoRepository;
import com.example.demo.capapersistencia.UsuarioRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vsfs2
 */
@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Recupera todos los préstamos de la base de datos.
     *
     * @return Lista de préstamos.
     */
    public ArrayList<Prestamo> recuperaPrestamos() {
        System.out.println("prestamoRepository = " + prestamoRepository);

        // Convertimos el Iterable a ArrayList
      
        ArrayList<Prestamo> prestamos = (ArrayList<Prestamo>) prestamoRepository.findAll();
    
        return prestamos;
    }
    /**
 * Crea un nuevo préstamo y lo guarda en la base de datos.
 *
 * @param idLibro     ID del libro prestado.
 * @param idUsuario   ID del usuario que realiza el préstamo.
 * @return El préstamo creado.
 * @throws IllegalArgumentException Si el libro o el usuario no existen, o si el libro no está disponible.
 */
public Prestamo creaPrestamo(Long idLibro, Long idUsuario) {
    // Verifica si el libro existe
    
    Libro libro = libroRepository.findById(idLibro)
            .orElseThrow(() -> new IllegalArgumentException("El libro no existe"));

    // Verifica si el usuario existe
    Usuario usuario = usuarioRepository.findById(idUsuario)
            .orElseThrow(() -> new IllegalArgumentException("El usuario no existe"));

    // Verifica si hay ejemplares disponibles del libro
    if (libro.getCantidad() <= 0) {
        throw new IllegalArgumentException("No hay ejemplares disponibles del libro");
    }

    // Crea el préstamo
    Prestamo prestamo = new Prestamo();
    prestamo.setLibro(libro);
    prestamo.setUsuario(usuario);
    prestamo.setFechaPrestamo(LocalDate.now()); // Fecha actual
    prestamo.setFechaLimite(LocalDate.now().plusDays(14)); // 14 días después

    // Guarda el préstamo en la base de datos
    prestamoRepository.save(prestamo);

    // Reduce la cantidad de ejemplares disponibles del libro
    libro.setCantidad(libro.getCantidad() - 1);
    libroRepository.save(libro);

    return prestamo;
}
    
}
