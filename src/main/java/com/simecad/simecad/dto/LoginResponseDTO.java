package com.simecad.simecad.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class LoginResponseDTO implements Serializable {

    private String token;
    private UsuarioDTO usuarioDTO;

}
