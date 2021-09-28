package com.simecad.simecad.controller;

import com.simecad.simecad.domain.Producto;
import com.simecad.simecad.dto.CreateProductPhotoRequestDTO;
import com.simecad.simecad.dto.ProductoImportDTO;
import com.simecad.simecad.dto.UpdateProductPhotoRequestDTO;
import com.simecad.simecad.service.FileStorageService;
import com.simecad.simecad.service.ProductoService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @Autowired
    FileStorageService fileStorageService;

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listarProductos() {
        return ResponseEntity.ok(productoService.listarProductos());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.buscarProductoPorId(id));
    }

    @PostMapping("/registrar")
    public ResponseEntity registrarProducto(@RequestBody Producto producto) {

        producto.setImagen("");
        productoService.registrarProducto(producto);

        return ResponseEntity.ok("Producto creado exitosamente");
    }

    @PutMapping("/modificar")
    public ResponseEntity modificarProducto(@RequestBody Producto producto) {
        productoService.modificarProducto(producto);
        return ResponseEntity.ok("Producto registrado exitosamente");
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity eliminarProducto(@RequestBody Producto producto) {
        try {
            productoService.eliminarProducto(producto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se pudo eliminar el producto");
        }
        return ResponseEntity.ok("Producto eliminado con éxito");
    }

    @PostMapping("/importar")
    public ResponseEntity importarProductos(@RequestBody List<ProductoImportDTO> listaProductosDTO) {

        try {
            listaProductosDTO.stream().map(productoImportDTO -> {
                Producto producto = new Producto();
                producto.setNombre(productoImportDTO.getNombre());
                producto.setPrecio(productoImportDTO.getPrecio());
                producto.setDisponibilidad(productoImportDTO.getDisponibilidad());
                producto.setEstado(productoImportDTO.getEstado());
                producto.setDescripcion(productoImportDTO.getDescripcion());
                producto.setCategoria(productoImportDTO.getCategoria());
                producto.setImagen("");

                return producto;
            }).forEachOrdered(producto -> {
                productoService.registrarProducto(producto);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Documento mal formateado");
        }
        return ResponseEntity.ok("Productos registrados con éxito");
    }

    @PostMapping("/registrarConFoto")
    public ResponseEntity registrarConFoto(@ModelAttribute CreateProductPhotoRequestDTO createProductPhotoRequestDTO) throws IOException {

        Producto producto = new Producto();

        producto.setNombre(createProductPhotoRequestDTO.getNombre());
        producto.setPrecio(createProductPhotoRequestDTO.getPrecio());
        producto.setDisponibilidad(createProductPhotoRequestDTO.getDisponibilidad());
        producto.setEstado(createProductPhotoRequestDTO.getEstado());
        producto.setDescripcion(createProductPhotoRequestDTO.getDescripcion());
        producto.setCategoria(createProductPhotoRequestDTO.getCategoria());

        producto = productoService.registrarProducto(producto);

        String imagen = fileStorageService.almacenarFotoProducto(producto, createProductPhotoRequestDTO.getFoto());
        producto.setImagen(imagen);

        productoService.modificarProducto(producto);

        return ResponseEntity.ok("Recibido");
    }

    @PutMapping("/modificarConFoto")
    public ResponseEntity modificarConFoto(@ModelAttribute UpdateProductPhotoRequestDTO updateProductPhotoRequestDTO) throws IOException {
        Producto producto = productoService.buscarProductoPorId(updateProductPhotoRequestDTO.getId());

        producto.setNombre(updateProductPhotoRequestDTO.getNombre());
        producto.setPrecio(updateProductPhotoRequestDTO.getPrecio());
        producto.setDisponibilidad(updateProductPhotoRequestDTO.getDisponibilidad());
        producto.setEstado(updateProductPhotoRequestDTO.getEstado());
        producto.setDescripcion(updateProductPhotoRequestDTO.getDescripcion());
        producto.setCategoria(updateProductPhotoRequestDTO.getCategoria());

        String imagen = fileStorageService.almacenarFotoProducto(producto, updateProductPhotoRequestDTO.getFoto());
        producto.setImagen(imagen);

        productoService.modificarProducto(producto);

        return ResponseEntity.ok("Recibido");
    }

}
