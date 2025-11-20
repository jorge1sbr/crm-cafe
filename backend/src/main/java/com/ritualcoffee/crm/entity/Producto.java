package com.ritualcoffee.crm.entity;

import jakarta.persistence.*;

@Entity //“Esta clase representa una tabla de la base de datos”.
@Table(name = "producto") //“Esta entidad está asociada a la tabla llamada producto”.
public class Producto {

    @Id //“Este campo es la clave primaria de la tabla”.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //“Esta columna se autoincrementa en la BBDD”.
    @Column(name = "id_producto") //“Este campo de la clase corresponde a la columna llamada id_producto en MySQL”.
    private Integer id;

    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private String categoria;   // CAPSULA / MAQUINA / GRANO
    private String tipo;        // VERDE / ROJO / GOLDEN / etc.
    private Double precio;
    private String imagen;      // nombre o ruta del archivo

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }
}
