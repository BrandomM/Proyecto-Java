
package com.simecad.simecad.dao;

import com.simecad.simecad.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
    
    @Query(value = "SELECT * FROM usuarios WHERE id = ?1 LIMIT 1", nativeQuery = true)
    public Usuario buscarUsuarioPorId(Long id);

    @Query(value = "SELECT * FROM usuarios WHERE correo = ?1 AND contrasena = ?2 LIMIT 1", nativeQuery = true)
    public Usuario validarCredenciales(String correo, String contrasena);
    
    @Query(value = "SELECT * FROM usuarios WHERE correo = ?1", nativeQuery = true)
    public List<Usuario> validarCorreo(String correo);
    
}
