package com.simecad.simecad.service.Impl;

import com.simecad.simecad.dao.ReporteDAO;
import com.simecad.simecad.dto.report.CategoriaReportDTO;
import com.simecad.simecad.dto.report.ClienteReportDTO;
import com.simecad.simecad.dto.report.ProductoReportDTO;
import com.simecad.simecad.service.ReporteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteServiceImpl implements ReporteService {

    @Autowired
    ReporteDAO reporteDAO;

    @Override
    public List<ProductoReportDTO> reporteProductos() {
        return reporteDAO.reporteProductos();
    }

    @Override
    public List<CategoriaReportDTO> reporteCategorias() {
        return reporteDAO.reporteCategorias();
    }

    @Override
    public List<ClienteReportDTO> reporteClientes() {
        return reporteDAO.reporteClientes();
    }

}
