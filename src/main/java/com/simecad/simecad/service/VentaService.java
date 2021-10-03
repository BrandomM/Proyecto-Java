package com.simecad.simecad.service;

import com.simecad.simecad.domain.Venta;
import java.util.List;

public interface VentaService {

    List<Venta> listarVentas();

    Venta buscarVentaPorId(Long id);

    Venta registrarVenta(Venta venta);

    Venta modificarVenta(Venta venta);

    Venta eliminarVenta(Venta venta);

    List<Venta> ventasPorIdUsurio(Long id);
}
