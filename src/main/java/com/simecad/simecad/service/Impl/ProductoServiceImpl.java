package com.simecad.simecad.service.Impl;

import com.simecad.simecad.dao.ProductoDAO;
import com.simecad.simecad.domain.Producto;
import com.simecad.simecad.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoDAO productoDAO;

    @Override
    public List<Producto> listarProductos() {
        return productoDAO.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Long id) {
        return productoDAO.buscarProductoPorId(id);
    }

    @Override
    public Producto registrarProducto(Producto producto) {
        return productoDAO.save(producto);
    }

    @Override
    public Producto modificarProducto(Producto producto) {
        return productoDAO.save(producto);
    }

    @Override
    public Producto eliminarProducto(Producto producto) {
        productoDAO.delete(producto);
        return producto;
    }

    @Override
    public List<Producto> listarProductosDisponibles() {
        return productoDAO.listarProductosDisponibles();
    }

}
