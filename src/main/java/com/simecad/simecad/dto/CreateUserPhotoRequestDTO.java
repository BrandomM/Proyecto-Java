package com.simecad.simecad.dto;

import java.io.Serializable;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CreateUserPhotoRequestDTO implements Serializable {

    private MultipartFile foto;
    private String nombre;
    private String correo;
    private String celular;
    private String rol;
}
