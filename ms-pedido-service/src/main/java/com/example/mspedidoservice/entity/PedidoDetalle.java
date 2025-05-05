package com.example.mspedidoservice.entity;

import com.example.mspedidoservice.dato.ProductoDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PedidoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double precio;
    private Double cantidad;
    private Integer productoId;

    @Transient
    private ProductoDto productoDto;

    public PedidoDetalle() {
        this.cantidad = (double) 0;
        this.precio = (double) 0;
    }



    public PedidoDetalle(Integer id, Double precio, Double cantidad, Integer productoId, ProductoDto productoDto) {
        this.id = id;
        this.precio = precio;
        this.cantidad = cantidad;
        this.productoId = productoId;
        this.productoDto = productoDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public ProductoDto getProductoDto() {
        return productoDto;
    }

    public void setProductoDto(ProductoDto productoDto) {
        this.productoDto = productoDto;
    }


}
