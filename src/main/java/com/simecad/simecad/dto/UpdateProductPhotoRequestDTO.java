
package com.simecad.simecad.dto;

import java.io.Serializable;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UpdateProductPhotoRequestDTO implements Serializable {
    private MultipartFile foto;
    private Long id;
    private String nombre;
    private int precio;
    private int disponibilidad;
    private String estado;
    private String descripcion;
    private String categoria;
    private String imagen;
}
