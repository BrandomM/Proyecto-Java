package com.simecad.simecad.service.Impl;

import com.simecad.simecad.domain.Producto;
import com.simecad.simecad.service.FileStorageService;
import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageServieImpl implements FileStorageService {

    static final String PRODUCTS_ABSOLUTE_STORAGE = "C:/xampp/htdocs/Almacenamiento/productos/";
    static final String PRODUCTS_LOCALHOST_STORAGE = "http://localhost/Almacenamiento/productos/";

    @Override
    public String almacenarFotoProducto(Producto producto, MultipartFile foto) throws IOException {

        long id = producto.getId();
        String nombreFoto = String.valueOf(id) + foto.getOriginalFilename();
        foto.transferTo(new File(PRODUCTS_ABSOLUTE_STORAGE + nombreFoto));

        return PRODUCTS_LOCALHOST_STORAGE + nombreFoto;
    }

}
