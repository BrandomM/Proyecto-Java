package com.simecad.simecad.dao;

import com.simecad.simecad.domain.Venta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaDAO extends JpaRepository<Venta, Long> {

    @Query(value = "SELECT * FROM ventas WHERE usuarios_id = ?1", nativeQuery = true)
    public List<Venta> ventasPorIdUsurio(Long id);

}
