package com.simecad.simecad.controller;

import com.simecad.simecad.dto.report.CategoriaReportDTO;
import com.simecad.simecad.dto.report.ClienteReportDTO;
import com.simecad.simecad.dto.report.ProductoReportDTO;
import com.simecad.simecad.service.ReporteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reporte")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReporteController {

    @Autowired
    ReporteService reporteService;

    @GetMapping("/producto")
    public ResponseEntity<List<ProductoReportDTO>> reporteProductos() {
        return ResponseEntity.ok(reporteService.reporteProductos());
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<CategoriaReportDTO>> reporteCategorias() {
        return ResponseEntity.ok(reporteService.reporteCategorias());
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<ClienteReportDTO>> reporteClientes() {
        return ResponseEntity.ok(reporteService.reporteClientes());
    }
}
