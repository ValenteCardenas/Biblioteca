package com.example.demo;

import com.example.demo.capanegocio.UserService;
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
         UserService userService;
        @Autowired
        UsuarioRepository ur;
	public static void main(String[] args) {
         
         SpringApplication.run(DemoApplication.class, args);
         
         
         //UserService userService = context.getBean(UserService.class);
         
         

         
     }
        
       @PostConstruct
      public void testDB(){
          
        
          
         
          Usuario usuario = userService.agregaUsuario("Rodrigo", "Perez", "Luna", "rdl@gmail.com",
              4568, "contrasena3", LocalDate.now());
          
          
        ur.save(usuario);
        System.out.println(usuario);
          
          /*ArrayList<Usuario> usuarios = userService.recuperaUsuarios();
        
        System.out.println(usuarios);   
          
       */
      }
}
