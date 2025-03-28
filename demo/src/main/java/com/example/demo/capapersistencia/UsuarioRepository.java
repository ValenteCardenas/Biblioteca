/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.capapersistencia;

import com.example.demo.capanegocio.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vsfs2
 */

@Repository 
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByCorreo(String correo);
    
    
    
}
