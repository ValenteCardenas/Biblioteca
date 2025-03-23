/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.capanegocio;

import com.example.demo.capanegocio.modelo.Usuario;
import com.example.demo.capapersistencia.UsuarioRepository;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vsfs2
 */
@Service
public class UserService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    
    public ArrayList <Usuario> recuperaUsuarios() {

		
		System.out.println("usuarioRepository = "+usuarioRepository);
		
		ArrayList <Usuario> usuarios = (ArrayList <Usuario>) usuarioRepository.findAll();
		
		return usuarios;
	}
    
    
    public Usuario agregaUsuario(String nombre, String apellido_pat, String apellido_mat, String correo, long telefono, String contrasena, LocalDate ultimo_acceso) {
			
		Usuario usuario = usuarioRepository.findByCorreo(correo);
		
		if(usuario != null) {
			throw new IllegalArgumentException("Un usuario con este correo ya existe");
		}
		
		// Crea el usuario
                usuario = new Usuario();
                usuario.setNombre(nombre);
                usuario.setApellidoPat(apellido_pat);
                usuario.setApellidoMat(apellido_mat);
                usuario.setCorreo(correo);
                usuario.setTelefono(telefono);
                usuario.setContrasena(contrasena);
                usuario.setTipoUsuario(0);
                usuario.setUltimoAcceso(ultimo_acceso);
                
                usuarioRepository.save(usuario);
	
		return usuario;

	}
    
}
