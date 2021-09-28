
package com.simecad.simecad.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class UsuarioImportDTO implements Serializable {
    private String nombre;
    private String correo;
    private String celular;
    private String rol;
}
