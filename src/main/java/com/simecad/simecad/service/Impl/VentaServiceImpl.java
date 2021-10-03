package com.simecad.simecad.service.Impl;

import com.simecad.simecad.dao.VentaDAO;
import com.simecad.simecad.domain.Venta;
import com.simecad.simecad.service.VentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    VentaDAO ventaDAO;

    @Override
    public List<Venta> listarVentas() {
        return ventaDAO.findAll();
    }

    @Override
    public Venta buscarVentaPorId(Long id) {
        return ventaDAO.findById(id).orElse(null);
    }

    @Override
    public Venta registrarVenta(Venta venta) {
        return ventaDAO.save(venta);
    }

    @Override
    public Venta modificarVenta(Venta venta) {
        return ventaDAO.save(venta);
    }

    @Override
    public Venta eliminarVenta(Venta venta) {
        ventaDAO.delete(venta);
        return venta;
    }

    @Override
    public List<Venta> ventasPorIdUsurio(Long id) {
        return ventaDAO.ventasPorIdUsurio(id);
    }

}
