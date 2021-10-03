package com.simecad.simecad.dao;

import com.simecad.simecad.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoDAO extends JpaRepository<Producto, Long> {

    @Query(value = "SELECT * FROM productos WHERE id = ?1 LIMIT 1", nativeQuery = true)
    public Producto buscarProductoPorId(Long id);

    @Query(value = "SELECT * FROM productos WHERE disponibilidad > 0", nativeQuery = true)
    public List<Producto> listarProductosDisponibles();
}
