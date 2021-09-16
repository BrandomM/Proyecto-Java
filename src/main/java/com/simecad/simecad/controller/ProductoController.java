package com.simecad.simecad.controller;

import com.simecad.simecad.domain.Producto;
import com.simecad.simecad.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listarProductos() {
        return ResponseEntity.ok(productoService.listarProductos());
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.buscarProductoPorId(id));
    }
    
    @PostMapping("/registrar")
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.registrarProducto(producto));
    }
    
    @PutMapping("/modificar")
    public ResponseEntity<Producto> modificarProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.modificarProducto(producto));
    }
    
    @DeleteMapping("/eliminar")
    public ResponseEntity<Producto> eliminarProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.eliminarProducto(producto));
    }

}
