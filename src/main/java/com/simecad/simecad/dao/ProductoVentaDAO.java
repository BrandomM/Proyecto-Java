
package com.simecad.simecad.dao;

import com.simecad.simecad.domain.ProductoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoVentaDAO extends JpaRepository<ProductoVenta, Long>{
    
}
