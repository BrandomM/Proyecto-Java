package com.simecad.simecad.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UpdateUserPhotoRequestDTO {
    private MultipartFile foto;
    private String nombre;
    private String correo;
    private String celular;
    private String rol;
    private long id;
    private String contrasena;
    private String imagen;
}
