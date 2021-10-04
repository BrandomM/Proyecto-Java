package com.simecad.simecad.dao.impl;

import com.simecad.simecad.dto.report.CategoriaReportDTO;
import com.simecad.simecad.dto.report.ClienteReportDTO;
import com.simecad.simecad.dto.report.ProductoReportDTO;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.simecad.simecad.dao.ReporteDAO;

@Repository
public class ReporteDAOImpl implements ReporteDAO {

    @Autowired
    EntityManager entityManager;

//    @Override
//    public List<ProductReportDTO> reporteProductos() {
//        String query = "SELECT p.id AS id, p.name AS name, SUM(sp.quantity) AS number FROM sale_product sp JOIN product p ON p.id = sp.product_id GROUP BY p.name ORDER BY number DESC";
//        return entityManager.createNativeQuery(query, ProductReportDTO.class).getResultList();
//    }
    @Override
    public List<ProductoReportDTO> reporteProductos() {
        String query = "SELECT p.id AS id, p.nombre AS nombre, SUM(pv.cantidad) AS cantidad FROM productos_ventas pv JOIN productos p ON p.id = pv.productos_id GROUP BY p.id ORDER BY cantidad DESC";
        return entityManager.createNativeQuery(query, ProductoReportDTO.class).getResultList();
    }

    @Override
    public List<CategoriaReportDTO> reporteCategorias() {
        String query = "SELECT p.id AS id, p.categoria AS categoria, SUM(pv.cantidad) AS cantidad FROM productos_ventas pv JOIN productos p ON p.id = pv.productos_id GROUP BY p.categoria ORDER BY cantidad DESC";
        return entityManager.createNativeQuery(query, CategoriaReportDTO.class).getResultList();
    }

    @Override
    public List<ClienteReportDTO> reporteClientes() {
        String query = "SELECT u.id AS id, u.nombre AS nombre, SUM(pv.cantidad * pv.precio_unitario) AS total FROM productos_ventas pv JOIN ventas v ON v.id = pv.ventas_id JOIN usuarios u ON u.id = v.usuarios_id GROUP BY id ORDER BY total DESC";
        return entityManager.createNativeQuery(query, ClienteReportDTO.class).getResultList();
    }

}
