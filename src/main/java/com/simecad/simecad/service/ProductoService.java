package com.simecad.simecad.service;

import com.simecad.simecad.domain.Producto;
import java.util.List;

public interface ProductoService {

    List<Producto> listarProductos();
    Producto buscarProductoPorId(Long id);
    Producto registrarProducto(Producto producto);
    Producto modificarProducto(Producto producto);
    Producto eliminarProducto(Producto producto);

}
