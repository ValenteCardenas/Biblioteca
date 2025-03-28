/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.capanegocio;

import com.example.demo.capanegocio.modelo.Autor;
import com.example.demo.capanegocio.modelo.Libro;
import com.example.demo.capapersistencia.LibroRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vsfs2
 */
@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    /**
     * Recupera todos los libros de la base de datos.
     *
     * @return Lista de libros.
     */
    public ArrayList<Libro> recuperaLibros() {
        System.out.println("libroRepository = " + libroRepository);

        ArrayList<Libro> libros = (ArrayList<Libro>) libroRepository.findAll();
        return libros;
    }

    /**
     * Agrega un nuevo libro a la base de datos.
     *
     * @param titulo     Título del libro.
     * @param editorial  Editorial del libro.
     * @param anio       Año de publicación del libro.
     * @param cantidad   Cantidad de ejemplares disponibles.
     * @param autor      Autor del libro.
     * @return El libro creado.
     * @throws IllegalArgumentException Si ya existe un libro con el mismo título.
     */
    public Libro agregaLibro(String titulo, String editorial, int anio, int cantidad, Autor autor) {
        // Verifica si ya existe un libro con el mismo título
        Libro libroExistente = libroRepository.findByTitulo(titulo);

        if (libroExistente != null) {
            throw new IllegalArgumentException("Un libro con este título ya existe");
        }

        // Crea el libro
        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setEditorial(editorial);
        libro.setAnio(anio);
        libro.setCantidad(cantidad);
        libro.setAutor(autor);

        // Guarda el libro en la base de datos
        libroRepository.save(libro);

        return libro;
    }

    //Método para recuperar una lista de libros por su autor
    public ArrayList<Libro> recuperaLibrosPorAutor(String autor) {
        List<Libro> libros = libroRepository.findByAutor(autor);
        //Si no existen libros con ese autor
        if (libros.isEmpty()) {
            throw new IllegalArgumentException("No existen libros con ese autor");
        }
        return new ArrayList<>(libros);
    }
}