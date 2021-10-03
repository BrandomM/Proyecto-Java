package com.simecad.simecad.controller;

import com.simecad.simecad.domain.Venta;
import com.simecad.simecad.service.VentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/venta")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class VentaController {

    @Autowired
    VentaService ventaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Venta>> listarVentas() {
        return ResponseEntity.ok(ventaService.listarVentas());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Venta> buscarVentaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ventaService.buscarVentaPorId(id));
    }

    @PostMapping("/registrar")
    public ResponseEntity registrarVenta(@RequestBody Venta venta) {
        venta.setFecha(LocalDate.now());
        ventaService.registrarVenta(venta);

        return ResponseEntity.ok("Venta registrada exitosamene");
    }

    @PutMapping("/modificar")
    public ResponseEntity modificarVenta(@RequestBody Venta venta) {
        ventaService.modificarVenta(venta);
        return ResponseEntity.ok("Venta modificada exitosamente");
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity eliminarVenta(@RequestBody Venta venta) {
        try {
            ventaService.eliminarVenta(venta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se pudo eliminar el producto");
        }
        return ResponseEntity.ok("Venta eliminada con éxito");
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Venta>> ventasPorIdUsurio(@PathVariable Long id) {
        return ResponseEntity.ok(ventaService.ventasPorIdUsurio(id));
    }

}
