package com.simecad.simecad.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class ProductoImportDTO implements Serializable {
    private String nombre;
    private int precio;
    private int disponibilidad;
    private String estado;
    private String descripcion;
    private String categoria;
}
