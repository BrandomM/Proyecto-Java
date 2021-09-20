package com.simecad.simecad.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class UsuarioDTO implements Serializable {

    private long id;
    private String nombre;
    private String imagen;
    private String rol;

}
