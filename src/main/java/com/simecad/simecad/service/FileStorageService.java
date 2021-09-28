package com.simecad.simecad.service;

import com.simecad.simecad.domain.Producto;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    public String almacenarFotoProducto(Producto producto, MultipartFile foto) throws IOException;

}
