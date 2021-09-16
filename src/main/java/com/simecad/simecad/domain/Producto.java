package com.simecad.simecad.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "precio")
    private int precio;
    
    @Column(name = "disponibilidad")
    private int disponibilidad;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "categoria")
    private String categoria;
    
    @Column(name = "imagen")
    private String imagen;
    
}
