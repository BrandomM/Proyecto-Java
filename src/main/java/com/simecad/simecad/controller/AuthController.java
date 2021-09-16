package com.simecad.simecad.controller;

import com.simecad.simecad.domain.Usuario;
import com.simecad.simecad.service.UsuarioService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthController {

    @Autowired
    UsuarioService usuarioService;
    
    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody Usuario usuario) {
        String correo = usuario.getCorreo();
        boolean disponible = usuarioService.validarCorreo(correo);
        
        if(disponible){
            usuarioService.registrarUsuario(usuario);
            return ResponseEntity.ok("Usuario registrado con éxito");
        }
        return ResponseEntity.ok("El correo ya está en uso");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        String correo = usuario.getCorreo();
        String contrasena = usuario.getContrasena();
        Usuario usuarioLogin = usuarioService.validarCredenciales(correo, contrasena);

        if (usuarioLogin != null) {
            Map usuarioRespuesta = new HashMap();
            usuarioRespuesta.put("nombre", usuarioLogin.getNombre());
            usuarioRespuesta.put("imagen", usuarioLogin.getImagen());
            usuarioRespuesta.put("rol", usuarioLogin.getRol());
            
            Map respuesta = new HashMap();
            
            respuesta.put("token", "dsada");
            respuesta.put("usuario", usuarioRespuesta);

            return ResponseEntity.ok(respuesta);
        }
        return ResponseEntity.ok("Usuario o contraseña no válidas");
    }

}
