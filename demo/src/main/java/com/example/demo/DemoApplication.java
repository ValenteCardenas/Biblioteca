package com.example.demo;

import com.example.demo.capanegocio.AutorService;
import com.example.demo.capanegocio.LibroService;
import com.example.demo.capanegocio.PrestamoService;
import com.example.demo.capanegocio.UserService;
import com.example.demo.capanegocio.modelo.Autor;
import com.example.demo.capanegocio.modelo.Libro;
import com.example.demo.capanegocio.modelo.Prestamo;
import com.example.demo.capanegocio.modelo.Usuario;
import com.example.demo.capapersistencia.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo"})
public class DemoApplication {

    @Autowired
    private UserService userService;

    @Autowired
    private AutorService autorService;

    @Autowired
    private LibroService libroService;
    
    @Autowired
    private PrestamoService prestamoService;
    
	public static void main(String[] args) {
      
         SpringApplication.run(DemoApplication.class, args);
         
         
         //UserService userService = context.getBean(UserService.class);
         
         

         
     }
        
       @PostConstruct
      public void testDB(){
          
        Usuario usuario1 = userService.agregaUsuario("Juan", "Pérez", "Gómez", "juan@example.com", 1234567890L, "password1", LocalDate.now());
        Usuario usuario2 = userService.agregaUsuario("María", "López", "Martínez", "maria@example.com", 9876543210L, "password2", LocalDate.now());
        Usuario usuario3 = userService.agregaUsuario("Carlos", "García", "Sánchez", "carlos@example.com", 2281463024L, "password3", LocalDate.now());
          
         // Agregar autores
        Autor autor1 = autorService.agregaAutor("Gabriel García Márquez", "Colombiano");
        Autor autor2 = autorService.agregaAutor("J.K. Rowling", "Británica");
        Autor autor3 = autorService.agregaAutor("George Orwell", "Británico");

        // Agregar libros (2 por autor)
        Libro libro1 = libroService.agregaLibro("Cien años de soledad", "Sudamericana", 1967, 10, autor1);
        Libro libro2 = libroService.agregaLibro("El amor en los tiempos del cólera", "Sudamericana", 1985, 5, autor1);
        Libro libro3 = libroService.agregaLibro("Harry Potter y la piedra filosofal", "Salamandra", 1997, 15, autor2);
        Libro libro4 = libroService.agregaLibro("Harry Potter y la cámara secreta", "Salamandra", 1998, 12, autor2);
        Libro libro5 = libroService.agregaLibro("1984", "Debolsillo", 1949, 8, autor3);
        Libro libro6 = libroService.agregaLibro("Rebelión en la granja", "Debolsillo", 1945, 7, autor3);
      
        //Agregar préstamos (2 por usuario)
        // Usuario ID: 1 (Juan Pérez Gómez)
        
        prestamoService.creaPrestamo(1L, 1L); // Libro ID: 1, Usuario ID: 1
        prestamoService.creaPrestamo(3L, 1L); // Libro ID: 3, Usuario ID: 1

        // Usuario ID: 2 (María López Martínez)
        prestamoService.creaPrestamo(2L, 2L); // Libro ID: 2, Usuario ID: 2
        prestamoService.creaPrestamo(5L, 2L); // Libro ID: 5, Usuario ID: 2
      
      
        ArrayList<Prestamo> prestamos = prestamoService.recuperaPrestamos();
        System.out.println(prestamos);



      }
}
