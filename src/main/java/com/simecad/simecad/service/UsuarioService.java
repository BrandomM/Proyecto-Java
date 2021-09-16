
package com.simecad.simecad.service;

import com.simecad.simecad.domain.Usuario;
import java.util.List;


public interface UsuarioService {
    
    List<Usuario> listarUsuarios();
    Usuario buscarUsuarioPorId(Long id);
    Usuario registrarUsuario(Usuario usuario);
    Usuario modificarUsuario(Usuario usuario);
    Usuario eliminarUsuario(Usuario usuario);
    Usuario validarCredenciales(String correo, String contrasena);
    boolean validarCorreo(String correo);
    
}
