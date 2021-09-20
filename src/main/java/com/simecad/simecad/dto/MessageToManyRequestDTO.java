package com.simecad.simecad.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class MessageToManyRequestDTO implements Serializable {

    private String[] destinatarios;
    private String asunto;
    private String mensaje;
}
