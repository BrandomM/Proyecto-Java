
package com.simecad.simecad.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class MessageToOneRequestDTO implements Serializable{
    private String destinatario;
    private String asunto;
    private String mensaje;
}
