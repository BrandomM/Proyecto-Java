
package com.simecad.simecad.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class ContactRequestDTO implements Serializable {
    private String nombre;
    private String correo;
    private String mensaje;
}
