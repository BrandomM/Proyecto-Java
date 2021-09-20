package com.simecad.simecad.controller;

import com.simecad.simecad.domain.Usuario;
import com.simecad.simecad.dto.LoginResponseDTO;
import com.simecad.simecad.dto.UsuarioDTO;
import com.simecad.simecad.service.UsuarioService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class LoginController {

    @Autowired
    UsuarioService usuarioService;
    
    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody Usuario usuario) {
        String correo = usuario.getCorreo();
        boolean disponible = usuarioService.validarCorreo(correo);
        
        if(disponible){
            usuario.setImagen("");
            usuario.setRol("Cliente");
            if(usuario.getCelular() == null){
                usuario.setCelular("");
            }
            usuarioService.registrarUsuario(usuario);
            return ResponseEntity.ok("Usuario registrado con éxito");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("El correo ya está en uso");
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Usuario usuario) {
        String correo = usuario.getCorreo();
        String contrasena = usuario.getContrasena();
        Usuario usuarioLogin = usuarioService.validarCredenciales(correo, contrasena);

        if (usuarioLogin != null) {
            
            LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
            loginResponseDTO.setToken("dsadhisaoidhsoai"); //Implementar después
            
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuarioLogin.getId());
            usuarioDTO.setNombre(usuarioLogin.getNombre());
            usuarioDTO.setRol(usuarioLogin.getRol());
            usuarioDTO.setImagen(usuarioLogin.getImagen());
            
            loginResponseDTO.setUsuarioDTO(usuarioDTO);

            return ResponseEntity.ok(loginResponseDTO);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña no válidas");
    }

}
