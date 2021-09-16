
package com.simecad.simecad.service.Impl;

import com.simecad.simecad.dao.UsuarioDAO;
import com.simecad.simecad.domain.Usuario;
import com.simecad.simecad.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioDAO usuarioDAO;
    
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDAO.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioDAO.buscarUsuarioPorId(id);
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioDAO.save(usuario);
    }

    @Override
    public Usuario modificarUsuario(Usuario usuario) {
        return usuarioDAO.save(usuario);
    }

    @Override
    public Usuario eliminarUsuario(Usuario usuario) {
        usuarioDAO.delete(usuario);
        return usuario;
    }

    @Override
    public Usuario validarCredenciales(String correo, String contrasena) {
        return usuarioDAO.validarCredenciales(correo, contrasena);
    }

    @Override
    public boolean validarCorreo(String correo) {
        if(usuarioDAO.validarCorreo(correo).isEmpty()){
            return true;
        }
        return false;
    }
    
}
