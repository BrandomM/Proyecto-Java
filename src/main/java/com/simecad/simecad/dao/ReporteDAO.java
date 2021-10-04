package com.simecad.simecad.dao;

import com.simecad.simecad.dto.report.CategoriaReportDTO;
import com.simecad.simecad.dto.report.ClienteReportDTO;
import com.simecad.simecad.dto.report.ProductoReportDTO;
import java.util.List;

public interface ReporteDAO {

    public List<ProductoReportDTO> reporteProductos();
    public List<CategoriaReportDTO> reporteCategorias();
    public List<ClienteReportDTO> reporteClientes();
    
}
