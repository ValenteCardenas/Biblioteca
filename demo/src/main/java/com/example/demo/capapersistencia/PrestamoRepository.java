/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.capapersistencia;

import com.example.demo.capanegocio.modelo.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
/**
 *
 * @author vsfs2
 */
@Repository 
public interface PrestamoRepository extends CrudRepository <Prestamo, Long> {
    public ArrayList<Prestamo> findByUsuarioIdUsuario (Long idUsuario);
    
    
} 
=======
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
    
    List<Prestamo> findByFechaDevolucionIsNullAndFechaLimiteBefore(LocalDate fecha);
    
    List<Prestamo> findByMultaPagadaFalseAndFechaDevolucionIsNotNullAndMultaAcumuladaGreaterThan(double cantidad);
    
    List<Prestamo> findByUsuarioIdUsuario(int idUsuario);

    public Object findById(Long idPrestamo);

    public List<Prestamo> findByMultaAcumuladaGreaterThanAndMultaPagadaFalse(double d);
}
>>>>>>> 123360032bdd24dbfd6445eedeaf0e37a6786f9f
